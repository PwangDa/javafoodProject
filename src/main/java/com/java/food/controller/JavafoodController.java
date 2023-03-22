package com.java.food.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.java.food.dto.AlbumDTO;
import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
import com.java.food.dto.GenreDTO;
import com.java.food.dto.PlayListDTO;
import com.java.food.service.JavafoodService;

@Controller
public class JavafoodController {
	private static final Logger log = LoggerFactory.getLogger(JavafoodController.class);

	@Autowired
	JavafoodService javaService;

////////////////////////////////////////////////////////////
	// 다영
	@RequestMapping(value = "/artistpage", method = RequestMethod.GET)
	public String java1(Model model, 
			HttpServletRequest re,
			@RequestParam("artist") String artist) {
		System.out.println("아티스트페이지 접속");
		System.out.println("artist >" + artist);
		// 아티스트 소개 페이지 출력 메소드(전달요소 > 아티스트명)
		List artist_list = javaService.getArtist(artist);
		// 댓글 출력 메소드(전달요소 > 아티스트명)
		List comment_list = javaService.getComment(artist);
		Object id = re.getSession().getAttribute("loginId");
		Object nic = re.getSession().getAttribute("loginNic");
		Object img = re.getSession().getAttribute("loginImg");
		System.out.println("id >>>>>>"+id);
		System.out.println("nic >>>>>>"+nic);
		
		model.addAttribute("album_list", artist_list);
		model.addAttribute("commentList", comment_list);
		model.addAttribute("nic", nic);
		model.addAttribute("img", img);
		
		return "/artistpage";

	}

	// 댓글 등록 할 때
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insert(Model model, 
			HttpServletRequest re,
			@ModelAttribute CommentDTO dto, 
			@RequestParam("id") String id,
			@RequestParam("cont") String cont, 
			@RequestParam("myimg") String ima,
			@RequestParam("songnum") String songnum, 
			@RequestParam("arti") String arti
	/* @RequestParam("command_articleNO") int arino */
	) {
		
		//로그인 한 id 와 닉네임 / 이미지의 세션값을 가져왔다.
		Object login_id = re.getSession().getAttribute("loginId");
		Object nic = re.getSession().getAttribute("loginNic");
		Object img = re.getSession().getAttribute("loginImg");
		
		System.out.println(">>>>>" + login_id);
		System.out.println(">>>>>" + cont);
		System.out.println(">>>>>" + ima);
		System.out.println(">>>>>" + nic);
		System.out.println(">>>>>" + arti);

		dto.setComment_id((String)nic);
		dto.setComment_cont(cont);
		dto.setMyimg((String) img);
		dto.setArtistname(arti);
		dto.setId((String)login_id);
		String encodeResult = null;
		try {
			encodeResult = URLEncoder.encode(arti, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("댓글등록 메소드 접속");
		System.out.println("아이디 >" + dto.getComment_id());
		System.out.println("내용 >" + dto.getComment_cont());
		int count = javaService.insertComment(dto);
		System.out.println("count >>>" + count);

		return "redirect:/artistpage?artist=" + encodeResult;
	}

	// 대댓글 등록할 때
	@RequestMapping(value = "/reply.do", method = RequestMethod.POST)
	public String reply(Model model, 
			HttpServletRequest re,
			@ModelAttribute CommentDTO dto, 
			@RequestParam("id_2") String id,
			@RequestParam("cont_2") String cont, 
			@RequestParam("command_myimg") String ima,
			@RequestParam("command_articleNO") int article, 
			@RequestParam("arti") String arti
			) {
		
		Object login_id = re.getSession().getAttribute("loginId");
		Object nic = re.getSession().getAttribute("loginNic");
		Object img = re.getSession().getAttribute("loginImg");
		
		System.out.println(">>>>>" + id);
		System.out.println(">>>>>" + cont);
		System.out.println(">>>>>" + ima);
		System.out.println("article >>>>>" + article);
		System.out.println(">>>>>" + arti);

		dto.setComment_id(id);
		dto.setComment_cont(cont);
		dto.setMyimg(ima);
		dto.setArtistname(arti);
		dto.setParentNO(article);
		dto.setId((String)login_id);

		String encodeResult = null;
		try {
			encodeResult = URLEncoder.encode(arti, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("댓글등록 메소드 접속");
		System.out.println("아이디 >" + dto.getComment_id());
		System.out.println("내용 >" + dto.getComment_cont());
		System.out.println("ParentNO >" + dto.getParentNO());
		int count = javaService.replyComment(dto);
		System.out.println("count >>>" + count);

		return "redirect:/artistpage?artist=" + encodeResult;
	}

	// 댓글 삭제할 때
	@RequestMapping(value = "/del.do", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delet(Model model, 
			HttpServletRequest re,
			@ModelAttribute CommentDTO dto, 
			@RequestParam("command_articleNO") int no,
			@RequestParam("arti") String arti,
			@RequestParam("command_nic") String nic,
			@RequestParam("command_id") String id) {
		
		Object login_id = re.getSession().getAttribute("loginId");
		Object nic_o = re.getSession().getAttribute("loginNic");
		System.out.println("댓글삭제 메소드 접속");
		System.out.println("no>>>>>" + no);
		System.out.println("arti>>>>>" + arti);
		System.out.println("로그인한 아이디 이름>>>>>" + login_id);
		System.out.println("로그인한 닉네임 이름>>>>>" + nic_o);
		
		System.out.println("삭제할 사람댓글의 id>>>>>" + id);
		System.out.println("삭제할 사람댓글의 nic>>>>>" + nic);
		
//		if(nic_o.equals(nic)) {
//			int article = javaService.delComment(no);
//		}
		if(login_id.equals(id)) {
			int article = javaService.delComment(no);
		}
		

		/* int article = javaService.delComment(no); */

		String encodeResult = null;
		try {
			encodeResult = URLEncoder.encode(arti, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/artistpage?artist=" + encodeResult;
	}

	// 앨범수록곡 페이지 들어갈 때
	@RequestMapping(value = "/albumpage", method = RequestMethod.GET)
	public String java1_1(Model model, @RequestParam("album") String album) {
		System.out.println("앨범페이지 접속");
		System.out.println("album >>" + album);
		// 아티스트 소개 페이지 출력 메소드(전달요소 > 아티스트명)
		List album_list = javaService.getAlbum(album);
		// 댓글 출력 메소드(전달요소 > 아티스트명)

		model.addAttribute("album_list", album_list);

		return "/Album";
	}
	
	
	// 앨범정보를 추가하는 메소드
	@RequestMapping(value = "/albumplus", method = RequestMethod.GET)
	public String albumplus(Model model, 
			@ModelAttribute AlbumDTO dto,
			@RequestParam("album_num") String al_num,
			@RequestParam("album_cover") String cover, 
			@RequestParam("album_name") String al_name, 
			@RequestParam("album_into") String al_into,
			@RequestParam("artistname") String artist_name ) {
		System.out.println("새 앨범을 추가합니다");
			dto.setAlbum_num(al_num);
			dto.setAlbum_cover(cover);
			dto.setAlbum_name(al_name);
			dto.setAlbum_into(al_into);
			dto.setArtistname(artist_name);
			
			int count = javaService.albumplus(dto);
		
		return "redirect:/insert_song?page=c";
	}
	
	// 아티스트정보를 추가하는 메소드
	@RequestMapping(value = "/artistplus")
	public String artistplus(Model model, 
			@ModelAttribute AlbumDTO dto) {
		System.out.println("!!!아티스트 추가!!!!");

		
		int count = javaService.artistplus(dto);
		
		return "redirect:/insert_song?page=b";
	}

	@RequestMapping(value = "/plus")
	public String java1_1(Model model) {

		return "/hdy/songplus";
	}
////////////////////////////////////////////////////////////
	// 귀범
//	@RequestMapping(value = "/chart", method = RequestMethod.GET)
//	public String java2_1(Model model, @RequestParam(value = "chart" , required = false) String chart) {
//		System.out.println("chart 페이지");
//		System.out.println("chart : " + chart);
//		List chartlist = javaService.getChart(chart);
//		
//		model.addAttribute("chartlist",chartlist);
//		model.addAttribute("")
//		// 결과 페이지로 리턴
//		return "chart/chart";
//
//	}

	// 차트 + 페이징
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart(Model model, HttpServletRequest req) {
		List<FamousChartDTO> list = new ArrayList();	//list 선언 (dto 값은 아무것도없음 아직) , new ArrayList(); : 구현체, List<FamousChartDTO> list : 인터페이스
		int pageNum = 1;
		int countPerPage = 20;
		
		String country = req.getParameter("country");	//country에 담겨있는 것을 country 변수에 담음
//		System.out.println(country);
//		if(country == null) {
//			country = "all";
//		}
			
		// Map chart = javaService.chart(country, pageNum, countPerPage); 있으니까 주석 처리 해도 무관함
//		Map map = javaService.chart(country, pageNum, countPerPage);
		
//		 map.put("list", list); : "list" 값 가져옴
//		map.get("list");
		
//		if (req.getParameter("country") != null) {
//			country = req.getParameter("country");
//			}
		
				// 페이징
				String temp_pageNum = req.getParameter("pageNum");
				if (temp_pageNum != null) {
					pageNum = Integer.parseInt(temp_pageNum);
				}
				System.out.println("pageNum : " + pageNum);
				System.out.println("countPerPage : " + countPerPage);
				Map chart = javaService.chart(country, pageNum, countPerPage);
				model.addAttribute("list", chart.get("list"));
				model.addAttribute("totalCount", chart.get("totalCount"));
				model.addAttribute("pageNum", pageNum);
				model.addAttribute("countPerPage", countPerPage);
				model.addAttribute("country", country);


//				return "chart/chart";
				return "/chart";

//		if(country == null ) {
//			country = "대한민국";
//		}
		
//		  if("일본".equals(country)) {
//	
//	
//		  
//		 }else if("미국".equals(country)) {
//
//		  
//		  }else if(country == null) { 
//			  System.out.println("null");
//			  country = "대한한국"; 
//
//		  }
//		 

		
//


	}

	// 조회수 증가 메소드
	@RequestMapping(value = "/addhit", method = RequestMethod.GET)
	public String addhit(HttpServletRequest request) {

		String id = "id2";
		String songnumber = request.getParameter("songNumber");
		String page = request.getParameter("pageNum");
		javaService.addhit(id, songnumber);

		return "redirect:/chart?pageNum=" + page;

	}

	@RequestMapping(value = "/beom", method = RequestMethod.GET)
	public String selectDance(Model model, HttpServletRequest request) {
		
		String page = "/selectdance"; // /beom 접근 시 selectdance.jsp로 들어오도록 지정
		
		String genre =(String) request.getAttribute("bygenre");
		// List 선언 해서 DTO 값 가져오기
		// Service에서 selectDance 메소드 실행 ( select , 전달인자 x )
		  List<FamousChartDTO> list = javaService.selectDance(genre);
		
		// Model 써서 addAttribute 해서 값 전달
		 model.addAttribute("list", list); 
		 
		
		// db에서 모든 db를 list로 가지고온다 -> jsp에 출력
		return page;
	}
	
	// 좋아요 증가
		@RequestMapping("/my_page/good2")
		public String good2(
				@RequestParam("good") String i,
				HttpServletRequest re
				) {
			log.info("good 아자스 실행");
			int resurt = 0;
			
			try {
				log.info("good 좋아요 실행");
				
				System.out.println("i : "+i);
				System.out.println("song : "+re.getSession().getAttribute("loginId"));
				
				resurt = javaService.good(i, (String) re.getSession().getAttribute("loginId"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/chart";
		}
	
////////////////////////////////////////////////////////////
//	// 범주
	// 플레이 리스트 불러오기
	@RequestMapping("playList")
	public String selectPlayList(HttpServletRequest request, Model model)
	{
		String result = "/playList"; // /view/playList/playList.jsp로 이동.
		
		System.out.println("JavafoodController의 selectPlayList 메서드 실행됨."); //확인용
		
		//세션에 저장된 id값 받아오기
		String id = (String)request.getSession().getAttribute("loginId");
//		String id = "id3"; // 테스트 용 아이디.
		System.out.println("해당 플레이 리스트를 요청한 아이디 : " + id); // 확인용
		
		//로그인 상태가 아니면 로그인 페이지로 보내기
		if(id == null)
		{
			return "lky/login";
		}

		// Service에서 플레이 리스트를 불러오는 메서드 실행하기
		// 메서드 실행 결과(리스트)를 필드에 담기
		List<PlayListDTO> playList = javaService.selectPlayList(id);
		System.out.println("javaService.selectPlayList가 가져온 최종 리스트 크기는 : " + playList.size());

		// 리스트를 담은 필드를 모델을 통해서 보내기
		model.addAttribute("playList", playList);

		return result;
	}

	// 플레이 리스트에서 리스트 추가하기
	@RequestMapping("addPlayList")
	public String addPlayList(HttpServletRequest request, Model model) {
		System.out.println("JavafoodController의 addPlayList 메서드 실행됨."); // 확인용

		// 주소에서 전달된 값들 받아오기
		String id = request.getParameter("id");
		System.out.println("JavafoodController의 addPlayList 메서드에서 받아온 id 값 : " + id);
		String title = request.getParameter("addList_title");
		System.out.println("JavafoodController의 addPlayList 메서드에서 받아온 title 값 :" + title); // 확인용
		String explain = request.getParameter("addList_explain");
		System.out.println("JavafoodController의 addPlayList 메서드에서 받아온 explain 값 : " + explain); // 확인용
		String listImage = request.getParameter("addList_listImage");
		System.out.println("JavafoodController의 addPlayList 메서드에서 받아온 listImage 값 : " + listImage);

		// 전달 받은 값을 List로 바꾸기
		Map<String, String> info = new HashMap<String, String>();
		info.put("id", id);
		info.put("title", title);
		info.put("explain", explain);
		info.put("listImage", listImage);
		

		// 받아온 값들을 Service의 addPlayList 메서드에 전달하여 실행하기
		javaService.addPlayList(info);

		return "redirect:playList";
	}

	// 플레이 리스트 내역(Content) 불러오기
	@RequestMapping("playListContent")
	public String selectPlayListContent(HttpServletRequest request, Model model)
	{
		System.out.println("JavafoodController의 selectPlayListContent 메서드 실행됨."); //확인용
		
		String result = "/playListContent"; // /view/playList/playListContent.jsp로 이동.
		
		//주소에서 받은 값 가져오기
		String pl_id = request.getParameter("pl_id");
		System.out.println("selectPlayListContent 메서드를 실행하며 받은 pl_id의 값은 : " + pl_id); // 확인용

		// Service에서 플레이 리스트 내역을 불러오는 메서드 실행하기
		// 메서드 실행 결과(리스트)를 필드에 담기
		List<PlayListDTO> playListContent = javaService.selectPlayListContent(pl_id);
		System.out.println("JavafoodController의 playListContent 리스트 크기는 : " + playListContent.size()); // 확인용

		// 리스트를 담은 필드를 모델을 통해서 보내기
		model.addAttribute("playListContent", playListContent);

		return result;
	}
	
    //플레이 리스트 내역(Content)에서 곡 삭제하기
    @RequestMapping("deleteContent")
    public String deletePlayListContent(HttpServletRequest request)
    {
        System.out.println("JavafoodController의 deletePlayListContent 메서드 실행됨.");
        
        //주소에서 전달된 값 받기
        String listNumber = request.getParameter("listNumber");
        System.out.println("JavafoodController의 deletePlayListContent 메서드를 실행하며 받은 listNumber : " + listNumber);
        String pl_id = request.getParameter("pl_id");
        System.out.println("JavafoodController의 deletePlayListContent 메서드를 실행하며 받은 pl_id : " + pl_id);
        
        //전달 받은 값을 HashMap에 넣기
        Map<String, String> info = new HashMap<String, String>();
        info.put("listNumber", listNumber);
        info.put("pl_id", pl_id);
        
        //Service에 deletePlayListContent 메서드 실행하기.
        javaService.deletePlayListContent(info);
        
        //playListContent 페이지로 다시 이동하기
        return "redirect:playListContent?pl_id="+pl_id;
    }
    
	//플레이 리스트 삭제하기
    @RequestMapping("deletePlayList")
    public String deletePlayList(HttpServletRequest request)
    {
    	System.out.println("JavafoodController의 deletePlayList 메서드 실행됨."); //확인용
    	
    	//주소에서 전달된 값 받기
    	String pl_id = request.getParameter("pl_id");
    	System.out.println("JavafoodController의 deletePlayList 메서드에서 받은 pl_id : " + pl_id); //확인용
    	String id = request.getParameter("id");
    	System.out.println("JavafoodController의 deletePlayList 메서드에서 받은 id : " + id); //확인용
    	
    	//전달된 값을 HashMap에 담기
    	Map<String, String> info = new HashMap<String, String>();
    	info.put("id", id);
    	info.put("pl_id", pl_id);
    	
    	//service에서 deletePlayList 메서드 실행하기
    	javaService.deletePlayList(info);
    	
    	//삭제 후 playList 페이지로 가기
    	return "redirect:playList";
    }
    
	//메인 페이지 불러오기
	@RequestMapping("main")
	public String viewMain(Model model,
			HttpServletRequest re,
			@RequestParam Map<String, Object> map
			) {

		System.out.println("JavafoodController의 viewMain 메서드 실행됨.");
		
		//리스트에 장르넣고 랜덤으로 인덱스번호를 뽑음
		List<String> genreList = Arrays.asList("발라드", "댄스", "POP", "R&B", "인디", "트로트", "록", "랩");
		Random random = new Random();
		int randomIndex = random.nextInt(genreList.size());
		//리스트 인덱스번호를 랜덤으로 뽑아서 
		//거기에 해당하는 인덱스 장르를 String에 저장
		System.out.println(genreList.get(randomIndex));
		String genre = genreList.get(randomIndex);

		List random_list = javaService.randomGenre(genre);
		
		//뽑은 장르를 메소드로 전달요소로 씀
		model.addAttribute("gerne" ,random_list);
		
		//Service에서 인기 차트를 불러오는 메서드 실행하기
		//메서드 실행결과(리스트)를 필드에 담기
		List<GenreDTO> list = javaService.selectHitList();
		
		//리스트를 모델을 이용해 담기
		model.addAttribute("hitList", list);
		
		//sql에서 랜덤으로 8명의 아티스트 조회한 값 가져오기
		List random_artist = javaService.randomArtist();
		model.addAttribute("random_artist", random_artist);
		
		
		
		//매뉴 상단바 로그아웃
		try {
			if(map.get("out")!=null) {
				log.info("로그아웃 시작");
				re.getSession().invalidate();
			}
		} catch (Exception e) {
			log.info("로그아웃 오류");
			e.printStackTrace();
		}
		
		// main.jsp로 보내기
		return "/main";
	}
	
	@RequestMapping("/playListAdd")
	public String playListAdd(Model model, HttpServletRequest request, HttpSession session)
	{
		System.out.println("JavafoodController의 playListAdd 메서드 실행됨."); //확인용
		
		//로그인 중인 아이디 가져오기
		String id = (String)request.getSession().getAttribute("loginId");
		System.out.println("해당 플레이 리스트를 요청한 아이디 : " + id); // 확인용
		
		//로그인 상태가 아니면 로그인 페이지로 보내기
		if(id == null)
		{
			return "lky/login";
		}
		
		//주소에 전달된 값들을 받아오기
		String[] songNumber = request.getParameterValues("songNumber");
		System.out.println("playListAdd 메서드를 실행하며 주소에서 전달 받은 songNumber의 값은 : "); //확인용
		for(int i=0; i<songNumber.length; i++) //확인용
		{			
			if(i%5 == 0 && i != 0)
			{
				System.out.println();
			}
			if(songNumber.length-1 != i)
			{	
				System.out.print(songNumber[i] + ", ");
			}
			else
			{
				System.out.println(songNumber[i]);
			}
		}
		System.out.println("songNumber의 총 갯수는 : " + songNumber.length);
		
		//받은 값을 세션에 저장하기
		session.setAttribute("songNumber", songNumber);
		
		//service에서 리스트 불러오는 메서드 실행하기
		//실행한 결과를 필드에 담기
		List<PlayListDTO> playList = javaService.selectPlayList(id);
		
		//service에서 플레이 리스트 표지를 불러오는 메서드 실행하기
		//실행한 결과를 필드에 담기
//		List<PlayListDTO> link = javaService.selectPlayListPoster(id);
		
		//필드를 모델에 담아 전송하기
		model.addAttribute("playList", playList);
//		model.addAttribute("poster", link);
		
		//jsp 호출하기
		return "playList/playListAdd"; // /view/playList/playListAdd.jsp 호출
	}

	@RequestMapping("/addContent")
	public String addContent(HttpServletRequest request, HttpSession session)
	{
		System.out.println("JavafoodController의 addContent 메서드 실행됨."); //확인용
		
		//주소에서 전달된 값 받기
		String pl_id = request.getParameter("pl_id");
		System.out.println("JavafoodController에서 addContentInNew를 실행하며 주소에서 받은 pl_id의 값 : " + pl_id); //확인용
    	String listImage = request.getParameter("listImage");
    	System.out.println("JavafoodController에서 addContentInNew를 실행하며 주소에서 받은 listImage의 값 : " + listImage); //확인용
		
		//세션에 저장해둔 songNumber 리스트를 받기
		String[] songNumber = (String[])session.getAttribute("songNumber");
		
		//받은 값들을 HashMap에 저장하기
		Map info = new HashMap();
		info.put("songNumber", songNumber);
		info.put("pl_id", pl_id);
		
		//serivce에서 addContent 메서드 실행하기
		javaService.addContent(info);
		
		//플레이 리스트 내역으로 리다이렉트 하기
		return "redirect:playListContent?pl_id="+pl_id+"&listImage="+listImage;
	}
	@RequestMapping("/addContentInNew")
	public String addContentInNew(HttpServletRequest request, HttpSession session)
	{
		System.out.println("JavafoodController의 addContentInNew 메서드 실행됨."); //확인용
		
		//주소에서 전달된 값 받기
		String pl_id = request.getParameter("pl_id");
		System.out.println("JavafoodController에서 addContentInNew를 실행하며 주소에서 받은 pl_id의 값 : " + pl_id); //확인용
    	String listImage = request.getParameter("listImage");
    	System.out.println("JavafoodController에서 addContentInNew를 실행하며 주소에서 받은 listImage의 값 : " + listImage); //확인용
		
		//세션에 저장해둔 songNumber 리스트를 받기
		String[] songNumber = (String[])session.getAttribute("songNumber");
		
		//받은 값들을 HashMap에 저장하기
		Map info = new HashMap();
		info.put("songNumber", songNumber);
		info.put("pl_id", pl_id);
		
		//serivce에서 addContent 메서드 실행하기
		javaService.addContent(info);
		
		//플레이 리스트 내역으로 리다이렉트 하기
		return "redirect:playListContent?pl_id="+pl_id+"&listImage="+listImage;
	}
////////////////////////////////////////////////////////////
	// 경용
	
	//로그인 페이지 이동
	@RequestMapping(value = "/login")
	public String loginpage(Model mo, 
			HttpServletRequest re,
			HttpServletResponse rp,
			@RequestParam Map<String, Object> map) {
		log.info("login 페이지 이동");
		try {
				
			// 로그인 정보 확인 or 세션ID에 로그인 id 값 저장
			if (map.get("ID") != null) {
				log.info("로그인 시도");
				Map<String, Object> m = javaService.login(map);
				mo.addAttribute("log", m.get("log"));
				mo.addAttribute("map", m);
				
				re.getSession().setAttribute("loginId", m.get("id"));
				re.getSession().setAttribute("loginNic", m.get("nic"));
				re.getSession().setAttribute("loginEmail", m.get("email"));
				re.getSession().setAttribute("loginPn", m.get("pn"));
				re.getSession().setAttribute("loginImg", m.get("img"));
				
				re.getSession().setMaxInactiveInterval(300);
				log.info("로그인 세션 유지시간 : 5분");

			}
			
			// 회원가입
			if (map.get("Id1") != null) {
				log.info("회원가입 시작");
				mo.addAttribute("good",javaService.addid(map));
			}
	
			// 회원 가입 페이지 이동
			if (map.get("membership") != null) {
				log.info("회원가입 페이지 이동");
				mo.addAttribute("membership", map.get("membership"));
			}
			return "lky/login";
		} catch (Exception e) {
			log.info("login페이지 오류");
			return "/main";
		}
	}

	// 회원가입 중복체크 아자스로 이동
	@RequestMapping("/login/ajax")
	@ResponseBody public int ajax(@RequestParam Map<String, Object> map) {
		
		log.info("ajax 실행");
		
		try {
			log.info("ajax 중복값 확인");
			return javaService.what(map);
		} catch (Exception e) {
			log.info("ajax 실패");
			return 1;
		}
	}
	
	//마이 페이지 이동
	@RequestMapping("/my_page")
	public String my_page(Model mo,
			@RequestParam Map<String, Object> map,
			HttpServletRequest re) {
		
		log.info("my_page 접속");
		String id = (String)re.getSession().getAttribute("loginId");
		System.out.println("loginId : "+id);
		
		try {
			
			//페이지 이동
			if(map.get("page") != null) {
				
				log.info("page 이동");
				mo.addAttribute("page",map.get("page"));
				
				//회원정보 수정
				if("a".equals(map.get("a"))) {
					log.info("회원정보 수정");
					mo.addAttribute("remove",javaService.idUpdate(map, id));
				}
				
				//회원 재생목록 가져오기
				if("b".equals(map.get("page"))) {
					log.info("page가져오기");
					
					//페이지 주소값
					String i; 
					if(map.get("p")!=null) i = (String) map.get("p");
					else i = "1";
					
					map = javaService.loginplay(id,Integer.parseInt(i));
					
					mo.addAttribute("playlist",map.get("list"));
					mo.addAttribute("allpage",map.get("allpage"));
					mo.addAttribute("p",map.get("i"));
					
					System.out.println("page가져");
				}
				//로그아웃
				if("c".equals(map.get("page"))) {
					log.info("로그아웃");
					re.getSession().invalidate();
				}
			}
			return "/my_page";
		} catch (Exception e) {
			log.info("my_page 오류");
			e.printStackTrace();
			return "/main";
		}
	}
	
	//아자스를 이용한 좋아요 증가
	@RequestMapping("/my_page/good")
	@ResponseBody
	public int good(
			@RequestParam("good") String i,
			HttpServletRequest re
			) {
		log.info("good 아자스 실행");
		int resurt = 0;
		
		try {
			log.info("good 좋아요 실행");
			
			System.out.println("i : "+i);
			System.out.println("song : "+re.getSession().getAttribute("loginId"));
			
			resurt = javaService.good(i, (String) re.getSession().getAttribute("loginId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resurt;
	}
	
	//아자스를 이용한 노래 재생시 조회수 증가
	@RequestMapping("/my_page/hits")
	@ResponseBody
	public int hit(
			HttpServletRequest re,
			@RequestParam("song") String song
			) {
		log.info("아자스 조회스 증가");
		return javaService.songhit(song ,(String) re.getSession().getAttribute("loginId"));
	
	}
	
	
	//아자스 를 이용한 회원탈퇴
	@RequestMapping("/my_page/out")
	@ResponseBody
	public int outId(
			HttpServletRequest re
			) {
		log.info("회원탈퇴 시도");
		int i = 0;
		try {
			i = javaService.outId( (String) re.getSession().getAttribute("loginId"));
			re.getSession().invalidate();
			log.info("회원탈퇴 성공");
		} catch (Exception e) {
			log.info("회원탈퇴 오류");
		}
		return i;
	}
	
	//검색기능
	@RequestMapping("/search")
	public String search(Model mo,
			@RequestParam Map<String, Object> map) {
		
		try {
				log.info("검색시작");
				System.out.println("옵션값opt : "+map.get("opt"));
				System.out.println("검색값pot : "+map.get("pot"));
				List<GenreDTO> searchlist = javaService.Search(map);
				mo.addAttribute("searchlist",searchlist);
		} catch (Exception e) {
			log.info("검색 오류");
			e.printStackTrace();
			}
		return "/search";
	}

////////////////////////////////////////////////////////////
	// 용준
	// 장르
	@RequestMapping(value = "/genre", method = RequestMethod.GET)
	public String genre(Model model, HttpServletRequest request) {
		// 페이징
		int pageNum = 1; // 현재 페이지
		int countPerPage = 10; // 한 페이지당 표시 수

		// 장르별 리스트
		String song = "발라드";
		if (request.getParameter("genre") != null) {
			song = request.getParameter("genre");
		}
		// 페이징
		String tmp_pageNum = request.getParameter("pageNum");
		if (tmp_pageNum != null) {
			pageNum = Integer.parseInt(tmp_pageNum);
		}
		String tmp_countPerPage = request.getParameter("countPerPage");
		if (tmp_countPerPage != null) {
			countPerPage = Integer.parseInt(tmp_countPerPage);
		}
		System.out.println("controller : " + tmp_countPerPage);
		System.out.println("song  전: " + song);
		System.out.println("pageNum : " + pageNum);
		System.out.println("countPerPage : " + countPerPage);
		Map genre_list = javaService.getGenre(song, pageNum, countPerPage);
		model.addAttribute("genre", genre_list.get("list"));
//				System.out.println("test: >>> >> >> "+ ((List<GenreDTO>)genre_list.get("list")).get(0).getImagelink());
//				System.out.println("test: >>> >> >> "+ ((List<GenreDTO>)genre_list.get("list")).get(0).getAlbum_name());
		model.addAttribute("totalCount", genre_list.get("totalCount"));
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("countPerPage", countPerPage);
		model.addAttribute("song2", song);
		
		// R&B페이징시 문제가 있어 인코딩을 해줌.
		try {
			song = URLEncoder.encode(song, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("song", song);
		System.out.println("song 후: " + song);

		return "/genre";
	}

	// 최신음악
		@RequestMapping (value = "/popular_Music", method = RequestMethod.GET)
		public String Popular_Music(Model model,
				HttpServletRequest request
				) {
			// 페이징
					int pageNum = 1;		// 현재 페이지
					int countPerPage = 10;	// 한 페이지당 표시 수 
					// 페이징 
					String tmp_pageNum = request.getParameter("pageNum");
					if(tmp_pageNum != null) {
						pageNum = Integer.parseInt(tmp_pageNum);
					}
					String tmp_countPerPage = request.getParameter("countPerPage");
					if (tmp_countPerPage != null) {
						countPerPage = Integer.parseInt(tmp_countPerPage);
					}
					System.out.println("pageNum : " + pageNum);
					System.out.println("countPerPage : " + countPerPage);
					Map Music_list = javaService.getMusic(pageNum, countPerPage);
					model.addAttribute("list", Music_list.get("list"));
//					System.out.println("test: >>> >> >> "+ ((List<GenreDTO>)Music_list.get("list")).get(0).getSongname());
					model.addAttribute("totalCount", Music_list.get("totalCount"));
					model.addAttribute("pageNum", pageNum);
					model.addAttribute("countPerPage", countPerPage);
					
			return "/popular_Music";
		}
		
		// 관리자 페이지
		@RequestMapping ("/insert_song")
		public String insert_song(Model model,
				@RequestParam Map<String, Object> map,
				HttpServletRequest re) {
			System.out.println("controller의 insert_song 메인페이지 실행");
			String id = (String)re.getSession().getAttribute("loginId");
			System.out.println("환영합니다!! 관리자님! : "+id);
			
			try {				
				//페이지 이동
				if(map.get("page") != null) {
					
					log.info("page 이동");
					model.addAttribute("page",map.get("page"));
					
					//장르 테이블 관리 페이지
					if("a".equals(map.get("a"))) {
						log.info("Genre 관리페이지 입니다.");
						model.addAttribute("remove",javaService.idUpdate(map, id));
					}
					
					//아티스트 테이블 관리 페이지
					if("b".equals(map.get("page"))) {
						log.info("Artist 관리페이지 입니다.");
						
			
						System.out.println("page가져");
					}
					//앨범 테이블 관리 페이지
					if("c".equals(map.get("page"))) {
						log.info("Album 관리페이지 입니다.");
					}
					//수록곡 테이블 관리 페이지
					if("d".equals(map.get("page"))) {
						log.info("Song 관리페이지 입니다.");
					}
					
				}
				
				return "/insert_song";
			} catch (Exception e) {
				log.info("my_page 오류");
				e.printStackTrace();
				return "/main";
			}		
					
			
		}
				
		// 노래 추가 페이지
		@RequestMapping ("/insert_song_up")
		public String insert_song(Model model,	
				HttpServletRequest request,
				@ModelAttribute	GenreDTO dto
				) {
			System.out.println("controller의 insert_song  등록 : " + dto);
			
			
			int insert = javaService.insertsong(dto);
			
// redirect는 새로운 주소로 새로고침.
			return "redirect:/insert_song";
		}
				
		// 좋아요 증가
				@RequestMapping("/genre/good")
				public String goodgood(
						@RequestParam("good") String i,
						HttpServletRequest re
						) {
					log.info("good 아자스 실행");
					int resurt = 0;
					
					try {
						log.info("good 좋아요 실행");
						
						System.out.println("i : "+i);
						System.out.println("song : "+re.getSession().getAttribute("loginId"));
						
						resurt = javaService.good(i, (String) re.getSession().getAttribute("loginId"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					return "redirect:/genre";
				}
		
		// 아티스트 정보 목록 전체 조회
		@RequestMapping ("/list/artist")
		public String listArtist(Model model,	
				HttpServletRequest request,
				@ModelAttribute	AlbumDTO dto
				) {
			System.out.println("아티스트 테이블을 조회합니다.");
			
			List listArtist = javaService.listArtist();
			model.addAttribute("list", listArtist);
			
			return "/insert_song";
		}
		


////////////////////////////////////////////////////////////
}

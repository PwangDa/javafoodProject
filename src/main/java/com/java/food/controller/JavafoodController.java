package com.java.food.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
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
	public String java1(Model model, @RequestParam("artist") String artist) {
		System.out.println("아티스트페이지 접속");
		System.out.println("artist >" + artist);
		// 아티스트 소개 페이지 출력 메소드(전달요소 > 아티스트명)
		List artist_list = javaService.getArtist(artist);
		// 댓글 출력 메소드(전달요소 > 아티스트명)
		List comment_list = javaService.getComment(artist);

		model.addAttribute("album_list", artist_list);
		model.addAttribute("commentList", comment_list);


		
		return "/artistpage";

	}

	// 댓글 등록 할 때
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insert(Model model, @ModelAttribute CommentDTO dto, @RequestParam("id") String id,
			@RequestParam("cont") String cont, @RequestParam("myimg") String ima,
			@RequestParam("songnum") String songnum, @RequestParam("arti") String arti
	/* @RequestParam("command_articleNO") int arino */
	) {

		System.out.println(">>>>>" + id);
		System.out.println(">>>>>" + cont);
		System.out.println(">>>>>" + ima);
		System.out.println(">>>>>" + songnum);
		System.out.println(">>>>>" + arti);

		dto.setComment_id(id);
		dto.setComment_cont(cont);
		dto.setMyimg(ima);
		dto.setArtistname(arti);
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
	public String reply(Model model, @ModelAttribute CommentDTO dto, @RequestParam("id_2") String id,
			@RequestParam("cont_2") String cont, @RequestParam("command_myimg") String ima,
			@RequestParam("command_articleNO") int article, @RequestParam("arti") String arti
	/* @RequestParam("command_articleNO") int arino */
	) {

		System.out.println(">>>>>" + id);
		System.out.println(">>>>>" + cont);
		System.out.println(">>>>>" + ima);
		System.out.println(">>>>>" + article);
		System.out.println(">>>>>" + arti);

		dto.setComment_id(id);
		dto.setComment_cont(cont);
		dto.setMyimg(ima);
		dto.setArtistname(arti);
		dto.setParentNO(article);

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

	// 댓글 삭제할 때
	@RequestMapping(value = "/del.do", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delet(Model model, @ModelAttribute CommentDTO dto, @RequestParam("command_articleNO") int no,
			@RequestParam("arti") String arti) {

		System.out.println("댓글삭제 메소드 접속");
		System.out.println("no>>>>>" + no);
		System.out.println("arti>>>>>" + arti);

		int article = javaService.delComment(no);

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

		return "hdy/Album";
	}

	@RequestMapping(value = "/layout")
	public String java1_1(Model model) {

		return "/layout";
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

	//페이징 주소 예시 http://localhost:8080/chart?country=대한민국&pageNum=3
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart(Model model, HttpServletRequest req) {
		List<FamousChartDTO> list = new ArrayList();
		int pageNum = 1;
		int countPerPage = 50;
		
		String country = req.getParameter("country");
//		System.out.println(country);
//		if(country == null) {
//			country = "all";
//		}
		javaService.chart(country, pageNum, countPerPage);
		
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

				return "chart/chart";

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
//오류		return "/chart";

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

////////////////////////////////////////////////////////////
//	// 범주
//오류
//	// 플레이 리스트 불러오기
//	@RequestMapping("playList")
//
//	public String selectPlayList(HttpServletRequest request, Model model) {
//		String result = "playList/playList"; // /view/playList/playList.jsp로 이동.
//
//		System.out.println("JavafoodController의 selectPlayList 메서드 실행됨."); // 확인용
//
//		// 세션에 저장된 id값 받아오기*/
//
//	public String selectPlayList(HttpServletRequest request, Model model)
//	{
//		String result = "/playList"; // /view/playList/playList.jsp로 이동.
//		
//		System.out.println("JavafoodController의 selectPlayList 메서드 실행됨."); //확인용
//		
//		//세션에 저장된 id값 받아오기
//
////		String id = (String)request.getSession().getAttribute("login");
//		String id = "id3"; // 테스트 용 아이디.
//		System.out.println("해당 플레이 리스트를 요청한 아이디 : " + id); // 확인용
//
//		// Service에서 플레이 리스트를 불러오는 메서드 실행하기
//		// 메서드 실행 결과(리스트)를 필드에 담기
//		List<PlayListDTO> playList = javaService.selectPlayList(id);
//		System.out.println("javaService.selectPlayList가 가져온 최종 리스트 크기는 : " + playList.size());
//
//		// 리스트를 담은 필드를 모델을 통해서 보내기
//		model.addAttribute("playList", playList);
//
//		return result;
//	}

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

		// 전달 받은 값을 List로 바꾸기
		Map<String, String> info = new HashMap<String, String>();
		info.put("id", id);
		info.put("title", title);
		info.put("explain", explain);

		// 받아온 값들을 Service의 addPlayList 메서드에 전달하여 실행하기
		javaService.addPlayList(info);

		return "redirect:playList";
	}

//	// 플레이 리스트 내역(Content) 불러오기
//	@RequestMapping("playListContent")
//	public String selectPlayListContent(HttpServletRequest request, Model model) {
//		System.out.println("JavafoodController의 selectPlayListContent 메서드 실행됨."); // 확인용
//
//		String result = "playList/playListContent"; // /view/playList/playListContent.jsp로 이동.
//
//		// 주소에서 받은 값 가져오기
//=======
//	public String selectPlayListContent(HttpServletRequest request, Model model)
//	{
//		System.out.println("JavafoodController의 selectPlayListContent 메서드 실행됨."); //확인용
//		
//		String result = "/playListContent"; // /view/playList/playListContent.jsp로 이동.
//		
//		//주소에서 받은 값 가져오기
//		String pl_id = request.getParameter("pl_id");
//		System.out.println("selectPlayListContent 메서드를 실행하며 받은 pl_id의 값은 : " + pl_id); // 확인용
//
//		// Service에서 플레이 리스트 내역을 불러오는 메서드 실행하기
//		// 메서드 실행 결과(리스트)를 필드에 담기
//		List<PlayListDTO> playListContent = javaService.selectPlayListContent(pl_id);
//		System.out.println("JavafoodController의 playListContent 리스트 크기는 : " + playListContent.size()); // 확인용
//
//		// 리스트를 담은 필드를 모델을 통해서 보내기
//		model.addAttribute("playListContent", playListContent);
//
//		return result;
//	}
//<<<<<<< HEAD

	// 플레이 리스트 내역(Content)에서 곡 삭제하기
//	@RequestMapping("deleteContent")
//	public String deletePlayListContent(HttpServletRequest request) {
//		System.out.println("JavafoodController의 deletePlayListContent 메서드 실행됨.");
//오류
//		// 주소에서 전달된 값 받기
//		String listNumber = request.getParameter("listNumber");
//		System.out.println("JavafoodController의 deletePlayListContent 메서드를 실행하며 받은 listNumber : " + listNumber);
//		String pl_id = request.getParameter("pl_id");
//		System.out.println("JavafoodController의 deletePlayListContent 메서드를 실행하며 받은 pl_id : " + pl_id);
//
//		// 전달 받은 값을 HashMap에 넣기
//		Map<String, String> info = new HashMap<String, String>();
//		info.put("listNumber", listNumber);
//		info.put("pl_id", pl_id);
//
//		// Service에 deletePlayListContent 메서드 실행하기.
//		javaService.deletePlayListContent(info);
//
//		// playListContent 페이지로 다시 이동하기
//		return "redirect:playListContent?pl_id=" + pl_id;
//	}

//	//플레이 리스트 삭제하기
//    @RequestMapping("deletePlayList")
//    public String deletePlayList(HttpServletRequest request)
//    {
//    	System.out.println("JavafoodController의 deletePlayList 메서드 실행됨."); //확인용
//    	
//    	//주소에서 전달된 값 받기
//    	String pl_id = request.getParameter("pl_id");
//    	System.out.println("JavafoodController의 deletePlayList 메서드에서 받은 pl_id : " + pl_id); //확인용
//    	String id = request.getParameter("id");
//    	System.out.println("JavafoodController의 deletePlayList 메서드에서 받은 id : " + id); //확인용
//    	
//    	//service에서 deletePlayList 메서드 실행하기
////    	javaService.deletePlayList(id, pl_id);
//    	
//    	//
//    }

	///////////////////// * 아직 인기차트가 완성되지 않아, 나중에 다시 작업할 예정
	///////////////////// *////////////////////////
	// 메인 페이지 불러오기*/

	
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
    
    
	/////////////////////* 아직 인기차트가 완성되지 않아, 나중에 다시 작업할 예정 *////////////////////////
	//메인 페이지 불러오기
	@RequestMapping("main")
	public String viewMain(Model model) {

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

		String result = "main/main";

		// Service에서 인기 차트를 불러오는 메서드 실행하기
		// 메서드 실행결과(리스트)를 필드에 담기
		
		//뽑은 장르를 메소드로 전달요소로 씀

		model.addAttribute("gerne" ,random_list);
		

		
		//Service에서 인기 차트를 불러오는 메서드 실행하기
		//메서드 실행결과(리스트)를 필드에 담기
//		List<GenreDTO> list = javaService.

		return result;
	}

////////////////////////////////////////////////////////////
	// 경용
	
	@RequestMapping(value = "/login")
	public String loginpage(Model mo, HttpServletRequest re,
			@RequestParam Map<String, Object> map) {
		log.info("login 페이지 이동");
		try {
				
			// 로그인 정보 확인 or 세션ID에 로그인 id 값 저장
			if (map.get("ID") != null) {
				log.info("로그인 시도");
				Map m = javaService.login(map);
				mo.addAttribute("log", m.get("log"));
				mo.addAttribute("map", m);
				
				re.getSession().setAttribute("loginId", m.get("id"));
				re.getSession().setAttribute("loginNic", m.get("nic"));
				re.getSession().setAttribute("loginEmail", m.get("email"));
			}
			
			// 회원가입
			if (map.get("Id1") != null) {
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
			return javaService.what(map);
		} catch (Exception e) {
			log.info("ajax 실패");
			return 1;
		}
	}
	
	@RequestMapping("/my_page")
	public String my_page(Model mo,
			@RequestParam Map<String, Object> map,
			HttpServletRequest re) {
		
		log.info("my_page 접속");
		
		try {
			if(map.get("page") != null) {
				log.info("page이동");
				mo.addAttribute("page",map.get("page"));
			}
			
			return "lky/My_page";
		} catch (Exception e) {
			log.info("my_page 오류");
			return "main";
		}
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
		model.addAttribute("song", song);
		System.out.println("song 후: " + song);

		return "lyj/genre";
	}

	// 최신음악
//	@RequestMapping(value = "/popular_Music", method = RequestMethod.GET)
//	public String Popular_Music(Model model, HttpServletRequest request) {
//		// 페이징
//		int pageNum = 1; // 현재 페이지
//		int countPerPage = 10; // 한 페이지당 표시 수
//		// 페이징
//		String tmp_pageNum = request.getParameter("pageNum");
//		if (tmp_pageNum != null) {
//			pageNum = Integer.parseInt(tmp_pageNum);
//				// 장르별 리스트
//				String song="발라드";
//				if(request.getParameter("genre")!=null) {
//					song = request.getParameter("genre");
//				}
//				// 페이징 
//				String tmp_pageNum = request.getParameter("pageNum");
//오류				if(tmp_pageNum != null) {
//					pageNum = Integer.parseInt(tmp_pageNum);
//				}
//				String tmp_countPerPage = request.getParameter("countPerPage");
//				System.out.println("controller : " + tmp_countPerPage);
//				if(tmp_countPerPage != null) {
//					countPerPage = Integer.parseInt(tmp_countPerPage);
//				}
//				System.out.println("song  전: " + song);
//				System.out.println("pageNum : " + pageNum);
//				System.out.println("countPerPage : " + countPerPage);
//				Map genre_list = javaService.getGenre(song, pageNum, countPerPage);
//				model.addAttribute("genre", genre_list.get("list"));
////				System.out.println("test: >>> >> >> "+ ((List<GenreDTO>)genre_list.get("list")).get(0).getImagelink());
////				System.out.println("test: >>> >> >> "+ ((List<GenreDTO>)genre_list.get("list")).get(0).getAlbum_name());
//				model.addAttribute("totalCount", genre_list.get("totalCount"));
//				model.addAttribute("pageNum", pageNum);
//				model.addAttribute("countPerPage", countPerPage);
//				// R&B페이징시 문제가 있어 인코딩을 해줌.
//				try {
//					song = URLEncoder.encode(song, "utf-8");
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				model.addAttribute("song", song);
//				System.out.println("song 후: " + song);
//				
//		return "/genre";
//	}
	
	//최신음악
//		@RequestMapping (value = "/popular_Music", method = RequestMethod.GET)
//		public String Popular_Music(Model model,
//				HttpServletRequest request) {
//			// 페이징
//					int pageNum = 1;		// 현재 페이지
//					int countPerPage = 10;	// 한 페이지당 표시 수 
//					// 페이징 
//					String tmp_pageNum = request.getParameter("pageNum");
//					if(tmp_pageNum != null) {
//						pageNum = Integer.parseInt(tmp_pageNum);
//					}
//					System.out.println("pageNum : " + pageNum);
//					System.out.println("countPerPage : " + countPerPage);
//	오류				Map Music_list = javaService.getMusic(pageNum, countPerPage);
//					model.addAttribute("list", Music_list.get("list"));
//					System.out.println("test: >>> >> >> "+ ((List<GenreDTO>)Music_list.get("list")).get(0).getSongname());
//					model.addAttribute("totalCount", Music_list.get("totalCount"));
//					model.addAttribute("pageNum", pageNum);
//					model.addAttribute("countPerPage", countPerPage);
//					
//			return "/popular_Music";
//		}
//		System.out.println("pageNum : " + pageNum);
//		System.out.println("countPerPage : " + countPerPage);
//		Map Music_list = javaService.getMusic(pageNum, countPerPage);
//		model.addAttribute("list", Music_list.get("list"));
//		System.out.println("test: >>> >> >> " + ((List<GenreDTO>) Music_list.get("list")).get(0).getSongname());
//		model.addAttribute("totalCount", Music_list.get("totalCount"));
//		model.addAttribute("pageNum", pageNum);
//		model.addAttribute("countPerPage", countPerPage);
//
//		return "lyj/Popular_Music";
//	}

////////////////////////////////////////////////////////////
}

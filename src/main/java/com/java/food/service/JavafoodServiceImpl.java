package com.java.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.controller.JavafoodController;
import com.java.food.dao.JavafoodDAO;
import com.java.food.dto.AlbumDTO;
import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
import com.java.food.dto.GenreDTO;
import com.java.food.dto.PlayListDTO;
import com.java.food.dto.SongHit_DTO;
import com.java.food.dto.login_DTO;

@Service
public class JavafoodServiceImpl implements JavafoodService {
	private static final Logger log = LoggerFactory.getLogger(JavafoodController.class);

	@Autowired
	JavafoodDAO javaDAO;
////////////////////////////////////////////////////////////
//다영
	/**
	 * 다영
	 * 아티스트 페이지 출력 메소드
	 * 전달인자 : String (아티스트 이름)
	 * @return : list
	 */
	@Override
	public List getArtist(String artist) {
		List Artist_list = javaDAO.viewArtist(artist);
		
		return Artist_list;
	}
	/**
	 * 다영
	 * 댓글 출력 메소드
	 * 전달인자 : String (아티스트 이름)
	 * @return : list
	 */
	@Override
	public List getComment(String artist) {
		List Comment_list = javaDAO.viewComment(artist);
		
		return Comment_list;
		
	}
	/**
	 * 다영
	 * 댓글 출력 메소드
	 * 전달인자 : String (아티스트 이름)
	 * @return : list
	 */
	@Override
	public List getAlbum(String album) {
		List Album_list = javaDAO.viewAlbum(album);
		
		return Album_list;
		
	}
	@Override
	public int insertComment(CommentDTO dto) {
		System.out.println("EMP Service >> insertComment 실행");
		
		return javaDAO.insertComment(dto);	
	}
	
	@Override
	public int replyComment(CommentDTO dto) {
		System.out.println("EMP Service >> replyComment 실행");
		return javaDAO.replyComment(dto);	
	}
	
	@Override
	public int delComment(int articleNO) {
		
		System.out.println("EMP Service >> delComment 실행");
		System.out.println("articleNO > "+articleNO); 
		
		return javaDAO.delComment(articleNO);	
		
	}
	
	@Override
	public List randomGenre(String genre) {	
		System.out.println("EMP Service >> randomGenre 실행");	
		return javaDAO.randomGenre(genre);	
	}
	
	@Override
	public List randomArtist() {
		System.out.println("EMP Service >> randomArtist 실행");	
		return javaDAO.randomArtist();
	}
	
	@Override
	public int albumplus(AlbumDTO dto) {
		return javaDAO.albumplus(dto);
	}
////////////////////////////////////////////////////////////
//귀범
//	// 차트
//	/**
//	 * 인기차트 출력 메소드
//	 * 전달인자 : String 노래번호
//	 * @return : list
//	 */
//	@Override
//	public List<FamousChartDTO> getChart(String songnumber){
//		
//		List<FamousChartDTO> chartlist = null;
//		
//		chartlist = javaDAO.getChart(songnumber);
//		
//		System.out.println("Service : " +chartlist);
//		return chartlist;
//		
//		
//	}
	
	// 차트 페이징
	/**
	 * 페이징 출력 메소드
	 * 전달인자 : 노래번호, 페이지넘버, 출력개수
	 * @return : map
	 */
	@Override
	public Map chart(String country, int pageNum, int countPerPage) {

		int start = 0;
		int end = 0;
		start = (countPerPage * (pageNum - 1)) + 1;
		end = start + countPerPage - 1;
		List list = javaDAO.chart(country, start, end);
		int totalCount = javaDAO.totalpage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount);
		System.out.println(start);
		System.out.println(end);
		return map;
		
	}
	
	//조회수 증가
	public void addhit(String id, String songnumber) {
		
		javaDAO.addhit(id, songnumber);
		
	}
	
	// genre Dance 출력 메소드
	// 전달인자 x
	// select 하는 메소드 생성
	
	public List<FamousChartDTO> selectDance(String genre){
		
		List<FamousChartDTO> page = null;
		
		 page = javaDAO.selectDance(genre);
		
		return page;
	}
	
////////////////////////////////////////////////////////////
//범주
	//범주 플레이 리스트 불러오기
	@Override
	public List<PlayListDTO> selectPlayList(String id)
	{
		System.out.println("JavafoodServicelImpl의 selectPlayList 메서드 실행됨."); //확인용
		List<PlayListDTO> result = null;
		
		//JavafoodDAO의 selectPlayList 메서드를 실행하기
		//메서드의 결과(List)를 필드에 담기
		result = javaDAO.selectPlayList(id);
		System.out.println("javaDAO의 selectPlayList를 실행하여 얻은 리스트의 크기 : " + result.size() ); //확인용
		
		return result;
	}
	
	//범주 플레이 리스트 표지 불러오기
	@Override
	public List<PlayListDTO> selectPlayListPoster(String id)
	{
		System.out.println("JavafoodServiceImpl의 selectPlayListPoster 메서드 실행됨."); //확인용
		List<PlayListDTO> result = null;
		
		//JavafoodDAO의 selectPlayListPoster 메서드 실행하기
		//실행한 결과를 필드에 담기
//		result = javaDAO.selectPlayListPoster(id);
		System.out.println("JavafoodServiceImpl의 selectPlayListPoster를 실행하여 얻은 리스트의 크기 : " + result.size() ); //확인용
		
		return result;
	}
	
	//범주 플레이 리스트 내역(Content) 불러오기
	@Override
	public List<PlayListDTO> selectPlayListContent(String pl_id)
	{
		System.out.println("JavafoodServicelImpl의 selectPlayListContent 메서드 실행됨."); //확인용
		List<PlayListDTO> result = null;
		
		//JavafoodDAO의 selectPlayList 메서드를 실행하기
		//메서드의 결과(List)를 필드에 담기
		result = javaDAO.selectPlayListContent(pl_id);
		System.out.println("javaDAO의 selectPlayList를 실행하여 얻은 리스트의 크기 : " + result.size() ); //확인용
		
		return result;
	}
	
	//범주 플레이 리스트 추가하기
	@Override
	public void addPlayList(Map<String, String> info)
	{
		System.out.println("JavafoodServiceImpl의 addPlayList 메서드 실행됨."); //확인용
		
		//받은 전달인자를 통해 dao의 addPlayList 메서드 실행하기.
		javaDAO.addPlayList(info);
	}
	
	//범주 플레이 리스트 내역(Content) 삭제하기
	@Override
	public void deletePlayListContent(Map<String, String> info)
	{
		System.out.println("JavafoodServiceImpl의 deletePlayListContent 메서드 실행됨."); //확인용
		
		//받은 전달인자를 통해 dao의 deletePlayList 메서드 실행하기
		javaDAO.deletePlayListContent(info);
	}
	
	//범주 플레이 리스트 삭제하기
	@Override
	public void deletePlayList(Map<String, String> info)
	{
		System.out.println("JavafoodServiceImpl의 deletePlayList 메서드 실행됨."); //확인용
		
		//받은 전달인자를 통해 dao의 deletePlayList 메서드 실행하기
		javaDAO.deletePlayList(info);
	}
	
	//범주 메인페이지 인기곡 불러오기
	@Override
	public List<GenreDTO> selectHitList()
	{
		System.out.println("JavafoodServiceImpl의 selectHitList 메서드 실행됨."); //확인용
		
		List<GenreDTO> result = null;
		
		//dao의 selectHitList 메서드 실행하기
		//selectHitList의 결과를 리스트에 담기
		result = javaDAO.selectHitList();
		
		return result;
	}
	
	//범주 플레이 리스트에 곡 추가하기
	@Override
	public void addContent(Map info)
	{
		System.out.println("JavafoodServiceImpl의 addContent 메서드 실행됨."); //확인용
		
		//dao의 addContent 메서드 실행하기.
		javaDAO.addContent(info);
	}
////////////////////////////////////////////////////////////
//경용
	//로그인
	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		log.info("로그인 시도");
		Map<String, Object> m = new HashMap<String, Object>();
		int a=0;
		List<login_DTO> list = javaDAO.listID();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getID().equals(map.get("ID"))) {
				System.out.println(map.get("ID"));
				a++;
				if(list.get(i).getPWD().equals(map.get("PW"))) {
					System.out.println(map.get("PW"));
					a++;
					m.put("id", list.get(i).getID());
					m.put("nic", list.get(i).getNIC());
					m.put("email", list.get(i).getEMAIL());
					m.put("img", list.get(i).getIMG());
					m.put("pn", list.get(i).getPN());
				}
			}
		}
		if(a==0) log.info("아이디 오류");
		if(a==1) log.info("페스워드 오류");
		if(a==2) log.info("로그인 성공");
		m.put("log", a);
		return m;
	}
	
	//회원가입
	@Override
	public int addid (Map<String, Object> map) {
		log.info("회원가입");
		login_DTO dto = null;
		try {
			log.info("회원시도");
			dto = new login_DTO();
			dto.setID( (String) map.get("Id1") );
			dto.setPWD( (String) map.get("PW1") );
			dto.setNIC( (String) map.get("nic") );
			dto.setEMAIL( (String) map.get("mail") );
			dto.setPN( (String) map.get("pn1")+"-"+map.get("pn2") );
			dto.setPHONE( (String) map.get("phone1")+"-"+map.get("phone2")+"-"+map.get("phone3") );
			
			log.info("아이디 : ",dto.getID());
			log.info("닉네임 : ",dto.getNIC());
			log.info("페스워드 : ",dto.getPWD());
			log.info("주민등록번호 : ",dto.getPN());
			log.info("이메일 : ",dto.getEMAIL());
			log.info("핸드폰 : ",dto.getPHONE());
			
			log.info("회원가입 성공");
		} catch (Exception e) {
			log.info("오류");
			e.printStackTrace();
			log.info("회원실패");
		}
		return javaDAO.addId(dto);
	}
	
	//아자스로 회원값 중복체크
	@Override
	public int what(Map<String, Object> map) {
		log.info("ajax 중복체크 실행");
		
		List<login_DTO> list = javaDAO.listID();
		int a=1;
		
		if(map.get("Id1")!=null) {
			log.info("id 중복 체크");
			if("".equals(map.get("Id1"))) a++;
			for(login_DTO i : list) {
				if(i.getID().equals(map.get("Id1"))) a--;
			}
		};
		if(map.get("nic")!=null) {
			log.info("nic 중복 체크");
			if("".equals(map.get("nic"))) a++;
			for(login_DTO i : list) {
				if(i.getNIC().equals(map.get("nic"))) a--;
			}
		};
		if(map.get("email")!=null) {
			log.info("email 중복 체크");
			if("".equals(map.get("email"))) a++;
			for(login_DTO i : list) {
				if(i.getEMAIL().equals(map.get("email"))) a--;
			}
		};
		if(map.get("pn")!=null) {
			log.info("pn 중복 체크");
			if("-".equals(map.get("pn"))) a++;
			for(login_DTO i : list) {
				if(i.getID().equals(map.get("pn"))) a--;
			}
		};
		if(map.get("phone")!=null) {
			log.info("phone 중복 체크");
			if("--".equals(map.get("phone"))) a++;
			for(login_DTO i : list) {
				if(i.getID().equals(map.get("phone"))) a--;
			}
		};
		return a;
	}
	
	//회원 탈퇴
	@Override
	public int outId(String id) {
		log.info("회원시작");
		int a=0;
		try {
			a = javaDAO.outId(id);
			log.info("회원탈퇴");
		} catch (Exception e) {
			log.info("회원실패");
		}
		return a;
	}
	
	// 로그인 회원 재생목록
	@Override
	public Map<String, Object> loginplay(String id, int i){
		Map<String, Object> map = new HashMap<String, Object>();
		List<SongHit_DTO> list = javaDAO.loginplay(id);
		
		System.out.println("list size : "+list.size());
		System.out.println("list 0번 : "+list.get(0).getSONGNUMBER());
		
		//전체 페이지
		int k=1;
		int l = list.size();
		int a = list.size();
		for(int j=1; a>=5; k++) { a=a-5; }
		
		System.out.println("전체 페이지 : "+k);
		System.out.println("현제 페이지 : "+i);
		System.out.println("l : "+l);
		
		list = new ArrayList<SongHit_DTO>();
		
		if((i * 5 - 1) > l) l = l-1;
		else l = i * 5 - 1;
		
		System.out.println("l : "+l);
		
		for(int q = i * 5 - 5; q <= l; q++) {
			if(javaDAO.loginplay(id).get(q)!=null)
				list.add(javaDAO.loginplay(id).get(q));
		}
		
		map.put("list", list);
		map.put("allpage", k);
		
		return map;
	}
	//회원정보 수정
	public int idUpdate(Map<String, Object> map, String id) {
		log.info("회원정보 수정");
		login_DTO dto = null;
		
		log.info("회원시도");
		
		dto = new login_DTO();
		dto.setPWD( (String) map.get("PW1") );
		dto.setNIC( (String) map.get("nic") );
		dto.setEMAIL( (String) map.get("mail") );
		dto.setPHONE( (String) map.get("phone1")+"-"+map.get("phone2")+"-"+map.get("phone3") );
		
		log.info("아이디 : ",dto.getID());
		log.info("닉네임 : ",dto.getNIC());
		log.info("페스워드 : ",dto.getPWD());
		log.info("주민등록번호 : ",dto.getPN());
		log.info("이메일 : ",dto.getEMAIL());
		log.info("핸드폰 : ",dto.getPHONE());
			
		return 1;
			
	}
	
	//좋아요 증가
	public int good(String songnumb, String id) {
		log.info("good service 실행");
		int i=0;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("id", id);
			map.put("song", songnumb);
			
			System.out.println("map song : "+map.get("song"));
			javaDAO.good(map);
			i++;
		} catch (Exception e) {
			log.info("service good실패");
			e.printStackTrace();
		}
		return i;
	}
	
	//조회수 증가
	public int songhit(String song,String id) {
		return javaDAO.songhit(song, id);
	}
	
////////////////////////////////////////////////////////////
	// 용준 장르별 페이징

	@Override
	public Map getGenre(String song, int pageNum, int countPerPage) {
		

		int start = 0;
		int end = 0;
		start = (countPerPage * (pageNum - 1)) + 1;
		end = start + countPerPage - 1;
		List list = javaDAO.getGenre(song, start, end);
		int totalCount = javaDAO.pagetotal(song);

		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount);
		
		
		
		return map;

	}
	
	// 용준 최신음악 페이징

		@Override
		public Map getMusic(int pageNum, int countPerPage) {
			

			int start = 0;
			int end = 0;
			start = (countPerPage * (pageNum - 1)) + 1;
			end = start + countPerPage - 1;
			List list = javaDAO.getMusic(start, end);
			int totalCount = javaDAO.pagetotal_Music();
			System.out.println("Service size : " +list.size());
			System.out.println(start);
			System.out.println(end);

			Map map = new HashMap();
			map.put("list", list);
			map.put("totalCount", totalCount);
			
			return map;

		}
	

////////////////////////////////////////////////////////////

}

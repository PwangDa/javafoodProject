package com.java.food.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.controller.JavafoodController;
import com.java.food.dao.JavafoodDAO;
import com.java.food.dto.CommentDTO;
import com.java.food.dto.GenreDTO;
import com.java.food.dto.PlayListDTO;
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
////////////////////////////////////////////////////////////
//경용
	//로그인
	@Override
	public Map login(Map<String, Object> map) {
		log.info("로그인 시도");
		Map m = new HashMap();
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
			
			log.info(dto.getID());
			log.info(dto.getNIC());
			log.info(dto.getPWD());
			log.info(dto.getPN());
			log.info(dto.getEMAIL());
			log.info(dto.getPHONE());
			
			log.info("회원가입 성공");
		} catch (Exception e) {
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
	
////////////////////////////////////////////////////////////
	// 용준 장르별 페이징

	@Override
	public Map getGenre(String song, int pageNum, int countPerPage) {
		

		int start = 0;
		int end = 0;
		start = (countPerPage * (pageNum - 1)) + 1;
		end = start + countPerPage - 1;
		List list = javaDAO.getGenre(song, start, end);
		int totalCount = javaDAO.pagetotal();

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

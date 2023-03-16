package com.java.food.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.dao.JavafoodDAO;
import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
import com.java.food.dto.PlayListDTO;
import com.java.food.dto.login_DTO;

@Service
public class JavafoodServiceImpl implements JavafoodService {

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
	public Map chart(String songnum, int pageNum, int countPerPage) {

		int start = 0;
		int end = 0;
		start = (countPerPage * (pageNum - 1)) + 1;
		end = start + countPerPage - 1;
		List list = javaDAO.chart(songnum, start, end);
		int totalCount = javaDAO.totalpage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount);
		System.out.println(start);
		System.out.println(end);
		return map;
		
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
////////////////////////////////////////////////////////////
//경용
	//로그인
	@Override
	public Map login(Map<String, Object> map) {
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
					m.put("pwd", list.get(i).getPWD());
					m.put("nic", list.get(i).getNIC());
					m.put("email", list.get(i).getEMAIL());
				}
			}
		}
		if(a==0) System.out.println("아이디 오류");
		if(a==1) System.out.println("페스워드 오류");
		if(a==2) System.out.println("로그인 성공");
		m.put("log", a);
		return m;
	}
	//회원가입
	@Override
	public int addid (Map<String, Object> map) {
		login_DTO dto = new login_DTO();
		dto.setID( (String) map.get("Id1") );
		dto.setPWD( (String) map.get("PW1") );
		dto.setNIC( (String) map.get("nic") );
		dto.setEMAIL( (String) map.get("mail") );
		dto.setPN( (String) map.get("pn1")+"-"+map.get("pn2") );
		dto.setPHONE( (String) map.get("phone1")+"-"+map.get("phone2")+"-"+map.get("phone3") );
		return javaDAO.addId(dto);
	}
	//아자스로 중복체크
	@Override
	public int what(Map map) {
		List<login_DTO> list = javaDAO.listID();
		int a=1;
		if(map.get("Id1")!=null) {
			for(login_DTO i : list) {
				if(i.getID().equals(map.get("Id1"))) a--;
			}
		};
		if(map.get("nic")!=null) {
			for(login_DTO i : list) {
				if(i.getNIC().equals(map.get("nic"))) a--;
			}
		};
		if(map.get("mail")!=null) {
			for(login_DTO i : list) {
				if(i.getEMAIL().equals(map.get("mail"))) a--;
			}
		};
		if(map.get("pn1")!=null) {
			String pn = (String) map.get("pn1")+"-"+map.get("pn2");
			for(login_DTO i : list) {
				if(i.getID().equals(pn)) a--;
			}
		};
		if(map.get("phone1")!=null) {
			String phone = (String) map.get("phone1")+"-"+map.get("phone2")+"-"+map.get("phone3");
			for(login_DTO i : list) {
				if(i.getID().equals(phone)) a--;
			}
		};
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
		map.put("countPerPage", countPerPage);
		
		
		
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

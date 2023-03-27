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
	
	@Override
	public int artistplus(AlbumDTO dto) {
		System.out.println("아티스트 추가!!!");
		return javaDAO.artistplus(dto);
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
		int totalCount = javaDAO.totalpage(country);
		
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
	
	//비밀번호 찾기
	@Override	
	public List searchPW(login_DTO dto) {
		System.out.println("아이디를 검색합니다");
		System.out.println("ID >>>>>>"+dto.getID());
		System.out.println("NIC >>>>>>"+dto.getNIC());
		List searchPW= javaDAO.searchPW(dto);
		return searchPW;
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
	
	//범주 플레이 리스트 수정하기
	@Override
	public void editPlayList(Map info)
	{
		System.out.println("JavafoodServiceImpl의 editPlayList 메서드 실행됨."); //확인용
		
		//DAO의 editPlayList 메서드 실행하기
		javaDAO.editPlayList(info);
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
	
	//범주 플레이 리스트 내역의 선택된 곡 삭제하기
	@Override
	public void deleteCheckedSongs(Map info)
	{
		System.out.println("JavafoodServiceImpl의 deleteCheckedSongs 메서드 실행됨."); //확인용
		
		//dao의 deleteCheckedSongs 메서드 실행하기.
		javaDAO.deleteCheckedSongs(info);
	}
////////////////////////////////////////////////////////////
//경용
	/**
	 * 로그인
	 * @paramMap map : 로그인 정보 받아오기
	 * @return map : 세션에 저장할값, 로그인 성공 여부 리턴
	 */
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
	
	/**
	 * 회원가입
	 * @paramMap map : 회원가입 값 받아오기
	 * @returnint : 회원가입 성공여부 리턴
	 */
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
	
	/**
	 * 아자스로 회원값 중복체크
	 * @paramMap map : 중복채크 하는 값 받아오기
	 * @returnint : 중복여부 리턴
	 */
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
	
	/**
	 * 회원 탈퇴
	 * @paramString id : 탈퇴하는 아이디값 받아오기
	 * @returnint : 회원탈퇴 성공여부 리턴
	 */
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
	
	/**
	 * 로그인 회원 재생목록
	 * @paramString id : 세션의 로그인된 아이디값 가져오기
	 * @paramint i : 현제 페이지 숫자
	 * @returnMap : 현제 페이지의 내용 리턴
	 */
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
	/**
	 * 회원정보 수정
	 * @paramMap map : 회원정보 수정할 값
	 * @paramString id : 수정할 아이디 값
	 * @returnint : 회원정보 수정 성공여부
	 */
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
	
	/**
	 * 좋아요 증가
	 * @paramString songnumb : 좋아요 증가할 노래 번호
	 * @paramString id : 좋아요 누르는 아이디값
	 * @returnint : 좋아요 성공 여부
	 */
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
	
	/**
	 * 조회수 증가
	 * @paramString song : 조회수 증가할 노래 번호
	 * @paramString id : 조회수 증가할 아이디값
	 * @returnint : 조회수 증가 성공 여부
	 */
	public int songhit(String song,String id) {
		log.info("조회수 증가 서비스");
		return javaDAO.songhit(song, id);
	}
	
	/**
	 * 매뉴 상단바 검색
	 * @paramMap map : 검색할 옵션값, 검색내용
	 * @returnList : 검색 결과값 리턴
	 */
	public List<GenreDTO> Search(Map<String, Object> map){
		log.info("서비스 검색 시작");
		List<GenreDTO> list = javaDAO.Search(map);
		System.out.println("list : "+list.get(0).getAlbum_name());
		System.out.println("list : "+list.get(1).getAlbum_name());
		System.out.println("list : "+list.get(2).getAlbum_name());
		System.out.println("list : "+list.get(3).getAlbum_name());
		System.out.println("list : "+list.get(4).getAlbum_name());
		System.out.println("list : "+list.get(5).getAlbum_name());
		return list;
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
		
	// 음악추가 페이지
		
		@Override
		public int insertsong(GenreDTO dto) {
			
			if(
					dto.getArtistname() != null && dto.getArtistname() != "" && 
					dto.getSongname() != null && dto.getSongname() != "" && 
					dto.getLink() != null && dto.getLink() != "" &&
					dto.getAlbum_name() != null && dto.getAlbum_name() != "" &&
					dto.getBygenre() != null && dto.getBygenre() != "" &&
					dto.getPlaytime() != null && dto.getPlaytime() != "" &&
					dto.getImagelink() != null && dto.getImagelink() != "" &&
					dto.getAlbum_add() != null && dto.getAlbum_add() != "" &&
					dto.getArtist_add() != null && dto.getArtist_add() != "" &&
					dto.getCountry() != null && dto.getCountry() != ""
					
				) {
				System.out.println("server insert 입력 성공");
				return javaDAO.insertsong(dto);
				
			} else {
				System.out.println("server insert 모든 값을 입력하시오. ");
			}
			return 0;
		}
		
		//Genre관리자 페이지에서 목록 전체조회 출력
		@Override
		public List<GenreDTO> listGenre(){

			System.out.println("list장르 메소드 접속!!");
			List<GenreDTO> listGenre= javaDAO.listGenre();
			return listGenre;			
		}
		
		@Override
		public List<AlbumDTO> listArtist() {
			System.out.println("list아티스트 메소드 접속!!");
			List<AlbumDTO> listArtist= javaDAO.listArtist();
			return listArtist;
		}
		@Override
		public List<AlbumDTO> listAlbum() {
			System.out.println("list앨범 메소드 접속!!");
			List<AlbumDTO> listAlbum= javaDAO.listAlbum();
			return listAlbum;
		}
		@Override
		public List<AlbumDTO> listIntoAlbum() {
			System.out.println("list수록곡 메소드 접속!!");
			List<AlbumDTO> listIntoAlbum= javaDAO.listIntoAlbum();
			return listIntoAlbum;
		}
		@Override
		public List<CommentDTO> listComment() {
			System.out.println("댓글조회 메소드 접속!!");
			List<CommentDTO> listComment= javaDAO.listComment();
			return listComment;
		}

		//관리자페이지에서 아티스트 이름 검색했을 때
		@Override	
		public List searchArtist(String artist) {
			System.out.println("searchArtist 메소드 접속!!");
			List searchArtist= javaDAO.searchArtist(artist);
			return searchArtist;
		}
		//intoAlbum 관리페이지에서 앨범 이름 검색했을 때
		@Override	
		public List searchInto(String album) {
			System.out.println("searchAlbum 앨범조회 접속!!");
			List searchAlbum= javaDAO.searchInto(album);
			return searchAlbum;
		}
		//앨범관리페이지에서 각각 이름 검색했을 때
		@Override	
		public List searchAlbum(AlbumDTO dto) {
			System.out.println("searchAlbum 앨범검색메소드 접속!!");
			System.out.println("opt >>>>>>"+dto.getOpt());
			System.out.println("album_name >>>>>>"+dto.getAlbum_name());
			List searchAlbum= javaDAO.searchAlbum(dto);
			return searchAlbum;
		}
		
		
		// 음악추가 페이지
		
				@Override
				public int update_song(GenreDTO dto) {
					
					if(
							dto.getArtistname() != null && dto.getArtistname() != "" && 
							dto.getSongname() != null && dto.getSongname() != "" && 
							dto.getLink() != null && dto.getLink() != "" &&
							dto.getAlbum_name() != null && dto.getAlbum_name() != "" &&
							dto.getBygenre() != null && dto.getBygenre() != "" &&
							dto.getPlaytime() != null && dto.getPlaytime() != "" &&
							dto.getImagelink() != null && dto.getImagelink() != "" &&
							dto.getAlbum_add() != null && dto.getAlbum_add() != "" &&
							dto.getArtist_add() != null && dto.getArtist_add() != "" &&
							dto.getCountry() != null && dto.getCountry() != ""
							
						) {
						System.out.println("server update 성공");
						return javaDAO.update_song(dto);
						
					} else {
						System.out.println("server update 모든 값을 입력하시오. ");
					}
					return 0;
				}
				
				
				
	//앨범 수정
		@Override
		public int update_album(AlbumDTO dto) {
			return javaDAO.update_album(dto);
		}
	//아티스트 수정
		@Override
		public int update_artist(AlbumDTO dto) {
			return javaDAO.update_artist(dto);
		}
		
		// 음악 삭제
				
				@Override
				public int delete_song(GenreDTO dto) {
					
					System.out.println("server delete 성공");
					return javaDAO.delete_song(dto);
				}
		
		//관리자 앨범페이지 에서 앨범 삭제할 때
		@Override
		public int delAlbum(int album_num) {
					
			System.out.println("album delete 성공");
			return javaDAO.delAlbum(album_num);
		}
				
		//아이디 찾기
		@Override	
		public List searchID(login_DTO dto) {
			System.out.println("닉네임을 검색합니다!!");
			System.out.println("nic >>>>>>"+dto.getNIC());
			System.out.println("phone >>>>>>"+dto.getPHONE());
			List searchID= javaDAO.searchID(dto);
			return searchID;
		}

		
		//관리자페이지에서 장르로 검색했을 때
		@Override	
		public List searchGenre(String genre) {
			System.out.println("searchArtist 메소드 접속!!");
			List searchGenre= javaDAO.searchGenre(genre);
			return searchGenre;
		}
}



////////////////////////////////////////////////////////////



package com.java.food.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.food.dto.AlbumDTO;
import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
import com.java.food.dto.GenreDTO;
import com.java.food.dto.PlayListDTO;
import com.java.food.dto.SongHit_DTO;
import com.java.food.dto.login_DTO;

@Repository
public class JavafoodDAOImpl implements JavafoodDAO {

	private static final Logger logger = LoggerFactory.getLogger(JavafoodDAOImpl.class);

@Autowired
SqlSession sqlSession;

////////////////////////////////////////////////////////////
//다영
		/**
		 * 다영
		 * 아티스트 페이지 출력 메소드
		 * 전달인자 : String (아티스트 이름)
		 * @return : list
		 */
		@Override
		public List viewArtist(String artist) {
			logger.info("JavafoodDAOImpl > viewArtist 실행");
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.viewArtist", artist);
			logger.info("Artist list.size >>>"+list.size()); 
			
			return list;
		}
		/**
		 * 다영
		 * 앨범 페이지 출력 메소드
		 * @param  : album > String (앨범이름)
		 * @return : list
		 */
		@Override
		public List viewAlbum(String album) {
			logger.info("JavafoodDAOImpl > viewAlbum 실행");
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.viewAlbum", album);
			logger.info("Album list.size >>>"+list.size()); 
			
			return list;
		}

		/**
		 * 다영
		 * 댓글 출력 메소드
		 * 전달인자 : String (아티스트 이름)
		 * @return : list
		 */
		@Override
		public List viewComment(String artist) {
			logger.info("JavafoodDAOImpl > viewComment 실행");
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.viewComment", artist);
			logger.info("Comment list.size >>>"+list.size()); 
			
			return list;
		}
		
		@Override
		public int insertComment(CommentDTO dto) {
			logger.info("JavafoodDAOImpl > insertComment 실행");
			int count = sqlSession.insert("mapper.javafood.plusComment", dto);
			
			return count;
			
		}
		
		@Override
		public int replyComment(CommentDTO dto) {
			logger.info("JavafoodDAOImpl > replyComment 실행");
			int count = sqlSession.insert("mapper.javafood.replyComment", dto);
			
			return count;
		}
		/**
		 * 다영
		 * 댓글 삭제 메소드
		 * 전달인자 : int (부모댓글 숫자)
		 * @return : int
		 */
		@Override
		public int delComment(int articleNO) {
			//logger.info("JavafoodDAOImpl > delComment 실행");
			int article = sqlSession.insert("mapper.javafood.delComment", articleNO);
			
			return article;
		}
		
		/**
		 * 다영
		 * 리스트에 넣은 장르를 랜덤으로 뽑아 불러내는 메소드
		 * 전달인자 : String (장르 이름)
		 * @return : list
		 */
		@Override
		public List randomGenre(String genre) {
			logger.info("JavafoodDAOImpl > randomGenre 실행");
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.randomGenre", genre);
		
			return list;
		}
		
		@Override
		public int albumplus(AlbumDTO dto){
			logger.info("앨범을 추가합니다 실행");
			int album = sqlSession.insert("mapper.javafood.plusAlbum", dto);
		
			return album;
		} 
		
		@Override
		public int artistplus(AlbumDTO dto){
			logger.info("아티스트를 추가합니다 실행");
			int artist = sqlSession.insert("mapper.javafood.artistplus", dto);
			
			return artist;
		} 
		
		/**
		 * 다영
		 * DB에서 아티스트 8명 랜덤으로 뽑아오는 메소드
		 */
		@Override
		public List randomArtist() {
			logger.info("아티스트 8명을 추가합니다 실행");
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.randomArtist");
			System.out.println("randomArtist"+list.size());

			return list;
		}

////////////////////////////////////////////////////////////
//귀범

//@Override
//public List<FamousChartDTO> getChart(String songnumber) {
//	List list = new ArrayList();
//	list = sqlSession.selectList("mapper.javafood.getChart", songnumber);
//	logger.info("list.size : "+ list.size());
//	return list;
//}

@Override
public List chart(String country, int start, int end) {
	
	Map map = new HashMap();
	map.put("country", country);
	map.put("start", start);
	map.put("end", end);
//	List temp = new ArrayList();
//	temp.add(fc);
//	temp.add(start);
//	temp.add(end);
	System.out.println("temp : " + map);
	
	List list = sqlSession.selectList("mapper.javafood.chart", map);	//selectList("sql 특정", sql로 전달할 전달인자)
	
	System.out.println("DAO list.size : " +list.size());
//	for(int i=0; i<list.size(); i++) {
//		System.out.println("DAO list : "+ list.get(i));
//	}
	return list;
	
}

@Override
public int totalpage(String country) {
	
	int totalcount = sqlSession.selectOne("mapper.javafood.totalpage", country);
	System.out.println("DAOimpl : " +totalcount);
	
	return totalcount;
}

@Override
public void addhit(String id, String songnumber) {
	
	Map map = new HashMap();
	map.put("id", id);
	map.put("songnumber", songnumber);
	
	int a = sqlSession.update("mapper.javafood.addhit", map);
	System.out.println("update 횟수 : " + a);
	
}

// service에서 쓸 메소드 생성
// 전달인자 x
// List를 jsp로 호출
@Override
public List<FamousChartDTO> selectDance(String genre){
	
	List<FamousChartDTO> page = null;
	page = sqlSession.selectList("mapper.javafood.selectDance", genre);
	
	return page;
}


//비밀번호 찾기
		@Override
		public List searchPW(login_DTO dto) {
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.searchPW", dto);
			System.out.println(dto.getID()+" : 조회");
			return list;
		}
////////////////////////////////////////////////////////////
//범주
@Override
/**
 * 플레이 리스트를 List에 담아 return 합니다.
 * 전달인자 : id(String)
 */
public List<PlayListDTO> selectPlayList(String id)
{
	System.out.println("JavafoodDAOImpl의 selectPlayList 메서드 실행됨."); //확인용
	
	List<PlayListDTO> result = null;
	
	//sql을 이용하여 DB에 접속 후 플레이 리스트 가져오기
	//가져온 리스트를 필드에 담기
	result = sqlSession.selectList("mapper.javafood.selectPlayList", id);
	System.out.println("sqlSession을 이용하여 가져온 리스트의 크기는 : " + result.size() ); //확인용
	
	return result;
}

@Override
public List<PlayListDTO> selectPlayListPoster(String id)
{
	System.out.println("JavafoodDAOImpl의 selectPlayListPoster 메서드 실행됨."); //확인용
	
	List<PlayListDTO> result = null;
	
	//sql을 이용하여 DB에 접속 후 플레이 리스트의 표지를 가져오기
	//가져온 리스트를 필드에 담기
	result = sqlSession.selectList("mapper.javafood.selectPlayListPoster", id);
	System.out.println("sqlSession을 이용하여 가져온 리스트의 크기는 : " + result.size() ); //확인용
	
	return result;
}

@Override
/**
 * 플레이 리스트의 내역(Content)를 List에 담아 return 합니다.
 * 전달인자 : 플레이 리스트의 id(String)
 */
public List<PlayListDTO> selectPlayListContent(String pl_id)
{
	System.out.println("JavafoodDAOImpl의 selectPlayList 메서드 실행됨."); //확인용
	
	List<PlayListDTO> result = null;
	
	//sql을 이용하여 DB에 접속 후 플레이 리스트 가져오기
	//가져온 리스트를 필드에 담기
	result = sqlSession.selectList("mapper.javafood.selectPlayListContent", pl_id);
	System.out.println("sqlSession을 이용하여 가져온 리스트의 크기는 : " + result.size() ); //확인용
	
	return result;
}

@Override
/**
 * 플레이 리스트의 제목, 설명, 표지를 수정합니다. (리턴 : void)
 * 전달인자 : 수정할 플레이 리스트의 아이디(pl_id), 수정할 제목, 설명, 표지 이미지의 링크가 담긴 Map
 */
public void editPlayList(Map info)
{
	System.out.println("JavafoodDAOImpl의 editPlayList 메서드 실행됨."); //확인용
	
	//sql을 이용하여 DB에 접속 후 플레이 리스트 수정하기
	int result = sqlSession.update("mapper.javafood.editPlayList", info);
	if(result >= 1) //확인용
	{
		System.out.println("editPlayList 성공!!");
	}
	else
	{
		System.out.println("editPlayList 실패...");
	}
}

@Override
/**
 * 플레이 리스트를 추가합니다.(리턴 : void)
 * 전달인자 : id, title, explain이라는 key와 value가 담긴 Map<String, String>
 */
public void addPlayList(Map<String, String> info)
{
	System.out.println("JavafoodDAOImpl의 addPlayList 메서드 실행됨."); //확인용
	
	//sql을 이용하여 DB에 접속해 데이터를 추가(insert)하기
	int result = sqlSession.insert("mapper.javafood.addPlayList", info);
	if(result >= 1) //확인용
	{
		System.out.println("addPlayList 성공!!");
	}
	else
	{
		System.out.println("addPlayList 실패...");
	}
}

@Override
/**
 * 플레이 리스트 내역(곡)을 삭제합니다. (리턴 : void)
 * 전달인자 : listNumber, pl_id라는 key와 value가 담긴 Map<String, String>
 */
public void deletePlayListContent(Map<String, String> info)
{
	System.out.println("JavafoodDAOImpl의 deletePlayListContent 메서드 실행됨."); //확인용
	
	//sql을 이용하여 DB에 접속해 데이터를 삭제(delete)하기
	int result = sqlSession.delete("mapper.javafood.deletePlayListContent", info);
	if(result >= 1) //확인용
	{
		System.out.println("deletePlayListContent 성공!!");
	}
	else
	{
		System.out.println("deletePlayListContent 실패...");
	}
}

@Override
/**
 * 플레이 리스트를 삭제합니다. (리턴 : void)
 * 전달인자 : id, pl_id라는 key와 value가 담긴 Map<String, String>
 */
public void deletePlayList(Map<String, String> info)
{
	System.out.println("JavafoodDAOImpl의 deletePlayList 메서드 실행됨."); //확인용
	
	//sql을 이용하여 DB에 접속해 데이터를 삭제(delete)하기
	int result = sqlSession.delete("mapper.javafood.deletePlayList", info);
	//확인용
	if(result >= 1)
	{
		System.out.println("deletePlayList 성공!!");
	}
	else
	{
		System.out.println("deletePlayList 실패...");
	}
}

@Override
/**
 * genre 테이블에서 인기곡 리스트 40곡을 불러옵니다.
 * 전달인자 : 없음
 */
public List<GenreDTO> selectHitList()
{
	System.out.println("JavafoodDAOImpl의 selectHitList 메서드 실행됨."); //확인용
	
	//sql을 이용하여 DB에 접속해 genre 테이블의 곡 40곡 리스트를 가져오기
	//가져온 곡 리스트를 리스트에 담기
	List<GenreDTO> result = sqlSession.selectList("mapper.javafood.selectHitList");
	System.out.println("selectHitList 메서드를 실행하여 가져온 리스트의 크기는 : " + result.size() ); //확인용
//	for(int i=0; i<result.size(); i++) //확인용
//	{
//		System.out.println("result 데이터 확인중 : " + result.get(i).getSongname() );
//	}
	
	//담은 리스트를 리턴하기.
	return result;
}

@Override
/**
 * 플레이 리스트에 곡을 추가하는 메서드 입니다. (리턴 : void)
 * 전달인자 : 추가할 곡들의 songNumber들이 담긴 List와, 추가할 플레이 리스트의 id(pl_id)가 들어가야 합니다.
 */
public void addContent(Map info)
{
	System.out.println("JavafoodDAOImpl의 addContent 메서드 실행됨."); //확인용
	
	int insert = 0;
	
	//pl_id를 변수에 담기
	String pl_id = (String)info.get("pl_id");
	System.out.println("info 맵에 담긴 pl_id의 값은 : " + pl_id);
	
//	//만약 pl_id의 값이 new라면 insert를 이용하여 플레이 리스트를 추가하기
//	if(pl_id.equals("new") )
//	{
//		//sql을 이용하여 새로운 플레이 리스트 추가하기
//		sqlSession.insert(")
//	}
	
	//for문을 이용하여 insert를 songNumber 갯수 만큼 시도하기
	for(int i=0; i<( (String[])info.get("songNumber") ).length; i++)
	{
		//HashMap에 담긴 songNumber 리스트 요소를 불러오기
		//불러온 요소를 필드에 담기
		String tempSongNumber = ( (String[])info.get("songNumber") )[i];
		System.out.println("addContent의 tempSongNumber는 : " + tempSongNumber); //확인용
		System.out.println("addContent의 pl_id는 : " + (String)info.get("pl_id") ); //확인용
		
		//HashMap에 tempSongNumber와 pl_id를 담기
		Map tempInfo = new HashMap();
		tempInfo.put("songNumber", tempSongNumber);
		tempInfo.put("pl_id", info.get("pl_id") );
		
		int result = sqlSession.insert("mapper.javafood.addContent", tempInfo);
		if(result > 0)
		{
			insert++;
		}
	}
	
	System.out.println("추가 할 곡의 수 : " + ( (String[])info.get("songNumber") ).length); //확인용
	System.out.println("추가 된 곡의 수 : " + insert); //확인용
	
}

@Override
/**
 * 	플레이 리스트 내역의 선택된 곡을 삭제합니다.
 *  전달인자 : 삭제할 곡들의 listNumber가 담긴 리스트와, 추가할 플레이 리스트의 id(pl_id)가 들어가야 합니다.
 */
public void deleteCheckedSongs(Map info)
{
	System.out.println("JavafoodDAOImpl의 deleteCheckedSongs 메서드 실행됨."); //확인용
	
	int delete = 0;
	
	//for문을 이용하여 insert를 songNumber 갯수 만큼 시도하기
	for(int i=0; i<( (String[])info.get("listNumber") ).length; i++)
	{
		//HashMap에 담긴 songNumber 리스트 요소를 불러오기
		//불러온 요소를 필드에 담기
		String tempListNumber = ( (String[])info.get("listNumber") )[i];
		System.out.println("deleteCheckedSongs의 tempListNumber는 : " + tempListNumber); //확인용
		System.out.println("deleteCheckedSongs의 pl_id는 : " + (String)info.get("pl_id") ); //확인용
		
		//HashMap에 tempSongNumber와 pl_id를 담기
		Map tempInfo = new HashMap();
		tempInfo.put("listNumber", tempListNumber);
		tempInfo.put("pl_id", info.get("pl_id") );
		
		int result = sqlSession.insert("mapper.javafood.deletePlayListContent", tempInfo);
		if(result > 0)
		{
			delete++;
		}
	}
	
	System.out.println("삭제 할 곡의 수 : " + ( (String[])info.get("listNumber") ).length); //확인용
	System.out.println("삭제 된 곡의 수 : " + delete); //확인용
	
}
////////////////////////////////////////////////////////////

	//경용
	/**
	 * 아이디 리스트
	 * @return list : 회원정보를 리턴해줍니다.
	 */
	@Override
	public List<login_DTO> listID() {
		return sqlSession.selectList("mapper.javafood.login");
	}
	
	/**
	 * 회원가입
	 * @paramlogin_DTO : 가입할 회원정보 DTO를 넣어줍니다.
	 * @return : 가입 성공 여부
	 */
	@Override
	public int addId(login_DTO vo) {
		int i =0;
		try {
			sqlSession.insert("mapper.javafood.newures",vo);
			i=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * 회원탈퇴
	 * @paramString : 탈퇴할 세션 아이디값.
	 * @return : 탈퇴 성공 여부
	 */
	@Override
	public int outId(String id) {
		int a = 0;
		try {
			a = sqlSession.delete("mapper.javafood.outId",id);
			sqlSession.close();
		} catch (Exception e) {
		}
		return a;
	}
	/**
	 * 회원 재생목록 가져오기
	 * @paramString : 가져올 아이디 값.
	 * @return : 탈퇴 성공 여부
	 */
	@Override
	public List<SongHit_DTO> loginplay(String id) {
		List<SongHit_DTO> list = new ArrayList<SongHit_DTO>(); 
		try {
			logger.info("sql 가져오기");
			list = sqlSession.selectList("mapper.javafood.SongHit",id);
		} catch (Exception e) {
			logger.info("dao 오류");
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 아자스를 이용한 좋아요 증가
	 * @paramMap : id : 가져올 아이디 값.
	 * 				song : 좋아요 증가할 노래 번호 값.
	 * @return : 좋아요 증가 성공 여부
	 */
	@Override
	public int good(Map<String, Object> map) {
		logger.info("good dao 실행");
		int i=0;
		try {
			sqlSession.insert("mapper.javafood.good",(String)map.get("song"));
			i++;
		} catch (Exception e) {
			logger.info("good dao 오류 로그인을 하셔야 합니다.");
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * 아자스를 이용한 조회수 증가
	 * @paramMap : id : 가져올 아이디 값.
	 * 				song : 조회수 증가할 노래 번호 값.
	 * @return : 조회수 증가 성공 여부
	 */
	@Override
	public int songhit(String song,String id) {
		logger.info("songhit dao 실행");
		
		SongHit_DTO dto = new SongHit_DTO();
		dto.setID(id);
		dto.setSONGNUMBER(song);
		System.out.println("dto : "+dto.getID());
		System.out.println("dto : "+dto.getSONGNUMBER());
		
		int i = sqlSession.selectOne("mapper.javafood.hitid", dto);
		
		System.out.println("아이디에 조회된 노래 유무: "+i);
		try {
			if(i==0) {
				logger.info("아이디가 없습니다. 아이디 생성");
				sqlSession.insert("mapper.javafood.hitaddid",dto);
				sqlSession.insert("mapper.javafood.addgenrehit",dto);
				logger.info("조회수 증가");
			}else {
				logger.info("조회수 증가");
				sqlSession.insert("mapper.javafood.addsonghit",dto);
				sqlSession.insert("mapper.javafood.addgenrehit",dto);
			}
		} catch (Exception e) {
			logger.info("로그인을 해야 조회수가 증가합니다.");
			e.getMessage();
		}
		return sqlSession.insert("mapper.javafood.hits",dto.getSONGNUMBER());
	}

	/**
	 * 매뉴 상단바 검색
	 * @paramMap : opt : 검색주제 , 
	 * 				pot : 검색내용
	 * @return : list : 결과값
	 */
	@Override
	public List<GenreDTO> Search(Map<String, Object> map){
		logger.info("검색 dao 시작");
		System.out.println("opt : "+map.get("opt"));
		System.out.println("pot : "+map.get("pot"));
		
		return sqlSession.selectList("mapper.javafood.search",map);
	}
////////////////////////////////////////////////////////////
//용준
	// 장르별
	public List getGenre(String genre, int start, int end) {
		
		Map map = new HashMap();
		map.put("genre", genre);
		map.put("start", start);
		map.put("end", end);
		
		List list = sqlSession.selectList("mapper.javafood.genre",map);
		
		return list;
	}
	
	// 장르 페이징
	public int pagetotal(String song) {
		int totalcnt = sqlSession.selectOne("mapper.javafood.pagetotal",song);
		System.out.println(totalcnt);
		return totalcnt;
	}
	
	// 최신음악
		public List getMusic(int start, int end) {
			
			Map map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			
			List list = sqlSession.selectList("mapper.javafood.song",map);
			
			return list;
		}
		
		// 최신음악 페이징
		public int pagetotal_Music() {
			int totalcnt = sqlSession.selectOne("mapper.javafood.pagetotal_song");
			System.out.println(totalcnt);
			return totalcnt;
		}
		
		// 음악 추가 페이지
		public int insertsong(GenreDTO dto) {
			int insert = sqlSession.insert("mapper.javafood.insert_song", dto);
			System.out.println("dao에 insert : " + insert);
			return insert;
		}
		
		//Genre관리자 페이지에서 목록 전체조회 출력
		@Override
		public List<GenreDTO> listGenre(){
			List<GenreDTO> list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.listGenre");
			logger.info("Album list.size >>>"+list.size()); 
			return list;			
		}
				
		@Override
		public List<AlbumDTO> listArtist() {
			List<AlbumDTO> list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.listArtist");
			logger.info("Artist list.size >>>"+list.size()); 
			return list;
		}
		@Override
		public List<AlbumDTO> listAlbum() {
			List<AlbumDTO> list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.listAlbum");
			logger.info("Album list.size >>>"+list.size()); 
			return list;
		}
		@Override
		public List<AlbumDTO> listIntoAlbum() {
			List<AlbumDTO> list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.listIntoAlbum");
			logger.info("intoAlbum list.size >>>"+list.size()); 
			return list;
		}
		@Override
		public List<CommentDTO> listComment() {
			List<CommentDTO> list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.listComment");
			logger.info("listComment list.size >>>"+list.size()); 
			return list;
		}
		//아티스트관리페이지에서 검색조회
		@Override
		public List searchArtist(String artist) {
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.searchArtist", artist);
			System.out.println(artist+" : 조회!!!!!");
			return list;
		}
		
		
		//intoAlbum관리페이지에서 앨범검색조회
		@Override
		public List searchInto(String album) {
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.searchInto", album);
			System.out.println(album+" : 앨범조회!!!!!");
			return list;
		}
		//앨범관리페이지에서 검색조회
		@Override
		public List searchAlbum(AlbumDTO dto) {
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.searchAlbum", dto);
			System.out.println(dto+" : !!!search조회!!!!!");
			return list;
		}
		// 음악 수정 페이지
		public int update_song(GenreDTO dto) {
			int update = sqlSession.update("mapper.javafood.update_song", dto);
			System.out.println("dao에 update : " + update);
			return update;
		}
		

		// 아티스트테이블 수정 페이지
		public int update_artist(AlbumDTO dto) {
			int update = sqlSession.update("mapper.javafood.update_artist", dto);
			System.out.println("artist DB에 업데이트! : " + update);
			return update;
		}
		// 앨범테이블 수정 페이지
		public int update_album(AlbumDTO dto) {
			int update = sqlSession.update("mapper.javafood.update_album", dto);
			System.out.println("album_3에 업데이트! : " + update);
			return update;
		}
		// 음악 삭제 페이지
		public int delete_song(GenreDTO dto) {
			int delete = sqlSession.delete("mapper.javafood.delete_song", dto);
			System.out.println("dao에 delete : " + delete);
			return delete;

		}
		//앨범관리페이지에서 앨범 삭제
		@Override
		public int delAlbum(int album_num) {
			int delete = sqlSession.delete("mapper.javafood.delete_album", album_num);
			System.out.println("album delete : " + delete);
			return delete;

		}
		
		//아이디 찾기
		@Override
		public List searchID(login_DTO dto) {
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.searchID", dto);
			System.out.println(dto.getNIC()+" : 조회!!!!!");
			return list;
		}
		
		//아티스트관리페이지에서 검색조회
		@Override
		public List searchGenre(String genre) {
			List list = new ArrayList();
			list = sqlSession.selectList("mapper.javafood.searchGenre", genre);
			System.out.println(genre+" : 조회!!!!!");
			return list;
		}


////////////////////////////////////////////////////////////

}

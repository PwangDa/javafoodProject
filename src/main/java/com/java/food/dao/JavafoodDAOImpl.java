package com.java.food.dao;

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
	
	List list = sqlSession.selectList("mapper.javafood.chart", map);
	
	System.out.println("list.size : " +list.size());
	for(int i=0; i<list.size(); i++) {
		System.out.println("list : "+ list.get(i));
	}
	return list;
	
}

@Override
public int totalpage() {
	
	int totalcount = sqlSession.selectOne("mapper.javafood.totalpage");
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
		logger.info("good dao 오류");
		e.printStackTrace();
	}
	return i;
}

/**
 * 아자스를 이용한 조회수 증가
 * @paramMap : id : 가져올 아이디 값.
 * 				song : 조회수 증가할 노래 번호 값.
 * @return : 좋아요 증가 성공 여부
 */
@Override
public int songhit(String song,String id) {
	logger.info("songhit dao 실행");
	
	int i = sqlSession.selectOne("mapper.javafood.hitid", id);
	System.out.println("아이디에 조회된 노래 : "+i);
	if(i==0) {
		SongHit_DTO dto = new SongHit_DTO();
		dto.setID(id);
		dto.setSONGNUMBER(song);
		sqlSession.insert("mapper.javafood.hitaddid",dto);
	}else {
		
	}
	
	return i;
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
		


	


////////////////////////////////////////////////////////////

}

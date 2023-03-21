package com.java.food.dao;

import java.util.List;
import java.util.Map;

import com.java.food.dto.AlbumDTO;
import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
import com.java.food.dto.GenreDTO;
import com.java.food.dto.PlayListDTO;
import com.java.food.dto.SongHit_DTO;
import com.java.food.dto.login_DTO;

public interface JavafoodDAO {
	
////////////////////////////////////////////////////////////
//다영
	List viewArtist(String artist);
	
	List viewComment(String artist);
	
	List viewAlbum(String album);
	
	int insertComment(CommentDTO dto);
	int replyComment(CommentDTO dto);
	
	int delComment(int articleNO);
	
	List randomGenre(String genre);
	List randomArtist();
	
	int albumplus(AlbumDTO dto);
	
////////////////////////////////////////////////////////////
//귀범
//	// 차트용
//	List<FamousChartDTO> getChart(String songnumber);
	
	// 차트
	List chart(String country, int start, int end);
	
	// 페이징
	int totalpage();
	
	// 조회수 증가
	void addhit(String id, String songnumber);
	
	// 댄스 장르 출력
	List<FamousChartDTO> selectDance(String genre);
	
////////////////////////////////////////////////////////////
//범주
	//플레이 리스트 불러오기
	List<PlayListDTO> selectPlayList(String id);
	
	//플레이 리스트 내역(Content) 불러오기
	List<PlayListDTO> selectPlayListContent(String pl_id);
	
	//플레이 리스트 추가하기
	void addPlayList(Map<String, String> info);
	
	//플레이 리스트 내역(Content) 삭제하기
	void deletePlayListContent(Map<String, String> info);
	
	//플레이 리스트 삭제하기
	void deletePlayList(Map<String, String> info);
	
	//메인페이지 인기곡 리스트 불러오기
	List<GenreDTO> selectHitList();
	
	//플레이 리스트에 곡 추가하기
	void addContent(Map info);
////////////////////////////////////////////////////////////
//경용
	//로그인 정보 확인
	List<login_DTO> listID(); 
	//회원가입
	int addId(login_DTO dto);
	//회원탈퇴
	int outId(String id);
	//회원 재생목록
	List<SongHit_DTO> loginplay(String id); 
	//좋아요 증가
	int good(Map<String, Object> map);
	//조회수 증가
	int songhit(String song,String id);
////////////////////////////////////////////////////////////
//용준
	// 장르
	List getGenre(String genre, int start, int end);
	
	// 페이징
	int pagetotal(String song);
	
	// 최신음악
	List getMusic(int start, int end);
	
	// 최신음악 페이징
	int pagetotal_Music();
	
	// 음악추가 페이지
	int insertsong(GenreDTO dto);
////////////////////////////////////////////////////////////

	

	//되나요?
	//넹 고마워요
}

package com.java.food.dao;

import java.util.List;
import java.util.Map;

import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
import com.java.food.dto.PlayListDTO;
import com.java.food.dto.login_DTO;

public interface JavafoodDAO {
	
////////////////////////////////////////////////////////////
//다영
	List viewArtist(String artist);
	
	List viewComment(String artist);
	
	List viewAlbum(String album);
	
	int insertComment(CommentDTO dto);
	
	int delComment(int articleNO);
	
	List randomGenre(String genre);
	
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
////////////////////////////////////////////////////////////
//경용
	//로그인 정보 확인
	List<login_DTO> listID(); 
	//회원가입
	int addId(login_DTO dto);
////////////////////////////////////////////////////////////
//용준
	// 장르
	List getGenre(String genre, int start, int end);
	
	// 페이징
	int pagetotal();
	
	// 최신음악
	List getMusic(int start, int end);
	
	// 최신음악 페이징
	int pagetotal_Music();
////////////////////////////////////////////////////////////

	

	//되나요?

}

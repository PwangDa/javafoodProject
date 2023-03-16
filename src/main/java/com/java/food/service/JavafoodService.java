package com.java.food.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
import com.java.food.dto.PlayListDTO;
import com.java.food.dto.login_DTO;

@Service
public interface JavafoodService {
////////////////////////////////////////////////////////////
//다영
	List getArtist(String artist);
	List getComment(String artist);
	List getAlbum(String album);
	int insertComment(CommentDTO dto);
	int delComment(int articleNO);
	List randomGenre(String genre);
////////////////////////////////////////////////////////////
//귀범
//	List<FamousChartDTO> getChart(String songnumber);
	
	Map chart(String songnum, int pageNum, int countPerPage);
	
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
	//로그인
	Map login(Map<String, Object> map);
	//회원가입
	int addid(Map<String, Object> map);
	//아자스 중복체크
	int what (Map map);
////////////////////////////////////////////////////////////
//용준
	// 장르
	Map getGenre(String song, int pageNum, int countPerPage);
	
	// 최신음악
	Map getMusic(int pageNum, int countPerPage);
	
////////////////////////////////////////////////////////////
	
}

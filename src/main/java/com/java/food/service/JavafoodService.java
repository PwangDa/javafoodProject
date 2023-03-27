package com.java.food.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.food.dto.AlbumDTO;
import com.java.food.dto.CommentDTO;
import com.java.food.dto.FamousChartDTO;
import com.java.food.dto.GenreDTO;
import com.java.food.dto.PlayListDTO;
import com.java.food.dto.SongHit_DTO;
import com.java.food.dto.login_DTO;

@Service
public interface JavafoodService {
////////////////////////////////////////////////////////////
//다영
	List getArtist(String artist);
	List getComment(String artist);
	List getAlbum(String album);
	int insertComment(CommentDTO dto);
	int replyComment(CommentDTO dto);
	int delComment(int articleNO);
	int delAlbum(int album_num);
	List randomGenre(String genre);
	List randomArtist();
	int albumplus(AlbumDTO dto);
	int artistplus(AlbumDTO dto);
	List<AlbumDTO> listArtist();
	List<AlbumDTO> listAlbum();
	List<AlbumDTO> listIntoAlbum();
	List<CommentDTO> listComment();
	
	List searchArtist(String artist); //아티스트 검색조회
	List searchInto(String album);
	List searchAlbum(AlbumDTO dto);
	List searchID(login_DTO dto);
	
	int update_album(AlbumDTO dto);
	int update_artist(AlbumDTO dto);
////////////////////////////////////////////////////////////
//귀범
//	List<FamousChartDTO> getChart(String songnumber);
	
	// 차트 + 페이징
	Map chart(String country, int pageNum, int countPerPage);
	
	// 조회수 증가
	void addhit(String id, String songnumber);
	
	// 댄스 장르 출력 메소드
	List<FamousChartDTO> selectDance(String genre);
	
	// 비밀번호 찾기
	public List searchPW(login_DTO dto);
	
////////////////////////////////////////////////////////////
//범주
	//플레이 리스트 불러오기
	List<PlayListDTO> selectPlayList(String id);
	
	//플레이 리스트 표지 가져오기
	List<PlayListDTO> selectPlayListPoster(String id);
	
	//플레이 리스트 내역(Content) 불러오기
	List<PlayListDTO> selectPlayListContent(String pl_id);
	
	//플레이 리스트 수정하기
	void editPlayList(Map info);
	
	//플레이 리스트 추가하기
	void addPlayList(Map<String, String> info);

	//플레이 리스트 내역(Content) 삭제하기
	void deletePlayListContent(Map<String, String> info);
	
	//플레이 리스트 제거하기
	void deletePlayList(Map<String, String> info);
	
	//메인페이지 인기곡 불러오기
	List<GenreDTO> selectHitList();
	
	//플레이 리스트에 노래 추가하기
	void addContent(Map info);
	
	//플레이 리스트 내역의 선택된 곡 삭제하기
	void deleteCheckedSongs(Map info);
////////////////////////////////////////////////////////////
//경용
	//로그인
	Map<String, Object> login(Map<String, Object> map);
	//회원가입
	int addid(Map<String, Object> map);
	//아자스 중복체크
	int what (Map<String, Object> map);
	//회원탈퇴
	int outId(String id);
	//로그인 재생목록
	Map<String, Object> loginplay(String id,int i);
	//회원 정보 수정
	int idUpdate(Map<String, Object> map, String id);
	//좋아요 증가
	int good(String songnumb, String id);
	//조회수 증가
	int songhit(String song,String id);
	//검색
	List<GenreDTO> Search(Map<String, Object> map);
////////////////////////////////////////////////////////////
//용준
	// 장르
	Map getGenre(String song, int pageNum, int countPerPage);
	
	// 최신음악
	Map getMusic(int pageNum, int countPerPage);
	
	// 음악추가 페이지
	int insertsong(GenreDTO dto);
	
	//Genre관리자 페이지에서 목록 전체조회 출력
	List<GenreDTO> listGenre();
	
	// 음악추가 
	int update_song(GenreDTO dto);
	
	// 음악삭제 
	int delete_song(GenreDTO dto);
////////////////////////////////////////////////////////////
	
	
	
	
	
}

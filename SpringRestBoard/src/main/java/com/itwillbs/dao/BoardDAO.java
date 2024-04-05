package com.itwillbs.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {

	// 글쓰기 메서드
	public void boardAdd(BoardVO vo) throws Exception;
	
	// 글번호 존재여부 체크
	public int checkBoardBno(int bno) throws Exception; 
	
	// 특정 글정보 조회
	public BoardVO getBoard(int bno) throws Exception;
	
	// 마지막 글정보 조회
	public BoardVO getLastBoard() throws Exception;
	
	// 조건에 따른 글정보 조회
	public BoardVO getReadBoard(BoardVO vo) throws Exception;
	
	// 글 목록 조회(최신글 10개)
	public List<BoardVO> getBoardList() throws Exception;
	
	// 정보 수정 메서드
	public int updateBoard(BoardVO uvo) throws Exception;
	
	// 글 정보 삭제
	public int deleteBoard(int bno) throws Exception;
	
	
	
	
	
	
	
	
	
}

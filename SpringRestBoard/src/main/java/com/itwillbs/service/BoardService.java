package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {

	// 게시판 글쓰기
	public void boardAdd(BoardVO vo) throws Exception;
	
	// 게시판 글 존재여부 판단
	public int checkBoardBno(int bno) throws Exception;
	
	// 특정 게시글 정보 가져오기
	public BoardVO getBoard(int bno) throws Exception;
	
	// 마지막 글정보 조회
	public BoardVO getLastBoard() throws Exception;
	
	// 글정보 조회
	public BoardVO getBoardTotal(int bno) throws Exception;
	
	// 글 목록 조회(최신글 10개)
	public List<BoardVO> getBoardList() throws Exception;
	
	// 글 정보 수정
	public int updateBoard(BoardVO uvo) throws Exception;
	
	// 글 정보 삭제
	public int deleteBoard(int bno) throws Exception;
	
}

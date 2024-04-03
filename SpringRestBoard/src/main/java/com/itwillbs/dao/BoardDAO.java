package com.itwillbs.dao;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	// 글쓰기 메서드
	public void boardAdd(BoardVO vo) throws Exception;

}

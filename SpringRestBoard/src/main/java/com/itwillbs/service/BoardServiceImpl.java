package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	// DAO 처리객체 주입
	@Inject
	private BoardDAO bdao;
	

	@Override
	public void boardAdd(BoardVO vo) throws Exception {
		logger.info(" boardAdd(BoardVO vo) 호출 ");
		
		// DAO의 글쓰기 메서드를 호출
		bdao.boardAdd(vo);
			
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

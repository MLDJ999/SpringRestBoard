package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// mapper에 접근하기 위한 객체
	@Inject
	private SqlSession sqlSession;
	
	// mapper의 주소이름
	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";

	
	@Override
	public void boardAdd(BoardVO vo) throws Exception {
		logger.info(" boardAdd(BoardVO vo) 실행 ");
		
		sqlSession.insert(NAMESPACE + ".insertBoard" ,vo);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	// mapper에 접근을 하기위한 객체
	@Inject
	private SqlSession sqlSession;
	
	// mapper의 주소이름
	private static final String NAMESPACE="com.itwillbs.mapper.BoardMapper";
	
	
	@Override
	public void boardAdd(BoardVO vo) throws Exception {
		logger.info(" boardAdd(BoardVO vo)  실행 ");
		
		sqlSession.insert(NAMESPACE + ".insertBoard",vo);
		
	}


	@Override
	public int checkBoardBno(int bno) throws Exception {
		logger.info(" checkBoardBno(bno) 실행 ");
		
		return sqlSession.selectOne(NAMESPACE + ".checkBoardBno",bno);
	}


	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.info("getBoard(int bno) 실행");
		
		return sqlSession.selectOne(NAMESPACE + ".getBoard",bno);
	}


	@Override
	public BoardVO getLastBoard() throws Exception {
		logger.info(" getLastBoard() 실행 ");
		
		return sqlSession.selectOne(NAMESPACE + ".getLastBoard");
	}


	@Override
	public BoardVO getReadBoard(BoardVO vo) throws Exception {
		logger.info(" getReadBoard(BoardVO vo) 실행 ");
		return sqlSession.selectOne(NAMESPACE + ".getReadBoard",vo);
	}


	@Override
	public List<BoardVO> getBoardList() throws Exception {
		logger.info(" getBoardList() 실행 ");
		return sqlSession.selectList(NAMESPACE + ".boardList");
	}


	@Override
	public int updateBoard(BoardVO uvo) throws Exception {
		logger.info(" updateBoard(BoardVO) 실행");
		return sqlSession.update(NAMESPACE + ".updateBoard", uvo);
	}


	@Override
	public int deleteBoard(int bno) throws Exception {
		logger.info(" deleteBoard(int bno) 실행");
		return sqlSession.delete(NAMESPACE + ".deleteBoard", bno);
	}
	
	
	
	
	
	
}

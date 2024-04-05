package com.itwillbs.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DbConnectTest {

	private static final Logger logger = LoggerFactory.getLogger(DbConnectTest.class);
	
	// 디비연결 테스트 코드
	@Autowired
	private SqlSession sqlSession;
	
	// DB 처리 객체 주입
	@Inject
	private BoardDAO bDao;
	
	
	@Test
	public void 디비연결테스트() throws Exception{
		logger.info("  디비연결테스트()  실행 ");
		logger.info("sqlSession : "+sqlSession);
		//sqlSession.insert(statement);
	}
	
	@Test
	public void 글조회테스트() throws Exception {
		logger.info(" 글조회 테스트() ");
		BoardVO vo = new BoardVO();
		vo.setBno(1000);
		logger.info(" vo : " + bDao.getReadBoard(vo));
	}
	
	
	
	
	
	
	
	
}

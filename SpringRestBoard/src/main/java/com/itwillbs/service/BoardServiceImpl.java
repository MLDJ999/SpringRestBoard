package com.itwillbs.service;

import java.util.List;

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
	private BoardDAO bDao;
	
	@Override
	public void boardAdd(BoardVO vo) throws Exception {
		logger.info(" boardAdd(BoardVO vo) 호출 ");
		
		//logger.info(" bDao : "+bDao);
		// DAO의 글쓰기 메서드를 호출
		bDao.boardAdd(vo);
	}

	@Override
	public int checkBoardBno(int bno) throws Exception {
		logger.info(" checkBoardBno(int bno) 호출 ");
		
		return bDao.checkBoardBno(bno);
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.info(" getBoard(int bno) 호출 ");
		
		return bDao.getBoard(bno);
	}

	@Override
	public BoardVO getLastBoard() throws Exception {
		logger.info(" getLastBoard() 호출 ");
		return bDao.getLastBoard();
	}

	@Override
	public BoardVO getBoardTotal(int bno) throws Exception {
		logger.info(" getBoardTotal(int bno) 호출 ");
		
		// bno 정보를 사용해서  해당 정보가 존재하는지 아닌지 체크
		int result = checkBoardBno(bno);
		
		if(result == 1) {
			// 전달받은 bno에 해당하는 글정보가 있음
			return getBoard(bno);
		}else {
			// 전달받은 bno에 해당하는 글정보가 없음
			return getLastBoard();
		}		
		
	}

	
	
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		logger.info(" getBoardList() ");
		
		return bDao.getBoardList();
	}

	
	
	@Override
	public int updateBoard(BoardVO uvo) throws Exception {
		logger.info(" updateBoard(BoardVO uvo) 실행 ");
		
		return bDao.updateBoard(uvo);
	}

	
	
	@Override
	public int deleteBoard(int bno) throws Exception {
		logger.info(" deleteBoard(int bno) 실행 ");
		
		return bDao.deleteBoard(bno);
	}
	
	
	
	
	
	
	
}

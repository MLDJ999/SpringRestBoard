package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@RestController
@RequestMapping(value = "/boards")
public class BoardRestController {

	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);

	// 서비스 객체를 주입
	@Inject
	private BoardService bService;
	
	//	@RequestMapping(value = "/boards") 
	// @RequestMapping(value = "/boards",method = RequestMethod.GET)
	// @RequestMapping(value = "/boards",method = RequestMethod.POST)
	@PostMapping(value = "")
	public ResponseEntity<String> boardAdd(@RequestBody BoardVO vo) throws Exception {
		logger.info(" boardAdd()-POST 실행! ");
		logger.info(" vo : " + vo);

		try {
			// 전달받은 데이터를 저장
			//logger.info(" bService : "+bService);
			bService.boardAdd(vo);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest()
					.contentType(MediaType.valueOf("text/plain; charset=UTF-8"))
					.body("글 작성 실패!");
		}
		
		//return "글 작성 성공!";
		//return new ResponseEntity<String>("글 작성 성공!", HttpStatus.OK);
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf("text/plain; charset=UTF-8"))
				.body("글 작성 성공!");
		
	} //boardAdd
	
	// @RequestMapping(value = "/boards",method = RequestMethod.POST)
	@RequestMapping(value = "/{bno}",method = RequestMethod.GET)
	public ResponseEntity<BoardVO> boardRead(@PathVariable("bno") int bno) throws Exception {
		logger.info(" boardRead() 실행 ");
		
		logger.info(" bno : "+bno);
		
		/*
		 * // 특정 글번호가 존재하는지 체크 int result = bService.checkBoardBno(bno);
		 * logger.info(" result : "+result);
		 * 
		 * if(result==1) { // 전달받은 bno에 해당하는 글정보를 가져오기 BoardVO vo =
		 * bService.getBoard(bno); logger.info(" vo :"+vo); }else { // 만약에 해당 bno가 없는경우
		 * 가장 마지막 글정보를 가져오기 BoardVO vo = bService.getLastBoard();
		 * logger.info(" vo : "+vo); }
		 */
		BoardVO vo = bService.getBoardTotal(bno);
		logger.info(" vo : "+vo);
		
		if( vo != null) {
			return new ResponseEntity<BoardVO>(vo,HttpStatus.OK);		
		}else {
			return new ResponseEntity<BoardVO>(vo,HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> boardList() throws Exception{
		logger.info(" boardList() 호출 ");
		
		List<BoardVO> boardList = bService.getBoardList();
		
		//logger.info(" boardList : "+boardList);
		logger.info(" boardList : "+boardList.size());
		
		return new ResponseEntity<List<BoardVO>>(boardList,HttpStatus.OK);
		
	}
	
	
	// 정보 수정 메서드
	@RequestMapping(value = "/{bno}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateBoard(@PathVariable("bno") int bno,
											  @RequestBody BoardVO vo) throws Exception {
		logger.info(" updateBoard() 호출 ");
		logger.info(" vo : " + vo);
		vo.setBno(bno);
		logger.info(" vo : " + vo);
		
		int result = bService.updateBoard(vo);
		
		if (result == 1) {
			return new ResponseEntity<String>("update complete!" , HttpStatus.OK);
		}
		return new ResponseEntity<String> ("update fail!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// 정보 삭제 처리 메서드
	@RequestMapping(value = "/{bno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBoard(@PathVariable("bno") int bno) throws Exception{
		
		logger.info(" deleteBoard() 호출 ");
		
		int result = bService.deleteBoard(bno);
		
		if (result == 1) {
			return new ResponseEntity<String>("delete Complete" , HttpStatus.OK);
		}
		return new ResponseEntity<String> ("delete fail!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


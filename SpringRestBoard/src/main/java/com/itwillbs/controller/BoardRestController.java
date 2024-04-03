package com.itwillbs.controller;

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
	
	//http://localhost:8088/boardMain
	//@RequestMapping(value = "/boards", method = RequestMethod.POST)
	@PostMapping(value = "")
	public ResponseEntity<String> boardAdd(@RequestBody BoardVO vo) throws Exception {
		logger.info(" boardAdd() 실행! ");
		logger.info(" vo : " + vo);
		
		try {
			logger.info(" bService : " + bService);
			bService.boardAdd(vo);
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.contentType(MediaType.valueOf("text/plain; charset=UTF8"))
					.body("글 작성 실패!");
			
		}
		// return new ResponseEntity<String>("글 작성 성공!", HttpStatus.OK);
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf("text/plain; charset=UTF8"))
				.body("글 작성 성공!");
		
		// 전달받은 데이터를 저장
		
	}
	
	@RequestMapping(value = "/{bno}", method = RequestMethod.GET)
	public void boardRead(@PathVariable("bno") int bno) {
		logger.debug(" boardRead() 실행 ");
		logger.info(" bno : " + bno);
		// 특정 글 번호가 존재하는지 체크
		
		
		// 전달받은 bno에 해당하는 글정보를 가져오기
		// 만약에 해당 bno가 없는경우 가장 마지막 글 정보를 가져오기
		
		
		
	}
	
		
	
	
	
	
	
}

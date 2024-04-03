package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@RestController
public class BoardRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	
	// 서비스 객체를 주입
	@Inject
	private BoardService bService;
	
	//@RequestMapping(value = "/boards", method = RequestMethod.POST)
	@PostMapping(value = "/boards")
	public void boardAdd(@RequestBody BoardVO vo) throws Exception {
		logger.info(" boardAdd() 실행! ");
		logger.info(" vo : " + vo);
		
		// 전달받은 데이터를 저장
		logger.info(" bService : " + bService);
		bService.boardAdd(vo);
		
	}
	
	
	
	
}

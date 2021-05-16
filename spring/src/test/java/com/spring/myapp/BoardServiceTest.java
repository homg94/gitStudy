package com.spring.myapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.myapp.domain.BoardVO;
import com.spring.myapp.service.BoardService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {

	Logger log = LoggerFactory.getLogger(getClass()); 
	BoardService boardService;
	
	
	@BeforeEach
	public void setting() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		boardService = (BoardService)ctx.getBean("boardService");
		
	}
	
	@Test
	public void testExist() {
		log.info(boardService.toString());
		Assertions.assertNotNull(boardService);
		
	}
	
	@Test
	public void �����׽�Ʈ() {
		
		BoardVO board = boardService.get(13L);
		
		board.setTitle("�ù߽ù߽ù�");
		log.info("modify ����� :"+boardService.modify(board));
		Assertions.assertEquals(boardService.modify(board), true);
		
	}
	
	@Test
	public void ����׽�Ʈ() {
		
		BoardVO test = new BoardVO();
		test.setContent("test13");
		test.setTitle("test13");
		test.setWriter("tester13");
		boardService.register(test);
		Assertions.assertEquals(boardService.get(13L), test);
	}
	
	@Test
	public void �����׽�Ʈ() {
	
		Assertions.assertEquals(boardService.remove(2L), true);
	}
	
}

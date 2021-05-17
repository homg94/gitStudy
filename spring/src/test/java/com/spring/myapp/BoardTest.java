package com.spring.myapp;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.myapp.domain.BoardVO;
import com.spring.myapp.domain.Criteria;
import com.spring.myapp.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTest {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void test() {
		List<BoardVO> temp = mapper.getList();
		
		Assertions.assertNotNull(temp);
		
	}
	
	@Test
	public void testPaging() {
		
		
	}

}

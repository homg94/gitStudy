package com.spring.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.myapp.mapper.TimeMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleTest {


	@Autowired
	private TimeMapper timeMapper;
	
	private DataSource ds;
	
	@BeforeEach
	public void setting() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		System.out.println(ctx);
		
		 ds = (DataSource)ctx.getBean("dataSource");
		timeMapper = (TimeMapper)ctx.getBean("timeMapper");
		System.out.println(timeMapper);
	}
	
	
	@Test
	public void test() {
	
		Connection con = null;
		
	try {
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","book_ex","book_ex");
			Assertions.assertNotNull(con);

			
		}catch(Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}
	

}
	
	
	@Test
	public void testds() {
		Assertions.assertNotNull(ds);
	}

	@Test
	public void testHikari() {
		
		Assertions.assertNotNull(ds);

		Connection con=null;
		
		try {
			 con = ds.getConnection();
			System.out.println("성공");
			Assertions.assertNotNull(con);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(con);
	}
	
	
}

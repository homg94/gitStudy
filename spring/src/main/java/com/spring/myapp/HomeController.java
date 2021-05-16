package com.spring.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.myapp.domain.BoardVO;
import com.spring.myapp.mapper.BoardMapper;
import com.spring.myapp.mapper.TimeMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private TimeMapper timeMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		logger.info("Mapper={}",timeMapper.getClass());
		logger.info("Mapper={}",timeMapper.getTime());
		logger.info("Mapper={}",timeMapper.getTime2());
		logger.info("Mapper={}",boardMapper.getList());


	

		BoardVO vo = new BoardVO();
		vo.setContent("fuck");
		vo.setTitle("fuck");
		vo.setWriter("son of a bitch");
		boardMapper.insert(vo);
		
		boardMapper.getList().forEach(a->{
			System.out.println(a.toString());
		});
		
		
		//boardMapper.getList().forEach(a->{
			//System.out.println(a.toString());
		//});
		
		BoardVO vo3 = boardMapper.read(1L);
		
		System.out.println(vo3.toString());

		System.out.println(boardMapper.delete(1L));
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}

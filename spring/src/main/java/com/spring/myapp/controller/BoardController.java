package com.spring.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.domain.BoardVO;
import com.spring.myapp.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("list");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		service.register(board);
		System.out.println(service.get(board.getBno()));
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect : /board/list";
		
	}
	
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		System.out.println("get a list");
		model.addAttribute("board", service.get(bno));
		
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		System.out.println("modyfy"+ board.toString());
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			System.out.println("수정 성공");
		}
		
		return "redirect:/board/list";

	}
	
	

	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		System.out.println("remove :" + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("resu;t","success");
			System.out.println("성공");
		}
		
		return "redirect:/board/list";
	}
}

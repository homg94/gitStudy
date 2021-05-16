package com.spring.myapp.service;

import java.util.List;

import com.spring.myapp.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public List<BoardVO> getList();
	
	public boolean remove(Long bno);
	
}

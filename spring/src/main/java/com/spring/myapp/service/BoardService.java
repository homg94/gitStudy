package com.spring.myapp.service;

import java.util.List;

import com.spring.myapp.domain.BoardVO;
import com.spring.myapp.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public List<BoardVO> getList(Criteria cri);
	
	public boolean remove(Long bno);
	
	
	
	
	
}

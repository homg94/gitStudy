package com.spring.myapp.mapper;

import java.util.List;

import com.spring.myapp.domain.BoardVO;
import com.spring.myapp.domain.Criteria;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public int delete(Long bno);
	
	public BoardVO read(Long bno);
	
	public int update(BoardVO board);
	
	public List<BoardVO> getListWithPage(Criteria cri);
}

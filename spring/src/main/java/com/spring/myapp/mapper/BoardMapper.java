package com.spring.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spring.myapp.domain.BoardVO;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public int delete(Long bno);
	
	public BoardVO read(Long bno);
	
	public int update(BoardVO board);
}

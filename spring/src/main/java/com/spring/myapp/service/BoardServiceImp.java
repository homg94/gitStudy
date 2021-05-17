package com.spring.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myapp.domain.BoardVO;
import com.spring.myapp.domain.Criteria;
import com.spring.myapp.mapper.BoardMapper;

@Service(value = "boardService")
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	
	public void register(BoardVO board) {
	
		mapper.insertSelectKey(board);
	}


	//public BoardVO get(Long bno) {
		//return mapper.read(bno);
	//}
	
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}


	public boolean modify(BoardVO board) {
		return (mapper.update(board)==1);
	}


	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPage(cri);
	}


	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno)==1;
	}




}

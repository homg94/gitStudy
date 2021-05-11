package com.example.boot;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.boot.domain.Board;
import com.example.boot.persistence.BoardRepository;

@SpringBootTest
public class RepositoryTest {

	@Autowired
	private BoardRepository board;
	
	@Test
	public void »Æ¿Œ() {
		Board test = new Board();
		test.setTitle("hi");
		test.setContent("what the fuck!");
		test.setWriter("Lookhkh");
		board.save(test);
		
		Optional<Board> findid=board.findById(test.getBno());
		
		Assertions.assertThat(test.getWriter()).isEqualTo(findid.get().getWriter());
	}
	
	
}

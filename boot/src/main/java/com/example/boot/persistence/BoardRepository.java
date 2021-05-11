package com.example.boot.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.boot.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}

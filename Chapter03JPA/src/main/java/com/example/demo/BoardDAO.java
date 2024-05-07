package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO extends JpaRepository<BoardDTO, Integer>{

	public List<BoardDTO> findAllByOrderBySeqDesc(); //Entity, primary key 자료형

}
	
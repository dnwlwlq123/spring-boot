package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	@Override
	public void write() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId("gdgdgdgdg");
		boardDTO.setName("김태진");
		boardDTO.setSubject("김태진전");
		boardDTO.setContent("불쌍한 사람들을 도우는 의적!!");

		//DB
		boardDAO.save(boardDTO); //insert or update
	}
	@Override
	public List<BoardDTO> list() {
		
		//return boardDAO.findAll();
		return boardDAO.findAllByOrderBySeqDesc();
	}

}

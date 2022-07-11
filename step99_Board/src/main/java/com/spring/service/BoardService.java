package com.spring.service;

import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Board;

public interface BoardService {
	
	public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO);

	public Board getBoardByBoardNo(Long boardNo);
	
	public void insertBoard(BoardDTO boardDTO);
	
	public void updateBoard(BoardDTO boardDTO);
	
	public void deleteBoardByBoardNo(Long boardNo);
}

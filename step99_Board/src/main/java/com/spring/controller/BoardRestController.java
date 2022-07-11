package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Board;
import com.spring.service.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardRestController {
	
	private final BoardServiceImpl boardService;
	
	@GetMapping(value = "/board/boardlist")
	public PageResultDTO<BoardDTO, Board> getBoardList(PageRequestDTO pageRequestDTO){
		PageResultDTO<BoardDTO, Board> pageResultDTO = boardService.getList(pageRequestDTO);
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		pageResultDTO.getDtoList().forEach(boardDTO -> boardList.add(boardDTO));
		
		return pageResultDTO;
	}
	
	@GetMapping(value = "/board/{boardNo}")
	public Board getBoardByBoardNo(@PathVariable Long boardNo) {
		return boardService.getBoardByBoardNo(boardNo);
	}
	
	
	@PostMapping(value = "/board", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBoard(@RequestBody BoardDTO boardDTO) {
		boardService.insertBoard(boardDTO);
	}
	
	@PutMapping(value="/board", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBoardByBoardNo(@RequestBody BoardDTO boardDTO) {
		boardService.updateBoard(boardDTO);
	}
	
	@DeleteMapping(value = "/board/{boardNo}")
	public void deleteBoardByBoardNo(@PathVariable Long boardNo) {
		Board board = new Board();
		board = getBoardByBoardNo(boardNo);
		if (board == null) {
			System.out.println("입력하신 게시글이 존재하지 않습니다.");
		}else {
			boardService.deleteBoardByBoardNo(boardNo);
		}
	}
}

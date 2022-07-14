package com.spring.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
public class BoardRestController {
	
	private final BoardServiceImpl boardService;
	
	@GetMapping(value = "/board/boardlist")
	public PageResultDTO<BoardDTO, Board> getBoardList(PageRequestDTO pageRequestDTO){
		PageResultDTO<BoardDTO, Board> pageResultDTO = boardService.getList(pageRequestDTO);

		return pageResultDTO;
	}
	
	@GetMapping(value = "/board/{boardNo}")
	public Board getBoardByBoardNo(@PathVariable Long boardNo) throws Exception {
		try {
	         if(boardService.getBoardByBoardNo(boardNo) ==null) {
	            throw new Exception("게시글 번호가 없어요");
	         }else {
	            return boardService.getBoardByBoardNo(boardNo); 
	            
	         }         
	      }catch (Exception e) {
	         throw new Exception("게시글 번호가 없어요"); 
	      }
	}
	
	@PostMapping(value = "/board", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBoard(@RequestBody BoardDTO boardDTO) {
		boardService.insertBoard(boardDTO);
	}
	
	@PutMapping(value="/board", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBoard(@RequestBody BoardDTO boardDTO) {
		boardService.updateBoard(boardDTO);
	}
	
	@DeleteMapping(value = "/board/{boardNo}")
	public void deleteBoardByBoardNo(@PathVariable Long boardNo) {
		Board board = new Board();
		try {
			board = getBoardByBoardNo(boardNo);
		} catch (Exception e) {
			new Exception(e.getMessage());
		}
		if (board == null) {
			System.out.println("입력하신 게시글이 존재하지 않습니다.");
		}else {
			boardService.deleteBoardByBoardNo(boardNo);
		}
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleExcpetion(Exception e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}

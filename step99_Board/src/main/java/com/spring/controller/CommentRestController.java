package com.spring.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.CommentDTO;
import com.spring.entity.Comment;
import com.spring.service.CommentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
public class CommentRestController {

	private final CommentServiceImpl commentService;
	

	@GetMapping(value = "/comment/comments")
	public List<Comment> getComments(){
		return commentService.getCommentAll();
	}

	@GetMapping(value = "/comment/comments/{boardNo}")
	public List<Comment> getCommentsByBoardNo(@PathVariable Long boardNo){
		
		return commentService.getCommentsByBoardNo(boardNo);
	}
	
	@GetMapping(value = "/comment/{commentNo}")
	public Comment getCommentByCommentNo(@PathVariable Long commentNo) {
		return commentService.getCommentByCommentNo(commentNo);
	}
	
	
	@PostMapping(value = "/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertComment(@RequestBody CommentDTO commentDTO) {
		commentService.insertComment(commentDTO);
	}
	
	@PutMapping(value="/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateCommentByCommentNo(@RequestBody CommentDTO commentDTO) {
		commentService.updateComment(commentDTO);
	}
	
	@DeleteMapping(value = "/comment/{commentNo}")
	public void deleteCommentByCommentNo(@PathVariable Long commentNo) {
		Comment comment = new Comment();
		comment = getCommentByCommentNo(commentNo);
		if (comment == null) {
			System.out.println("입력하신 게시글이 존재하지 않습니다.");
		}else {
			commentService.deleteCommentByCommentNo(commentNo);
		}
	}
}

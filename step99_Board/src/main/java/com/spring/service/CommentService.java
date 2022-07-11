package com.spring.service;

import java.util.List;

import com.spring.dto.CommentDTO;
import com.spring.entity.Comment;

public interface CommentService {

	public List<Comment> getCommentAll();
	
	public List<Comment> getCommentsByBoardNo(Long boardNo);
	
	public Comment getCommentByCommentNo(Long commentNo);
	
	public void insertComment(CommentDTO commentDTO);
	
	public void updateComment(CommentDTO commentDTO);
	
	public void deleteCommentByCommentNo(Long commentNo);
}

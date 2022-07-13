package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.dto.CommentDTO;
import com.spring.entity.Board;
import com.spring.entity.Comment;
import com.spring.repository.BoardRepository;
import com.spring.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	private final CommentRepository commentRepo;
	
	private final BoardRepository boardRepo;
	
	@Transactional
	@Override
	public List<Comment> getCommentAll(){
		return commentRepo.findAll();
	};
	
	@Transactional
	@Override
	public List<Comment> getCommentsByBoardNo(Long boardNo){
		Board board = boardRepo.findBoardByBoardNo(boardNo);
		
		return commentRepo.findCommentByBoard(board);
	};
	
	
	@Transactional
	@Override
	public Comment getCommentByCommentNo(Long commentNo) {
		return commentRepo.findCommentByCommentNo(commentNo);
	};
	
	@Transactional
	@Override
	public void insertComment(CommentDTO commentDTO) {
		Comment commentEntity = commentDTO.toEntity(commentDTO);
		
		commentRepo.save(commentEntity);
	};
	
	@Transactional
	@Override
	public void updateComment(CommentDTO commentDTO) {
		Comment comment = getCommentByCommentNo(commentDTO.getCommentNo());
		comment.updateCommentContent(commentDTO);
		
		commentRepo.save(comment);
		
	};
	
	@Transactional
	@Override
	public void deleteCommentByCommentNo(Long commentNo) {
		commentRepo.deleteCommentByCommentNo(commentNo);
	};
	
}

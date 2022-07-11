package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Board;
import com.spring.entity.User;

@Repository
public interface BoardRepository  extends JpaRepository<Board, Long>  {
	
	public Board findBoardByBoardNo(Long boardNo);
	
	public void deleteBoardByBoardNo(Long boardNo);
	
}

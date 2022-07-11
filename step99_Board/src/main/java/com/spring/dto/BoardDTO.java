package com.spring.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.spring.entity.Board;
import com.spring.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {

	@Id
	@Column(name = "board_no")
	private Long boardNo;
	
	@Column(name = "board_title")
	private String boardTitle;
	
	@Column(name = "board_content")
	private String boardContent;
	
	@CreatedDate
	@Column(name="registered_date")
	private LocalDate registeredDate;

	@LastModifiedDate
	@Column(name="modified_date")
	private LocalDate modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="user_email")
	private User user;
	
	public Board toEntity(BoardDTO boardDTO) {
		Board boardEntity = Board.builder()
				.boardNo(boardDTO.getBoardNo())
				.boardTitle(boardDTO.getBoardTitle())
				.boardContent(boardDTO.getBoardContent())
				.user(boardDTO.getUser())
				.build();

		return boardEntity;
	}
	
}

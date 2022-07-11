package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.BoardDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "board")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Board implements Persistable<Long> {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_no")
	private Long boardNo;
	
	@Column(name = "board_title", length = 255)
	private String boardTitle;
	
	@Column(name = "board_content", length = 255)
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
	
	@Override
	public Long getId() {
		return boardNo;
	}
	
	@Override	// 영속성이 있는지 판단하는 메소드
	public boolean isNew() {
		return registeredDate == null;
	}
	
	public BoardDTO toDTO(Board boardEntity) {
		BoardDTO boardDTO = BoardDTO.builder()
				.boardNo(boardEntity.getBoardNo())
				.boardTitle(boardEntity.getBoardTitle())
				.boardContent(boardEntity.getBoardContent())
				.registeredDate(boardEntity.getRegisteredDate())
				.modifiedDate(boardEntity.getModifiedDate())
				.user(boardEntity.getUser())
				.build();

		return boardDTO;
	}
	
}

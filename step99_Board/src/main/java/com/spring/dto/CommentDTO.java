package com.spring.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.entity.Board;
import com.spring.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
	
	@Id
	@Column(name = "comment_no")
	private Long commentNO;
	
	@Column(length = 255)
	private String commenter;
	
	@Column(name = "comment_content", length = 255)
	private String commentContent;
	
	@CreatedDate
	@Column(name="registered_date")
	private LocalDate registeredDate;

	@LastModifiedDate
	@Column(name="modified_date")
	private LocalDate modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="board_no")
	private Board board;
	
	public Comment toEntity(CommentDTO commentDTO) {
		Comment commentEntity = Comment.builder()
					.commentNO(commentDTO.getCommentNO())
					.commenter(commentDTO.getCommenter())
					.commentContent(commentDTO.getCommentContent())
					.board(commentDTO.getBoard())
					.build();
		
		return commentEntity;
	}
	
}

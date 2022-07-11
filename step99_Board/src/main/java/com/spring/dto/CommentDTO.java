package com.spring.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.spring.entity.Board;
import com.spring.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
	
	@Id
	@Column(name = "comment_no")
	private Long commentNo;
	
	@Column(length = 255)
	private String commenter;
	
	@Column(name = "comment_content", length = 255)
	private String commentContent;
	
	@Column(name="registerd_date")
	private LocalDateTime registeredDate;

	@Column(name="modified_date")
	private LocalDateTime modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="board_no")
	private Board board;
	
	public Comment toEntity(CommentDTO commentDTO) {
		Comment commentEntity = Comment.builder()
					.commentNo(commentDTO.getCommentNo())
					.commenter(commentDTO.getCommenter())
					.commentContent(commentDTO.getCommentContent())
					.board(commentDTO.getBoard())
					.build();
		
		return commentEntity;
	}
	
}

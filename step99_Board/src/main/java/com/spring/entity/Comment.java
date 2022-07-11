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

import com.spring.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "comment")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Comment implements Persistable<Long>{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Override
	public Long getId() {
		return commentNO;
	}
	
	@Override	// 영속성이 있는지 판단하는 메소드
	public boolean isNew() {
		return registeredDate == null;
	}
	
	public CommentDTO toDTO(Comment commentEntity) {
		CommentDTO commentDTO = CommentDTO.builder()
					.commentNO(commentEntity.getCommentNO())
					.commenter(commentEntity.getCommenter())
					.commentContent(commentEntity.getCommentContent())
					.registeredDate(commentEntity.getRegisteredDate())
					.modifiedDate(commentEntity.getModifiedDate())
					.board(commentEntity.getBoard())
					.build();
		
		return commentDTO;
	}
	
}

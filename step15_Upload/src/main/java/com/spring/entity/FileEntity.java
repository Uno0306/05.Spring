package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file")
@EntityListeners(AuditingEntityListener.class)
public class FileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String originalFileName;
	
	private String filename;
	
	private String filePath;
	
	@LastModifiedDate
	private LocalDateTime modifieDateTime;
	
	public FileDTO toDTO(FileEntity fileEntity) {
		FileDTO fileDTO = FileDTO.builder()
								.id(fileEntity.getId())
								.filename(fileEntity.getFilename())
								.originalFileName(fileEntity.getOriginalFileName())
								.filePath(fileEntity.getFilePath())
								.build();
		return fileDTO;
	}
	
	
	
	
	
	
	
	
	
	
}

package com.spring.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String originalFileName;
	
	private String filename;
	
	private String filePath;
	
	public FileEntity toEntity(FileDTO fileDTO) {
		FileEntity fileEntity = FileEntity.builder()
								.filename(fileDTO.getFilename())
								.originalFileName(fileDTO.getOriginalFileName())
								.filePath(fileDTO.getFilePath())
								.build();
		return fileEntity;
	}
	
	
	
	
	
	
	
	
	
}

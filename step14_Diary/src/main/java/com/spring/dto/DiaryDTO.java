package com.spring.dto;


import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Id;

import com.spring.entity.Diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiaryDTO {
	
	@Id
	private Long no;
	
	private String title;
	
	private String content;
	
	private LocalDateTime writtenTime;
	
	public Diary toEntity(DiaryDTO diaryDTO) {
		Diary diaryEntity = Diary.builder()
							.no(diaryDTO.getNo())
							.title(diaryDTO.getTitle())
							.content(diaryDTO.getContent())
							.build();
		
		return diaryEntity;
	}
	
	public Optional<String> updateTitle(String title){
		return Optional.ofNullable(title);
	}
	
}

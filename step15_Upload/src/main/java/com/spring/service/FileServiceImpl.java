package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.entity.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{
	
	private final FileRepository fileRepo;
	
	@Override
	public Long saveFile(FileDTO fileDTO) {
		FileEntity fileEntity = fileDTO.toEntity(fileDTO);
		return fileRepo.save(fileEntity).getId();
	};
	
	@Override
	public List<FileEntity> getFileAll(){
		
		return fileRepo.findAll();
	};
	
}

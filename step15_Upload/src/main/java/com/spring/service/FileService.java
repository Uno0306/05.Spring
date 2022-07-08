package com.spring.service;

import java.util.List;

import com.spring.entity.FileDTO;
import com.spring.entity.FileEntity;

public interface FileService {
	
	public Long saveFile(FileDTO fileDTO);
	
	public List<FileEntity> getFileAll();
}

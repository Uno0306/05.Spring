package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.view.RedirectView;

import com.spring.entity.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;
import com.spring.service.FileServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000"})
public class FileController {

	private final FileServiceImpl fileService;
	private final FileRepository fileRepository;

	// 내 코드
//	@GetMapping("/files")
//	public List<FileDTO> getFiles(){
//		List<FileEntity> entityList = fileService.getFileAll();
//		List<FileDTO> dtoList = new ArrayList<FileDTO>();
//		entityList.forEach(fileEntity -> dtoList.add(fileEntity.toDTO(fileEntity)));
//		
//		return dtoList;
//	}
	
	// 강사님 코드
	@GetMapping("/file-list") 
	public List<FileEntity> showFileList() {
	  return fileRepository.findAll();
	}
	
//	@GetMapping("/file-download/{id}")
//	public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws FileNotFoundException{
//		FileEntity file = fileRepository.findById(id).get();
//		
//		FileInputStream fis = new FileInputStream(file.getFilePath());
//		try {
//			OutputStream os = response.getOutputStream();
//			int readCount = 0;
//			byte[] buffer = new byte[1024];
//			while((readCount = fis.read(buffer)) != -1) {
//				os.write(buffer, 0, readCount);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@GetMapping("/file-download/{id}")
	public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws FileNotFoundException{
		FileEntity file = fileRepository.findById(id).get();
		response.setHeader("Content-Disposition", "attachment;filename=\""+file.getFilename()+"\";");
		FileInputStream fis = new FileInputStream(file.getFilePath());
		try {
			OutputStream os = response.getOutputStream();
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while((readCount = fis.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/file-save-test")
	public void testFileSave(@RequestParam("file") MultipartFile multiFile) {
		try {
			String originalFileName = multiFile.getOriginalFilename();
			String filename = UUID.randomUUID().toString() + "_" + originalFileName;

			// 파일 저장시 경로 설정
			String filePath = System.getProperty("user.dir") + "\\files";

			// 저장폴더가 존재하지 않을 경우 -> 반드시 생성을 해줘야 함
			if(!new File(filePath).exists()) {
				new File(filePath).mkdir();
			}

			// 저장폴더가 존재하는 경우 -> 파일을 저장해줘야 함
			String finalFilePath = filePath + "\\" + filename;
			multiFile.transferTo(new File(finalFilePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/file-save")
	public ResponseEntity saveFile(@RequestParam("file") MultipartFile multiFile) {
		// 내 코드
//		public RedirectView saveFile(@RequestParam("file") MultipartFile multiFile) {
		try {
			String originalFileName = multiFile.getOriginalFilename();
			String filename = UUID.randomUUID().toString() + "_" + originalFileName;

			// 파일 저장시 경로 설정
			String filePath = System.getProperty("user.dir") + "\\files";

			// 저장폴더가 존재하지 않을 경우 -> 반드시 생성을 해줘야 함
			if(!new File(filePath).exists()) {
				new File(filePath).mkdir();
			}

			// 저장폴더가 존재하는 경우 -> 파일을 저장해줘야 함
			String finalFilePath = filePath + "\\" + filename;
			multiFile.transferTo(new File(finalFilePath));

			FileDTO fileDTO = FileDTO.builder()
					.originalFileName(originalFileName)
					.filename(filename)
					.filePath(finalFilePath)
					.build();

			Long fileID = fileService.saveFile(fileDTO);

			/*
			 * boardDTO, setFileDTO(fileDTO);
			 * boardDTO, setFileId(fileId);
			 * boardServiceImple.saveBoard(boardDTO);
			 * 
			 */
//			return 30L;
			
			// 내 코드
//			 RedirectView redirectView = new RedirectView();
//		       redirectView.setUrl("http://localhost:3000");
//		       return redirectView;
			
			// 강사님 코드
			return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://www.naver.com")).body(fileID);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

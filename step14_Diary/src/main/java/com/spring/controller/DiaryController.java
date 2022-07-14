package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;
import com.spring.service.DiaryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor	// finall이 붙거나 @NotNull이 붙은 필드(맴버변수)의 생성자를 자동 생성하는 어노테이션. diaryControlle가 생성이 될 때, 내부에 있는 필드가 생성이 된다.
public class DiaryController {

	//	@Autowired	// 의존성 주입 - 필드 주입
	private final DiaryServiceImpl diaryServiceImpl;	// 안전성있는 주입 방법

	@Autowired
	DiaryRepository diaryRepo;

	@PostMapping(value = "/diary", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDiary(@RequestBody DiaryDTO diaryDTO) {
//		diaryEntity.updateTitle(diaryDTO.getTitle());
		Diary diaryEntity= diaryRepo.findById(diaryDTO.getNo()).orElseThrow(() -> new IllegalArgumentException());
		
		diaryDTO.updateTitle(diaryDTO.getTitle()).ifPresent(diaryEntity::updateTitle);;
		
		
		diaryServiceImpl.insertDiary(diaryDTO);
	}

	@PostMapping("/diary-batch")
	public void insertDiaryBatch() {
		List<DiaryDTO> diaryDTOList = new ArrayList<DiaryDTO>();
		IntStream.rangeClosed(1, 200).forEach(i -> {
			diaryDTOList.add(DiaryDTO.builder()
					.no(Long.valueOf(i))
					.title("Title : " + i)
					.content("Content : " + i)
					.build());
		});

		diaryServiceImpl.insertDiaryBatch(diaryDTOList);
	}

	// Page processing
	// Pageable Interface -> 구현체 PageReqeust
	// Pageable pagealbe = new PageRequest();  X 객체 생성 안됨

	// 내부 static of 메소드를 사용가능
	// of(int page, int size) : (페이지 번호(0부터 시작), 보여줄 개수) 
	// of(int page, int size, Sort sort) : (페이지 번호(0부터 시작), 보여줄 개수, 정렬) 

	@GetMapping("/pageable")
	public void pageDefault() {
		//		System.out.println("START===Pageable Result=====");
		//		Pageable pageable1 = PageRequest.of(10, 10);
		//		Page<Diary> result = diaryRepo.findAll(pageable1);
		//		System.out.println("----------------------------");
		//		System.out.println(result);
		//		System.out.println("----------------------------");
		//		System.out.println("----------총 페이지 수----------");
		//		System.out.println(result.getTotalPages());
		//		System.out.println("-----------전체 개수-----------");
		//		System.out.println(result.getTotalElements());
		//		System.out.println("----현재 페이지 번호(0부터 시작)-----");
		//		System.out.println(result.getNumber());
		//		System.out.println("--------페이지당 데이터 개수-------");
		//		System.out.println(result.getSize());
		//		System.out.println("-------다음 페이지 있는가?---------");
		//		System.out.println(result.hasNext());
		//		System.out.println("-------이전 페이지 있는가?---------");
		//		System.out.println(result.hasPrevious());
		//		System.out.println("END===Pageable Result=======");
		//		System.out.println("START=====모든 데이터===========");
		//		System.out.println(result.getContent());
		//		System.out.println("END=======모든 데이터===========");

		// 정렬
		//		System.out.println("START===정=======렬=========");
		//		Sort sort1 = Sort.by("no").descending();
		//		Pageable pageable2 = PageRequest.of(0, 10, sort1);
		//		Page<Diary> result2 = diaryRepo.findAll(pageable2);
		//		
		//		result2.forEach(diary -> {
		//			System.out.println(diary);
		//		});
		//		System.out.println("END=====정=======렬=========");

		//		System.out.println("START====쿼리 메소드 + Pageable=======");
		//		// 쿼리 메소드 + Pageable
		//		Pageable pageable3 = PageRequest.of(0, 10, Sort.by("no").descending());
		//		Page<Diary> result3 = diaryRepo.findByNoBetween(10L, 50L, pageable3);
		//		
		//		result3.get().forEach(diary -> System.out.println(diary));
		//		System.out.println("END======쿼리 메소드 + Pageable=======");


		// 고려 사항
		// Entity -> DTO
		// DTO -> Pageable
		// 페이지 번호

		System.out.println("START====PageRequestDTO====");
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.build();

		PageResultDTO<DiaryDTO, Diary> pageResultDTO = diaryServiceImpl.getList(pageRequestDTO);
		//				System.out.println(pageResultDTO.isPrev());
		//				System.out.println(pageResultDTO.isNext());
		//				System.out.println(pageResultDTO.getTotalPage());

		System.out.println("=====PageRequestDTO 객체값 출력(page번 페이지에 있는 내용만)=====");
		// ??
		pageResultDTO.getDtoList().forEach(diaryDto -> System.out.println(diaryDto));

		System.out.println("END=====PageRequestDTO=====");
	}

	@GetMapping("/diary")
	public void getDiary(PageRequestDTO pageRequestDTO) throws Exception {
//		PageResultDTO<DiaryDTO, Diary> pageResultDTO = diaryServiceImpl.getList(pageRequestDTO);
//
//		pageResultDTO.getDtoList().forEach(diaryDto -> System.out.println(diaryDto));
		
		throw new Exception("예외 테스트");
	}

//	@ExceptionHandler
//	public ResponseEntity<String> handleExcpetion(Exception e){
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//	}
//	
//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<String> handleExcpetion2(NoSuchElementException e){
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//	}
	
}
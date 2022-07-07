package com.spring.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResultDTO<DTO, EN> {

	// DTO 리스트
	private List<DTO> dtoList;
	
	// 전체 페이지 번호
	private int totalPage;
	
	// 현재 페이지 번호
	private int page;
	
	// 목록(DTO) Size
	private int size;
	
	// 시작 페이지 번호, 마지막 페이지 번호
	private int start, end;
	
	// 이전 버튼, 다음 버튼
	private boolean prev, next;
	
	// 목록(페이지 번호) Size
	private List<Integer> pageList;
	
	// 전체 객체 지정 생성자
	public PageResultDTO(Page<EN> result, Function<EN, DTO> function){
		dtoList = result.stream().map(function).collect(Collectors.toList());
		
		totalPage = result.getTotalPages();
		buildPageList(result.getPageable());
	}
	
	// 페이지의 전체 리스트 구하는 method
	private void buildPageList(Pageable pageable) {
		this.page = pageable.getPageNumber() +1;	// JPA에서 현재 페이지는 0부터 시작함 --> +1 해줘야 실제 페이지
		this.size = pageable.getPageSize();
		
		// 끝번호를 구할 때(페이지 번호가 10개)
		int endPage = (int)(Math.ceil(page/10.0)) *10;	// ceil : 무조건 올림
		// 첫번째 page = 1 -> 10
		// 페이지 = 11 -> 
		
		start = endPage - 9;	// 10개씩이라 9를 빼주면 첫페이지

		prev = start > 1;
		
		end = totalPage > endPage? endPage: totalPage;
		
		next = totalPage > endPage;
		
		pageList = IntStream.range(start, end).boxed().collect(Collectors.toList());
		
	}
}

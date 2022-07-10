package com.example.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//import static org.junit.Assert.*;
//import org.junit.test;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Dept;
import com.example.service.DeptServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
public class DeptRestController {

//	@Autowired
	private final DeptServiceImpl deptService;

	@GetMapping(value="/dept/depts")
	public List<Dept> getDepts(){
		return deptService.getDeptAll();
	}
	
	@GetMapping(value="/dept/deptspaging")
	public PageResultDTO<DeptDTO, Dept> getDiary(PageRequestDTO pageRequestDTO) {
		PageResultDTO<DeptDTO, Dept> pageResultDTO = deptService.getList(pageRequestDTO);
		List<DeptDTO> deptList = new ArrayList<DeptDTO>();
		// ??
		pageResultDTO.getDtoList().forEach(deptDto -> deptList.add(deptDto));
		return pageResultDTO;
	}
	
	@GetMapping(value = "/dept/{deptno}")
	public Dept getDeptByDeptno(@PathVariable Long deptno) {
		Dept dept = deptService.getDeptByDeptno(deptno);
		if(dept != null) {
			return deptService.getDeptByDeptno(deptno);
		}else {
			return null;
		}
	}

	@PostMapping(value = "/dept/{deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDept(@PathVariable Long deptno, @RequestBody DeptDTO param) {
		Dept deptCheck = new Dept();
		deptCheck = getDeptByDeptno(deptno);
		if(deptCheck == null) {
			System.out.println("0------------------------0");
			DeptDTO deptDTO = new DeptDTO(deptno, param.getDname(), param.getLoc());
			deptService.insertDept(deptDTO);
		}else {
			System.out.println("부서번호가 존재합니다.");
		}
	
	}
	
	@PutMapping(value = "/dept/{deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDeptByDeptno(@PathVariable Long deptno, @RequestBody DeptDTO param) {
		if(deptno == null ) {
			System.out.println("부서번호를 입력해주세요.");
		}else {
			Dept checkDept = getDeptByDeptno(deptno);
			if(checkDept == null) {
				System.out.println("부서번호가 존재하지 않습니다.");
			}else {
				DeptDTO originDept = checkDept.toDTO(checkDept);
				DeptDTO aldept = DeptDTO.deptCheck(originDept, param);
				Dept dept = aldept.toEntity(aldept);
				deptService.updateDept(dept);
			}
		}
	}

	@DeleteMapping(value="/dept/{deptno}")
	@Transactional
	public void deleteByDeptno(@PathVariable Long deptno) {
		Dept dept = new Dept();
		dept = getDeptByDeptno(deptno);
		if(dept == null) {
			System.out.println("부서번호가 존재하지 않습니다.");
		}else {
			deptService.deleteDeptByDeptno(deptno);
		}
	}
}

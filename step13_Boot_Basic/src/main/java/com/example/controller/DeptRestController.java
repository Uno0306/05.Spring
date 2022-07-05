package com.example.controller;


import java.util.List;

//import static org.junit.Assert.*;
//import org.junit.test;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dept;
import com.example.service.DeptServiceImpl;

@RestController
public class DeptRestController {

	@Autowired
	DeptServiceImpl deptService;

	@GetMapping(value="/depts")
	public List<Dept> getDepts(){
		return deptService.getDeptAll();
	}

	@GetMapping(value = "/dept/{deptno}")
	public Dept getDeptByDeptno(@PathVariable Long deptno) {
		return deptService.getDeptByDeptno(deptno);
	}

	@PostMapping(value = "/dept", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDept(@RequestBody Dept param) {
		Dept deptCheck = new Dept();
		deptCheck = getDeptByDeptno(param.getDeptno());
		if(deptCheck == null) {
			Dept dept = new Dept(param.getDeptno(), param.getDname(), param.getLoc());
			deptService.insertDept(dept);
		}else {
			System.out.println("부서번호가 존재랍니다.");
		}
	}
	
	@PutMapping(value = "/dept/{deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDeptByDeptno(@PathVariable Long deptno, @RequestBody Dept param) {
		if(deptno == null ) {
			System.out.println("부서번호가 존재하지 않습니다.");
		}else {
			System.out.println("check");
			Dept dept =  new Dept(deptno, "감자", param.getLoc());
			
			deptService.updateDept(dept);
		}
	}

//	@DeleteMapping(value="/dept/{deptno}")
//	@Transactional
//	public void deleteByDeptno(@PathVariable Long deptno) {
//		Dept dept = new Dept();
//		dept = getDeptByDeptno(deptno);
//		if(dept == null) {
//			System.out.println("부서번호가 존재하지 않습니다.");
//		}else {
//			deptService.deleteDeptByDeptno(deptno);
//		}
//	}
}

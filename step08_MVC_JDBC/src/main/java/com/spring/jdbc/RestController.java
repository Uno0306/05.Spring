package com.spring.jdbc;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private DeptServiceImpl deptService;
	
	@GetMapping(value = "/api/test")
	public String apiTest() {
		return "test2";
	}
	
	@PostMapping(value="/api/dept")
	public void insertDept(Dept dept) {
//		System.out.println("--------------" + dept);
		deptService.insertDept(dept);
	}
	
	// @ResponseBody는 @RestController에 붙어 있다. -> 그래서 안 써도 됨
	@GetMapping(value="/api/depts")
	public List<Dept> getAllDepts(){
		return deptService.getAllDepts();
	};

	@PostMapping(value="/api/deptjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptJSON(@RequestBody Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
	}

	@PostMapping(value="/api/deptform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void insertDeptFORM(Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
	}
	
	
}

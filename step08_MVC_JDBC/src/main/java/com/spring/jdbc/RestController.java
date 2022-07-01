package com.spring.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
	@GetMapping(value="/api/depts")
	public List<Dept> getAllDepts(){
		return deptService.getAllDepts();
	};

	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
	@PostMapping(value="/api/deptjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptJSON(@RequestBody Dept dept) {
//		System.out.println(dept);
		deptService.insertDept(dept);
	}

	@PostMapping(value="/api/deptform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void insertDeptFORM(Dept dept) {
//		System.out.println(dept);
		deptService.insertDept(dept);
	}
	
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
	@PutMapping(value="/api/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDeptByDeptno(@RequestBody Dept data) {
//		System.out.println(data);
		deptService.updateDeptByDeptno(data);
	}
	
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
	@DeleteMapping(value="/api/delete")
	public void delteDeptByDeptno(@RequestBody Map<String, Object> deptno) {
//		System.out.println(deptno.get("deptno"));
		deptService.delteDeptByDeptno( (String) deptno.get("deptno"));
	}
	
	@GetMapping(value = "/api/no-proxy")
	public String noProxy() {
		System.out.println("/api/no-proxy");
		return "no-proxy";
	}

	@GetMapping(value = "/api/proxy")
	public String onProxy() {
		System.out.println("/api/proxy");
		return "proxy";
	}

	@GetMapping(value = "/api/no-cors")
	public String noCors() {
		System.out.println("/api/no-cors");
		return "api/no-cors";
	}

	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
	@GetMapping(value = "/api/cors")
	public String cors() {
		System.out.println("/api/cors");
		return "api/cors";
	}
}

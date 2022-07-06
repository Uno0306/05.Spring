package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emp;
import com.example.service.EmpServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
public class EmpRestController {

	@Autowired
	EmpServiceImpl empService;

	@Autowired
	DeptRestController deptContorller;
	
	@GetMapping(value="/emp/emps")
	public List<Emp> getEmps(){
		return empService.getEmpAll();
	}

	@GetMapping(value = "/emp/{empno}")
	public Emp getEmpByEmpno(@PathVariable Long empno) {
		System.out.println(empno);
		return empService.getEmpByEmpno(empno);
	}

	@PostMapping(value = "/emp/{empno}", consumes =MediaType.APPLICATION_JSON_VALUE )
	public void insertDept(@PathVariable Long empno, @RequestBody Emp param) {
		Emp empCheck = new Emp();
		empCheck = getEmpByEmpno(param.getEmpno());
		if(empCheck == null) {
			LocalDate now = LocalDate.now();  
			
			Emp emp = new Emp();
			emp.setEmpno(param.getEmpno());
			emp.setEname(param.getEname());
			emp.setJob(param.getJob());
			emp.setMgr(param.getMgr());
			emp.setHiredate(now);
			emp.setSal(param.getSal());
			emp.setComm(param.getComm());
			emp.setDept(param.getDept());
			
			System.out.println(emp);
			
			empService.insertEmp(emp);
		}else {
			System.out.println("사원번호가 존재랍니다.");
		}
	}
	
	@PutMapping(value = "/emp/{empno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDeptByDeptno(@PathVariable Long empno, @RequestBody Emp param) {
		if(empno == null) {
			System.out.println("사원번호를 입력해주세요.");
		}else {
			Emp originEmp = getEmpByEmpno(empno);
			if(originEmp == null) {
				System.out.println("사원번호가 존재하지 않습니다.");
			} else {
				Emp emp = Emp.empCheck(originEmp, param);
				empService.updateEmp(emp);
			}
		}
	}

	
	@DeleteMapping(value="/emp/{empno}")
	@Transactional
	public void deleteByEmpno(@PathVariable Long empno) {
		Emp emp = new Emp();
		emp = getEmpByEmpno(empno);
		if(emp == null) {
			System.out.println("사원번호가 존재하지 않습니다.");
		}else {
			empService.deleteEmpByEmpno(empno);
		}
	}
}

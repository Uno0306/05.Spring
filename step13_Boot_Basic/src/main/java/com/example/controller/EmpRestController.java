package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emp;
import com.example.service.EmpServiceImpl;

@RestController
public class EmpRestController {

	@Autowired
	EmpServiceImpl empService;

	@GetMapping(value="/emps")
	public List<Emp> getEmps(){
		return empService.getEmpAll();
	}

	@GetMapping(value = "/emp/{empno}")
	public Emp getEmpByEmpno(@PathVariable Long empno) {
		System.out.println(empno);
		return empService.getEmpByEmpno(empno);
	}

	@PostMapping(value = "/emp/{empno}")
	public void insertDept(@PathVariable Long empno) {
	     // 포맷 정의        
//	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	     // 포맷 적용        
//	     String formatedNow = now.format(formatter);
	     
		Emp emp = new Emp();
		emp = getEmpByEmpno(empno);
		if(emp == null) {
			// 현재 날짜 구하기       
			LocalDate now = LocalDate.now();  
			
			emp = new Emp();
			emp.setEmpno(empno);
			emp.setEname("insert_ename");
			emp.setJob("insert_job");
			emp.setMgr(7902);
			emp.setHiredate(now);
			emp.setSal(1500.0f);
			emp.setComm(0.0f);
//			emp.setDeptno(20L);
			
			empService.insertEmp(emp);
		}else {
			System.out.println("사원번호가 존재랍니다.");
		}
	}
	
	@PutMapping(value = "emp/{empno}")
	public void updateDeptByDeptno(@PathVariable Long empno) {
		Emp emp = new Emp();
		emp = getEmpByEmpno(empno);
		if(emp == null) {
			System.out.println("사원번호가 존재하지 않습니다.");
		}else {
			LocalDate now = LocalDate.now();        
			
			emp = new Emp();
			emp.setEmpno(empno);
			emp.setEname("insert_ename");
			emp.setJob("insert_job");
			emp.setMgr(7902);
			emp.setHiredate(now);
			emp.setSal(1500.0f);
			emp.setComm(0.0f);
//			emp.setDept(20L);
			
			empService.updateEmp(emp);
		}
	}

	
	@DeleteMapping(value="/emp/{empno}")
	@Transactional
	public void deleteByDeptno(@PathVariable Long empno) {
		Emp emp = new Emp();
		emp = getEmpByEmpno(empno);
		if(emp == null) {
			System.out.println("사원번호가 존재하지 않습니다.");
		}else {
			empService.deleteEmpByEmpno(empno);
		}
	}
}

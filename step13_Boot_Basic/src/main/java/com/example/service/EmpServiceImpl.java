package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Emp;
import com.example.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository empRepositiry;
	
	@Override
	public List<Emp> getEmpAll() {
		return empRepositiry.findAll();
	}

	@Override
	public Emp getEmpByEmpno(Long empno) {
		return empRepositiry.findEmpByEmpno(empno);
	}
	
	@Override
	public void insertEmp(Emp emp) {
		System.out.println("insert : " + emp);
		empRepositiry.save(emp);
	}
	
	@Override
	public void updateEmp(Emp emp) {
		System.out.println("update : " + emp);
		empRepositiry.saveAndFlush(emp);
	};
	
	@Override
	public void deleteEmpByEmpno(Long empno) {
		System.out.println("delete : " + empno);
		empRepositiry.deleteEmpByEmpno(empno);
	};
}

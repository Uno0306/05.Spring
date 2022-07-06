package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Dept;
import com.example.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptRepository deptRepositiry;
	
	@Override
	public List<Dept> getDeptAll() {
		return deptRepositiry.findAll();
	}

	@Override
	public Dept getDeptByDeptno(Long deptno) {
		return deptRepositiry.findDeptByDeptno(deptno);
	}
	
	@Override
	public void insertDept(Dept dept) {
		deptRepositiry.save(dept);
	}
	
	@Override
	public void updateDept(Dept dept) {
		Dept deptBulider = Dept.deptBuilder(dept).build();
		deptRepositiry.saveAndFlush(deptBulider);
	};
	
	@Override
	public void deleteDeptByDeptno(Long deptno) {
		deptRepositiry.deleteDeptByDeptno(deptno);
	};
}

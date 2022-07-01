package com.spring.service;

import java.util.HashMap;
import java.util.List;

import com.spring.dto.Dept;

public interface DeptService {
	
	public String getDeptNameByDeptno(int deptno);
	
	public Dept getDeptByDeptno(int deptno);
	
	public HashMap<String, Object> getDeptMap(int deptno);
	
	public List<Dept> getAllDepts();

	public List<HashMap<String, Object>> getAllDeptsMap();
	
	public void insertDept(Dept dept);
	
//	public HashMap<String, Object> updateDept(int deptno, Map<String, String> map);
	

	public void updateDeptByDeptno(Dept data);
	
	public void delteDeptByDeptno(String deptno);
}

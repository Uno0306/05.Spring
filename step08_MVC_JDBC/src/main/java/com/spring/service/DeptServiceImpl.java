package com.spring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	DeptMapper deptMapper;
	
	@Override
	public String getDeptNameByDeptno(int deptno) {
		return deptMapper.getDeptNameByDeptno(deptno);
	};
	
	@Override
	public Dept getDeptByDeptno(int deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}
	
	@Override
	public HashMap<String, Object> getDeptMap(int deptno){
		return deptMapper.getDeptMap(deptno);
	};
	
	@Override
	public List<Dept> getAllDepts(){
		return deptMapper.getAllDepts();
	};
	
	@Override
	public List<HashMap<String, Object>> getAllDeptsMap(){
		return deptMapper.getAllDeptsMap();
	};
	
	
	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
	};
	
	
//	@Override
//	public HashMap<String, Object> updateDept(int deptno, Map<String, String> map){
//		return deptMapper.updateDept(deptno, map);
//	};
	

	@Override
	public void updateDeptByDeptno(Dept data) {
		deptMapper.updateDeptByDeptno(data);
	};
	
	@Override
	public void delteDeptByDeptno(String deptno) {
		deptMapper.delteDeptByDeptno(deptno);
	};
	
	
}

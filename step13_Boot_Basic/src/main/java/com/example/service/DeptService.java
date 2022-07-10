package com.example.service;

import java.util.List;

import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Dept;

public interface DeptService {
	public List<Dept> getDeptAll();
	
	public Dept getDeptByDeptno(Long deptno);
	
	public PageResultDTO<DeptDTO, Dept> getList(PageRequestDTO pageRequestDTO);
	
	public void insertDept(DeptDTO deptDTO);
	
	public void updateDept(Dept dept);
	
	public void deleteDeptByDeptno(Long deptno);
}

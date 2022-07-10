package com.example.service;

import java.util.List;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Emp;

public interface EmpService {
	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO);
	
	public Emp getEmpByEmpno(Long empno);
	
	public void insertEmp(EmpDTO empDTO);
	
	public void updateEmp(EmpDTO empDTO);
	
	public void deleteEmpByEmpno(Long empno);
}
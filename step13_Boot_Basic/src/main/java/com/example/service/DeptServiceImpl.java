package com.example.service;

import java.util.List;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.model.Dept;
import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.repository.DeptRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptRepository deptRepositiry;
	
	@Override
	public List<Dept> getDeptAll() {
		return deptRepositiry.findAll();
	}
	
	@Transactional
	@Override
	public PageResultDTO<DeptDTO, Dept> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("deptno").descending());
		
		Page<Dept> result = deptRepositiry.findAll(pageable);
		
		Function<Dept, DeptDTO> function = (deptEntity -> deptEntity.toDTO(deptEntity));
		
		return new PageResultDTO<DeptDTO, Dept>(result, function);
	};
	
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

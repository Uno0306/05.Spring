package com.example.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.DeptDTO;
import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Dept;
import com.example.model.Emp;
import com.example.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository empRepositiry;

	@Override
	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("empno").descending());
		Page<Emp> result = empRepositiry.findAll(pageable);
		Function<Emp, EmpDTO> function = (empEntity -> empEntity.toDTO(empEntity));

		return new PageResultDTO<EmpDTO, Emp>(result, function);
	};


	@Override
	public Emp getEmpByEmpno(Long empno) {
		return empRepositiry.findEmpByEmpno(empno);
	}

	@Override
	public void insertEmp(EmpDTO empDTO) {
		Emp empEntity = empDTO.toEntity(empDTO);
		
		empRepositiry.save(empEntity);
	}

	@Override
	public void updateEmp(EmpDTO empDTO) {
		Emp empEntity = empDTO.toEntity(empDTO);
		empRepositiry.save(empEntity);
	};

	@Override
	public void deleteEmpByEmpno(Long empno) {
		System.out.println("delete : " + empno);
		empRepositiry.deleteEmpByEmpno(empno);
	}


}

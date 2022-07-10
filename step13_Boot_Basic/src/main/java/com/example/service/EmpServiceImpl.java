package com.example.service;

import java.util.function.Function;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.entity.Emp;
import com.example.repository.EmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService{

//	@Autowired
	private final EmpRepository empRepositiry;

	@Transactional
	@Override
	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("empno").descending());
		Page<Emp> result = empRepositiry.findAll(pageable);
		Function<Emp, EmpDTO> function = (empEntity -> empEntity.toDTO(empEntity));

		return new PageResultDTO<EmpDTO, Emp>(result, function);
	};

	@Transactional
	@Override
	public Emp getEmpByEmpno(Long empno) {
		return empRepositiry.findEmpByEmpno(empno);
	}
	
	@Transactional
	@Override
	public void insertEmp(EmpDTO empDTO) {
		Emp empEntity = empDTO.toEntity(empDTO);
		
		empRepositiry.save(empEntity);
	}
	
	@Transactional
	@Override
	public void updateEmp(EmpDTO empDTO) {
		Emp empEntity = empDTO.toEntity(empDTO);
		empRepositiry.save(empEntity);
	};

	@Transactional
	@Override
	public void deleteEmpByEmpno(Long empno) {
		System.out.println("delete : " + empno);
		empRepositiry.deleteEmpByEmpno(empno);
	}

}

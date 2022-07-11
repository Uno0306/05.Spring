package com.example.controller;

import java.util.ArrayList;
import java.util.List;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.entity.Emp;
import com.example.service.EmpServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
public class EmpRestController {

//	@Autowired
	private final EmpServiceImpl empService;

	@GetMapping(value="/emp/emps")
	public PageResultDTO<EmpDTO, Emp> getEmp(PageRequestDTO pageRequestDTO) {
		PageResultDTO<EmpDTO, Emp> pageResultDTO = empService.getList(pageRequestDTO);
		List<EmpDTO> empList = new ArrayList<EmpDTO>();
		pageResultDTO.getDtoList().forEach(empDto -> empList.add(empDto));
		return pageResultDTO;
	}
	
	@GetMapping(value = "/emp/{empno}")
	public Emp getEmpByEmpno(@PathVariable Long empno) {
		return empService.getEmpByEmpno(empno);
	}

	@PostMapping(value = "/emp/{empno}", consumes =MediaType.APPLICATION_JSON_VALUE )
	public void insertEmp(@PathVariable Long empno, @RequestBody EmpDTO empDTO) {
		empDTO.setEmpno(empno);
		empService.insertEmp(empDTO);
	}
	
	@PutMapping(value = "/emp/{empno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEmpByEmpno(@PathVariable Long empno, @RequestBody EmpDTO empDTO) {
		if(empno == null ) {
			System.out.println("부서번호를 입력해주세요.");
		}else {
			Emp checkEmp= getEmpByEmpno(empno);
			if(checkEmp == null) {
				System.out.println("부서번호가 존재하지 않습니다.");
			}else {
				empDTO.setEmpno(empno);
				empService.updateEmp(empDTO);
			}
		}
	}

	
	@DeleteMapping(value="/emp/{empno}")
	public void deleteByEmpno(@PathVariable Long empno) {
		Emp emp = new Emp();
		emp = getEmpByEmpno(empno);
		if(emp == null) {
			System.out.println("사원번호가 존재하지 않습니다.");
		}else {
			empService.deleteEmpByEmpno(empno);
		}
	}
}
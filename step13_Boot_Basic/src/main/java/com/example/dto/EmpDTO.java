package com.example.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.model.Dept;
import com.example.model.Emp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpDTO {
	
	@Id
	private Long  empno;
	
	@Column(length = 10)
	private String ename;
	
	@Column(length = 9)
	private String job;
	private Integer mgr;
	
	private LocalDate hiredate;
	
	private Float sal;
	private Float comm;
	
	@ManyToOne()
	@JoinColumn(name="deptno")
	private Dept dept;
	
	public Emp toEntity(EmpDTO empDTO) {
		Emp empEntity = Emp.builder()
							.empno(empDTO.getEmpno())
							.ename(empDTO.getEname())
							.job(empDTO.getJob())
							.mgr(empDTO.getMgr())
							.sal(empDTO.getSal())
							.comm(empDTO.getComm())
							.dept(empDTO.getDept())
							.build();
		
		return empEntity;
	}
	
	
}

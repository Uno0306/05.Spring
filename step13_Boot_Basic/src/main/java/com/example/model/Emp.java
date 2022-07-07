package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name="emp")
public class Emp {
	
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
	
	public static Emp empCheck(Emp originEmp, Emp requestEmp) {
		LocalDate now = LocalDate.now();  
		
		if(requestEmp.getEmpno() == null) {
			requestEmp.setEmpno(originEmp.getEmpno());
		}
		if(requestEmp.getEname() == null) {
			requestEmp.setEname(originEmp.getEname());
		}
		if(requestEmp.getJob() == null) {
			requestEmp.setJob(originEmp.getJob());
		}
		if(requestEmp.getMgr() == null) {
			requestEmp.setMgr(originEmp.getMgr());
		}
		requestEmp.setHiredate(now);
		if(requestEmp.getSal() == null) {
			requestEmp.setSal(originEmp.getSal());
		}
		if(requestEmp.getComm() == null) {
			requestEmp.setComm(originEmp.getComm());
		}
		if(requestEmp.getDept() == null) {
			requestEmp.setDept(originEmp.getDept());
		}
		
		return requestEmp;
	}
	
	
}

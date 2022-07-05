package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private int mgr;
	private LocalDate hiredate;
	private float sal;
	private float comm;
	
//	@ManyToOne(fetch= FetchType.LAZY)
//	@JoinColumn(name="deptno")
//	private Dept dept;
}

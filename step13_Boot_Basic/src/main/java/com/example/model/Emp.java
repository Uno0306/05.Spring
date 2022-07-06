package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

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
	
}

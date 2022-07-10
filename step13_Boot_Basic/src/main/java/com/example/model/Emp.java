package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dto.EmpDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="emp")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Emp implements Persistable<Long>{
	
	@Id
	private Long  empno;
	
	@Column(length = 10)
	private String ename;
	
	@Column(length = 9)
	private String job;
	private Integer mgr;
	
	@CreatedDate
	private LocalDate hiredate;
	
	private Float sal;
	private Float comm;
	
	@ManyToOne()
	@JoinColumn(name="deptno")
	private Dept dept;
	
	@Override
	public Long getId() {
		return empno;
	}
	
	@Override	// 영속성이 있는지 판단하는 메소드
	public boolean isNew() {
		return hiredate == null;
	}
	
	public EmpDTO toDTO(Emp empEntity) {
		EmpDTO empDTO= EmpDTO.builder()
							.empno(empEntity.getEmpno())
							.ename(empEntity.getEname())
							.job(empEntity.getJob())
							.mgr(empEntity.getMgr())
							.hiredate(empEntity.getHiredate())
							.sal(empEntity.getSal())
							.comm(empEntity.getComm())
							.dept(empEntity.getDept())
							.build();
		
		return empDTO;
	}
	
	
}

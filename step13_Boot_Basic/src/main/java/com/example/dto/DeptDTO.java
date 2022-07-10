package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import com.example.entity.Dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptDTO {
	
	@Id
	private Long deptno;
	
	@Column(length = 14)
	private String dname;

	@Column(length = 13)
	private String loc;
	
	public Dept toEntity(DeptDTO deptDTO) {
		Dept deptEntity = Dept.DeptBuilder()
							.deptno(deptDTO.getDeptno())
							.dname(deptDTO.getDname())
							.loc(deptDTO.getLoc())
							.build();
		
		return deptEntity;
	}
	
	public static DeptDTO deptCheck(DeptDTO originDept, DeptDTO requestDept) {
		if(requestDept.getDeptno() == null) {
			requestDept.setDeptno(originDept.getDeptno());
		}
		if(requestDept.getDname() == null) {
			requestDept.setDname(originDept.getDname());
		}
		if(requestDept.getLoc() == null) {
			requestDept.setLoc(originDept.getLoc());
		}
		return requestDept;
	}
}

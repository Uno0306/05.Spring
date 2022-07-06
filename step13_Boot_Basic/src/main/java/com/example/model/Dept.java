package com.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DynamicInsert
@DynamicUpdate
@Entity(name = "dept")
@AllArgsConstructor()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(builderMethodName = "DeptBuilder")
public class Dept {
	
	@Id
	private Long deptno;
	
	@Column(length = 14)
	private String dname;

	@Column(length = 13)
	private String loc;
	
//	@OneToMany(mappedBy = "dept")
//	List<Emp> emps = new ArrayList<Emp>();

	public static DeptBuilder deptBuilder(Dept dept) {
		return DeptBuilder()
				.deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc());
	}
	
	public static Dept deptCheck(Dept originDept, Dept requestDept) {
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

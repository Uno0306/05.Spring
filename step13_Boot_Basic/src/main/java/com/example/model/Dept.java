package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity(name = "dept")
@AllArgsConstructor()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(builderMethodName = "DeptBuilder")
//@ToString(exclude = {"emps"})
public class Dept {
	
	@Id
	private Long deptno;
	
	@Column(length = 14)
	private String dname;

	@Column(length = 13)
	private String loc;
	
//	@OneToMany(mappedBy = "dept")
//	List<Emp> emps = new ArrayList<Emp>();
//	
	public static DeptBuilder deptBuilder(Dept dept) {
		return DeptBuilder()
				.deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc());
	}

	
	
}

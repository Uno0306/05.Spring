package com.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Persistable;

import com.example.dto.DeptDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "dept")
@Getter
//@DynamicInsert
//@DynamicUpdate
@AllArgsConstructor()
@NoArgsConstructor()
@ToString
@Builder(builderMethodName = "DeptBuilder")
public class Dept implements Persistable<Long>{

	@Id
	private Long deptno;

	@Column(length = 14)
	private String dname;

	@Column(length = 13)
	private String loc;

	//	@OneToMany(mappedBy = "dept")
	//	List<Emp> emps = new ArrayList<Emp>();

	public DeptDTO toDTO(Dept deptEntity) {
		DeptDTO deptDTO = DeptDTO.builder()
				.deptno(deptEntity.getDeptno())
				.dname(deptEntity.getDname())
				.loc(deptEntity.getLoc())
				.build();
		return deptDTO;
	}

	public static DeptBuilder deptBuilder(Dept dept) {
		return DeptBuilder()
				.deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc());
	}

	@Override
	public Long getId() {
		return deptno;
	}

	@Override
	public boolean isNew() {	// 영속성 존재 확인
		return deptno == null;
	}

}

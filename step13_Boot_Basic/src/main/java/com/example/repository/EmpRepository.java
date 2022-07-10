package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
	public Emp findEmpByEmpno(Long empno);
	
	public void deleteEmpByEmpno(Long empno);
	
}

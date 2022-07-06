package com.example.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
	public List<Emp> findAll();
	
	public Emp findEmpByEmpno(Long empno);
	
	@SuppressWarnings("unchecked")
	public Emp saveAndFlush(Emp emp);
	
	public void deleteEmpByEmpno(Long empno);
	
	
}

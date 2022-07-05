package com.example.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Dept;
import com.example.model.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
	public List<Emp> findAll();
	
	public Emp findEmpByEmpno(Long empno);
	
	public Emp save(Emp emp);
	
	public void deleteEmpByEmpno(Long empno);
	
	
}

package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.User;

public class CommentRepository extends JpaRepository<User, Long>  {

}

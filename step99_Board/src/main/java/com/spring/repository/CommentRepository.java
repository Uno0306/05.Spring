package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Comment;
import com.spring.entity.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>   {

}

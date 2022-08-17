package com.codewithhimalay.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithhimalay.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	
}

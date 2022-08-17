package com.codewithhimalay.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithhimalay.blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

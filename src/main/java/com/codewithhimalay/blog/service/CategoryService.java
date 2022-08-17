package com.codewithhimalay.blog.service;

import java.util.List;

import com.codewithhimalay.blog.payload.CategoryDto;

public interface CategoryService {

	 CategoryDto createCategory(CategoryDto categoryDto);
	
	 CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	 void deleteCategory(Integer categoryId);
	
	 CategoryDto getCategory(Integer categoryId);
	
	 List<CategoryDto> getAllCategories();
}

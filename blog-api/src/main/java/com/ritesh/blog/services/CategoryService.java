package com.ritesh.blog.services;

import java.util.List;

import com.ritesh.blog.payloads.CategoryDto;

public interface CategoryService {

//	createCategory
	CategoryDto createCategory(CategoryDto categoryDto);

//	updateCategory
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

//	deleteCategory
	void deleteCategory(Integer categoryId);

//	getCategory
	CategoryDto getCategory(Integer categoryId);

//	getAllCategory
	List<CategoryDto> getAllCategory();
}

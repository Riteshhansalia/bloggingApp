package com.ritesh.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.blog.payloads.ApiResponse;
import com.ritesh.blog.payloads.CategoryDto;
import com.ritesh.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bloggingApp")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getCategories")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		return ResponseEntity.ok(this.categoryService.getAllCategory());
	}

	@GetMapping("/getCategory/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable int categoryId) {
		return ResponseEntity.ok(this.categoryService.getCategory(categoryId));
	}

	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
	}

	@PutMapping("/updateCategory/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable int categoryId) {
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, categoryId);
		return ResponseEntity.ok(updateCategory);
	}

	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int categoryId) {
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted Successfully", true), HttpStatus.OK);
	}
}

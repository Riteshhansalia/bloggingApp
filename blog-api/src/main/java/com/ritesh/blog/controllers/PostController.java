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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.blog.payloads.ApiResponse;
import com.ritesh.blog.payloads.PostDto;
import com.ritesh.blog.services.PostService;

@RestController
@RequestMapping("/bloggingApp")
public class PostController {

	@Autowired
	private PostService postService;

//	createPost
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);

		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}

//	getPostByUser
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
		List<PostDto> getPostByUser = this.postService.getPostByUser(userId);

		return new ResponseEntity<List<PostDto>>(getPostByUser, HttpStatus.OK);
	}

//	getPostByCategory
	@GetMapping("/category/{categoryId}/post")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
		List<PostDto> getPostByCategory = this.postService.getPostbyCategory(categoryId);

		return new ResponseEntity<List<PostDto>>(getPostByCategory, HttpStatus.OK);
	}

//	getAllPost
	@GetMapping("/getPosts")
	public ResponseEntity<List<PostDto>> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {
		return ResponseEntity.ok(this.postService.getAllPosts(pageNumber, pageSize));
	}

//	getPost
	@GetMapping("/getPosts/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId) {
		return ResponseEntity.ok(this.postService.getpost(postId));
	}

//	deletePost
	@DeleteMapping("/deletePost/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable int postId) {
		this.postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted Successfully", true), HttpStatus.OK);
	}

//	updatePost
	@PutMapping("/updatePost/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}
}

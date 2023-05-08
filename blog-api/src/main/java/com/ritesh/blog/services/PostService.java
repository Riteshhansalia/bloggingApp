package com.ritesh.blog.services;

import java.util.List;

import com.ritesh.blog.payloads.PostDto;
import com.ritesh.blog.payloads.PostResponse;

public interface PostService {

//	createPost
	PostDto createPost(PostDto postDto, Integer useId, Integer cetegoryId);

//	updatePost
	PostDto updatePost(PostDto postDto, Integer postId);

//	deletePost
	void deletePost(Integer postId);

//	getPost
	PostDto getpost(Integer postId);

//	getAllPost
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String shortBy, String shortDir);

//	getPostByUser
	List<PostDto> getPostByUser(Integer userId);

//	getPostByCategory
	List<PostDto> getPostbyCategory(Integer categoryId);

//	serchPost
	List<PostDto> serchPosts(String Keyword);
}

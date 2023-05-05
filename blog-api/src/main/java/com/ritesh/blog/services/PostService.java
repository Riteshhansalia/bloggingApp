package com.ritesh.blog.services;

import java.util.List;

import com.ritesh.blog.entities.Post;
import com.ritesh.blog.payloads.PostDto;

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
	List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize);

//	getPostByUser
	List<PostDto> getPostByUser(Integer userId);

//	getPostByCategory
	List<PostDto> getPostbyCategory(Integer categoryId);

	List<Post> serchPosts(String Keyword);
}

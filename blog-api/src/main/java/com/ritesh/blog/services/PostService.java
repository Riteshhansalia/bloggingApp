package com.ritesh.blog.services;

import java.util.List;

import com.ritesh.blog.entities.Post;
import com.ritesh.blog.payloads.PostDto;

public interface PostService {
	

	PostDto createPost(PostDto postDto, Integer useId, Integer cetegoryId);
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	void deletePost(Integer postId);
	
	PostDto getpost(Integer postId);
	
	List<Post> getAllPosts();
	
	List<Post> getPostByUser(Integer userId);
	
	List<Post> getPostbyCategory(Integer categoryId);
	
	List<Post> serchPosts(String Keyword);
}

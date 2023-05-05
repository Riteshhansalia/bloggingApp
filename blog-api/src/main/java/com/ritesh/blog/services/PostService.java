package com.ritesh.blog.services;

import java.util.List;

import com.ritesh.blog.entities.Post;
import com.ritesh.blog.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer useId, Integer cetegoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

	PostDto getpost(Integer postId);

	List<PostDto> getAllPosts();

	List<PostDto> getPostByUser(Integer userId);

	List<PostDto> getPostbyCategory(Integer categoryId);

	List<Post> serchPosts(String Keyword);
}

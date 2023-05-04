package com.ritesh.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritesh.blog.entities.Category;
import com.ritesh.blog.entities.Post;
import com.ritesh.blog.entities.User;
import com.ritesh.blog.exceptions.ResourceNotFoundException;
import com.ritesh.blog.payloads.PostDto;
import com.ritesh.blog.repositories.CategoryRepo;
import com.ritesh.blog.repositories.PostRepo;
import com.ritesh.blog.repositories.UserRepo;
import com.ritesh.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	
	@Override
	public PostDto createPost(PostDto postDto,  Integer userId, Integer categoryId) {	
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " userId", userId));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", " categoryId", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("image.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost = this.postRepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		return null;
	}

	@Override
	public void deletePost(Integer postId) {


	}

	@Override
	public PostDto getpost(Integer postId) {

		return null;
	}

	@Override
	public List<Post> getAllPosts() {

		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {

		return null;
	}

	@Override
	public List<Post> getPostbyCategory(Integer categoryId) {

		return null;
	}

	@Override
	public List<Post> serchPosts(String Keyword) {

		return null;
	}

}

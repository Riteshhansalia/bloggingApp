package com.ritesh.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ritesh.blog.entities.User;
import com.ritesh.blog.payloads.UserDto;
import com.ritesh.blog.repositories.UserRepo;
import com.ritesh.blog.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		

	}
	
	public User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;
	}

}

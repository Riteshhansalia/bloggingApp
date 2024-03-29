package com.ritesh.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritesh.blog.entities.User;
import com.ritesh.blog.exceptions.ResourceNotFoundException;
import com.ritesh.blog.payloads.UserDto;
import com.ritesh.blog.repositories.UserRepo;
import com.ritesh.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

//	createUser
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User savedUser = this.userRepo.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

//	updateUser
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		User updateUser = this.userRepo.save(user);
		return this.modelMapper.map(updateUser, UserDto.class);
	}

//	getUser
	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id", userId));

		return this.modelMapper.map(user, UserDto.class);
	}

//	getAllUser
	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();

		List<UserDto> userDtos = users.stream().map((user) -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		return userDtos;
	}

//	deleteUser
	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id", userId));
		this.userRepo.delete(user);
	}

}

package com.ritesh.blog.services;

import java.util.List;

import com.ritesh.blog.payloads.UserDto;

public interface UserService {

//	createUser
	UserDto createUser(UserDto user);

//	updateUser
	UserDto updateUser(UserDto user, Integer userId);

//	getUser
	UserDto getUserById(Integer userId);

//	getAllUser
	List<UserDto> getAllUser();

//	deleteUser
	void deleteUser(Integer userId);

}

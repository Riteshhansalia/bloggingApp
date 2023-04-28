package com.ritesh.blog.controllers;

import java.util.List;
import java.util.Map;

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

import com.ritesh.blog.payloads.UserDto;
import com.ritesh.blog.services.UserService;

@RestController
@RequestMapping("/bloggingApp")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable int userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer userId){
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity(Map.of("message","User deleted Successfully"),HttpStatus.OK);
	}
}

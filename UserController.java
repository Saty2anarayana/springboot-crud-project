package com.satya.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.Entity.UserEntity;
import com.satya.request.UpdateRequest;
import com.satya.request.UserRequest;
import com.satya.service.UserService;

@RestController
@RequestMapping("")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add/user")
	public String adduser(@RequestBody UserRequest userRequest ) {
		return userService.createUser(userRequest);
	}
	
	@GetMapping("/get/users")
	public List<UserEntity> getAllUsers(){
		return userService.loadAllUsers();
	}
	@GetMapping("/get/users/id/{id}")
	public UserEntity getUserById(@PathVariable("id") int id){
		return userService.fetchUserById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}
	
	@PutMapping("/update/user/{id}")
	public UserEntity updateUser(@PathVariable("id")int id ,@RequestBody UpdateRequest updateRequest ) {
		return userService.updateUser(id,updateRequest); 
	}
	
}





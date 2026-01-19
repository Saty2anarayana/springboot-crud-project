package com.satya.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.Entity.UserEntity;
import com.satya.repository.UserRepository;
import com.satya.request.UpdateRequest;
import com.satya.request.UserRequest;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public String createUser(UserRequest userRequest) {
		UserEntity user=new UserEntity();
		user.setId(userRequest.getId());
		user.setName(userRequest.getName());
		user.setPassword(userRequest.getPassword());
		user.setMobileNum(userRequest.getMobileNum());
		user.setPlace(userRequest.getPlace());
		
		userRepository.save(user);
		return "user created successfully";
	}

	public List<UserEntity> loadAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
		
	}

	public UserEntity fetchUserById(int id) {
		return userRepository.findById(id).get();
		
	}

	public String deleteUser(int id) {
		Optional<UserEntity> userInfo=userRepository.findById(id);
		if(userInfo.isPresent()) {
			userRepository.deleteById(id);
			return "user deleted successfully";
		}
		
		return "user not found";
	
	}

	public UserEntity updateUser(int id, UpdateRequest updateRequest) {
		UserEntity update= userRepository.findById(id).get();
		update.setPassword(updateRequest.getPassword());
		update.setMobileNum(updateRequest.getMobileNum());
		
		userRepository.save(update);
		return null;
		
	}

	
		
	

}

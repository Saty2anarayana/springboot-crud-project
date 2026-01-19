package com.satya.controller;

import java.util.List;

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

import com.satya.Entity.EmployeeEntity;
import com.satya.request.EmployeeRequest;
import com.satya.service.EmployeeService;

@RestController
@RequestMapping("/user")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<String> postUser(@RequestBody EmployeeEntity employeeEntity){
		String employee =employeeService.postUser(employeeEntity); 
		return  new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeEntity>> getUsers(){
		List<EmployeeEntity> getEmployees =employeeService.getUser(); 
		return  new ResponseEntity<>(getEmployees,HttpStatus.OK);
	}
	
	@GetMapping("/get/id/{id}")
	public ResponseEntity<EmployeeEntity> getUsers(@PathVariable("id") int id){
		EmployeeEntity getEmployees =employeeService.getUser(id); 
		return  new ResponseEntity<>(getEmployees,HttpStatus.OK);
	}
	
	@PutMapping("/put/id/{id}")
	public ResponseEntity<EmployeeEntity> updateUsers(@PathVariable("id") int id, @RequestBody EmployeeRequest employeeRequest){
		EmployeeEntity updateEmployees =employeeService.updateUser(id,employeeRequest); 
		return  new ResponseEntity<>(updateEmployees,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<String> deleteUsers(@PathVariable("id") int id){
		String deleteEmployees =employeeService.deleteUser(id); 
		return  new ResponseEntity<>(deleteEmployees,HttpStatus.OK);
	}

}

package com.satya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.Entity.EmployeeEntity;
import com.satya.repository.EmployeeRepository;
import com.satya.request.EmployeeRequest;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public String postUser(EmployeeEntity employeeEntity) {
		
		EmployeeEntity employee= new EmployeeEntity();
		employee.setId(employeeEntity.getId());
		employee.setName(employeeEntity.getName());
		employee.setMobNum(employeeEntity.getMobNum());
		employee.setRollNum(employeeEntity.getRollNum());
		employeeRepository.save(employee);
		
		
		return "employee created successfully";
	}

	public List<EmployeeEntity> getUser() {
		
		return employeeRepository.findAll();
	}

	public EmployeeEntity getUser(int id) {
		
		Optional<EmployeeEntity> info= employeeRepository.findById(id);
		if(info.isPresent()) {
			return info.get();
		}
			else {
				return null;
			}
		
	}

	public EmployeeEntity updateUser(int id,EmployeeRequest employeeRequest) {
		
		EmployeeEntity employeeInfo=employeeRepository.findById(id).get();
		employeeInfo.setName(employeeRequest.getName());
		employeeInfo.setRollNum(employeeRequest.getRolNum());
		
		return employeeRepository.save(employeeInfo);
	}

	public String deleteUser(int id) {
		employeeRepository.deleteById(id);
		return "user deleted successfully";
	}

}

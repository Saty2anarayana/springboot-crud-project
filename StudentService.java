package com.satya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.Entity.StudentEntity;
import com.satya.repository.StudentRepository;
import com.satya.request.StudentRequest;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public String createStudent(StudentEntity studentEntity) {
		StudentEntity student=new StudentEntity();
		
		student.setName(studentEntity.getName());
		student.setEmail(studentEntity.getEmail());
		student.setRollNum(studentEntity.getRollNum());
		student.setMobNum(studentEntity.getMobNum());

		
	        studentRepository.save(student);
	        return "student created successfully";
	}

	public List<StudentEntity> getStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	public StudentEntity fetchbyid(long id) {
		
		return studentRepository.findById(id).get();
		
	}

	public StudentEntity fetchByIdAndName(long id, String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByIdAndName(id, name);
	}

	public StudentEntity update(long id, StudentRequest studentRequest) {
		StudentEntity studentUpdate=studentRepository.findById(id).get();
		studentUpdate.setName(studentRequest.getName());
		studentUpdate.setMobNum(studentRequest.getMobNum());
		studentRepository.save(studentUpdate);
		
		return null;
	}

}

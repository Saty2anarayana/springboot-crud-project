package com.satya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.Entity.StudentEntity;
import com.satya.request.StudentRequest;
import com.satya.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5174/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody StudentEntity studentEntity) {
		String student=studentService.createStudent(studentEntity);
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}
	@GetMapping("/get")
	public ResponseEntity<List<StudentEntity>> getStudents() {
		List<StudentEntity>studentData= studentService.getStudent();
		return new ResponseEntity<>(studentData,HttpStatus.OK);
	}
	@GetMapping("/get/id/{id}")
	public ResponseEntity<StudentEntity> getStudentbyid(@PathVariable("id")long id) {
		StudentEntity studentByid= studentService.fetchbyid(id);
		return new ResponseEntity<>(studentByid,HttpStatus.OK);
	}
	
	@GetMapping("/get/id/{id}/name/{name}")
	public ResponseEntity<StudentEntity> fetchByidAndName(@PathVariable("id")long id,@PathVariable("name") String name){
		StudentEntity student=studentService.fetchByIdAndName(id,name);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@PutMapping("/update/id/{id}")
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable("id") long id,@RequestBody StudentRequest studentRequest){
		StudentEntity student=studentService.update(id,studentRequest);
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}

}

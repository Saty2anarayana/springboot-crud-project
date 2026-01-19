package com.satya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
	
	public StudentEntity findByIdAndName(long id,String name);

}

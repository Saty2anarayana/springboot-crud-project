package com.satya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.Entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

}

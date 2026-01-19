package com.satya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}

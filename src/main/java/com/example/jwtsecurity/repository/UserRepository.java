package com.example.jwtsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtsecurity.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

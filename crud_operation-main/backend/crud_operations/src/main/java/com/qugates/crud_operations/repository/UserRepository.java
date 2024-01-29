package com.qugates.crud_operations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qugates.crud_operations.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

	User findByEmail(String email);

}

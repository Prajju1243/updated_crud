package com.qugates.crud_operations.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qugates.crud_operations.dto.User;
import com.qugates.crud_operations.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository repository;

	public void save(User user) {
		repository.save(user);
	}

	public boolean checkEmail(String email) {
		return repository.existsByEmail(email);
	}

	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

}

package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dakr.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}

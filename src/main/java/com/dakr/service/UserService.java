package com.dakr.service;

import com.dakr.model.User;

public interface UserService {

	User createUser(User user) throws Exception;

	User updateUser(Long userId, User user) throws Exception;

	void deleteUser(Long userId);

	User getUserByUsername(String username);

}

package com.dakr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.model.User;
import com.dakr.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
		

	    @Override
	    public User createUser(User user) throws Exception {
	        if (userRepository.findByUsername(user.getUsername()) != null) {
	            throw new Exception("Username already exists");
	        }

	        if (!user.getPassword().equals(user.getConfirmPassword())) {
	            throw new Exception("Password and Confirm Password do not match");
	        }

	        return userRepository.save(user);
	    }

	    @Override
	    public User updateUser(Long userId, User user) throws Exception {
	        User existingUser = userRepository.findById(userId)
	                .orElseThrow(() -> new Exception("User not found"));

	        if (!user.getPassword().equals(user.getConfirmPassword())) {
	            throw new Exception("Password and Confirm Password do not match");
	        }

	      //existingUser.setEmail(user.getEmail());
	        existingUser.setUsername(user.getUsername());
	        existingUser.setPassword(user.getPassword());

	        return userRepository.save(existingUser);
	    }

	    @Override
	    public void deleteUser(Long userId) {
	        userRepository.deleteById(userId);
	    }

	    @Override
	    public User getUserByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }
}

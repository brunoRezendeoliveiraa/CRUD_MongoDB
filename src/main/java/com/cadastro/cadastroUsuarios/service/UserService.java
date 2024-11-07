package com.cadastro.cadastroUsuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.cadastroUsuarios.domain.User;
import com.cadastro.cadastroUsuarios.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(String id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(String id, User userDetails) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User updatedUser = user.get();
			updatedUser.setName(userDetails.getName());
			updatedUser.setEmail(userDetails.getEmail());
			updatedUser.setAge(userDetails.getAge());
			return userRepository.save(updatedUser);
		}
		return null;
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}

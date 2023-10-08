package com.notestaker.userservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notestaker.userservice.entity.User;
import com.notestaker.userservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepo;
	
	public List<User> getUsers(){
		return this.userrepo.findAll();
	}
	
	public Boolean checkUsername(String username) {
		return userrepo.existsById(username);
	}
	
	public User signup(User user) {
		user.setRole("ROLE_USER");
		return this.userrepo.save(user);
	}
	
	public User getUserDetails(String name) {
		return this.userrepo.getUserByUserName(name);
	}

	public boolean deleteUser(String name, String password) {
		
		User user = getUserDetails(name);
		this.userrepo.delete(user);
		return true;
	}
}

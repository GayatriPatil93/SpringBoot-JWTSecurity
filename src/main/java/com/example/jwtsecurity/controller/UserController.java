package com.example.jwtsecurity.controller;
import lombok.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtsecurity.model.User;
import com.example.jwtsecurity.repository.UserRepository;

@RestController
@RequestMapping("/jwt/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	//create
	@PostMapping("/add")
	public String createUser(@RequestBody User user) {
		 userRepository.save(user);
		 return "User added successfully";
		
	}
	
	//Read
	@GetMapping("/getall")
	public List<User> getallusers(){
		return userRepository.findAll();
	}
	
	//read by id
	@GetMapping("/get/{id}")
	public User getByUserId(@PathVariable int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//update
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User updateuser) {
		return userRepository.findById(id).map(user -> {
				user.setUsername(updateuser.getUsername());
				user.setEmail(updateuser.getEmail());
				user.setPassword(updateuser.getPassword());
				return userRepository.save(user);
	})
				.orElse(null);
	}
	

		//delete
		@DeleteMapping("/{id}")
		public String deleteUser(@PathVariable int id) {
			userRepository.deleteById(id);
			return "User deleted with id :" +id;
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

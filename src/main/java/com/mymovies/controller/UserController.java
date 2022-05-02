package com.mymovies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovies.models.User;
import com.mymovies.repository.UserRepository;
import com.mymovies.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/v1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@PostMapping(path = "/user")
	public @ResponseBody String addUser(@RequestBody User user) {
		userRepository.save(user);
		return "Users data added successfully";
	} 
	
	@GetMapping("user/{userId}")
	public Optional<User> getuserId(@PathVariable int userId)
	{
		return userRepository.findById(userId);
	}
	
	@GetMapping("userbyname/{username}")
	public User getusername(@PathVariable String username)
	{
		List<User> users =  (List<User>) userRepository.findAll();
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getUsername().equals(username))
			{
				return users.get(i);
			}
			
		}
		return null;
	}
	
 
	
	@GetMapping("users")
	public List<User> getAllUsers()
	{
		List<User> user=(List<User>) userRepository.findAll();
		return user;
	}
	
	@DeleteMapping("deleteUserById/{userId}")
	public String deleteUserById(@PathVariable int userId) {
		userRepository.deleteById(userId);
		return "USer with ID: "+ userId + "Has been deleted";
	}
	
	@DeleteMapping("users")
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "All Users deleted successfully";
	}

}

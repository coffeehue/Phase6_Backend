package com.mymovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymovies.models.Admin;
import com.mymovies.service.AdminService;

@RestController
@RequestMapping(path = "/sporty")
public class AdminController {
	@Autowired
	private AdminService service;
	
	@GetMapping("/getalladmins")
	public List<Admin> findAllAdmins()
	{
		return service.getAdmins();
	}
	
	@PutMapping("/updateAdmins")
	public Admin updateAdmin(@RequestBody Admin admin)
	{
		return service.updateAdmin(admin);
	}
}

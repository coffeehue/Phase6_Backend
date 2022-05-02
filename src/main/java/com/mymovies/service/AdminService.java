package com.mymovies.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.Admin;
import com.mymovies.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

		public List<Admin> getAdmins()
		{
			return (List<Admin>) repository.findAll();
		}
		
	public Admin updateAdmin(Admin admin)
	{ 
		Admin existingAdmin = repository.findById(admin.getAdminId()).orElse(null);
		existingAdmin.setAdminId(admin.getAdminId());
		existingAdmin.setPassword(admin.getPassword());
		return repository.save(existingAdmin);
	}
}

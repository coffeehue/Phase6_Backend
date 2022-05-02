package com.mymovies.repository;

import org.springframework.data.repository.CrudRepository;

import com.mymovies.models.Admin;
public interface AdminRepository extends CrudRepository<Admin, String>{

}

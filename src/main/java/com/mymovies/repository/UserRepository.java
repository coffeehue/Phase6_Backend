package com.mymovies.repository;

import org.springframework.data.repository.CrudRepository;

import com.mymovies.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}

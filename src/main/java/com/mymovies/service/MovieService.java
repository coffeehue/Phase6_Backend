package com.mymovies.service;

import java.util.List;

import com.mymovies.models.movies;
import com.mymovies.repository.MovieRepository;
public interface MovieService {
	
		List<movies> findAll();
		
		movies save(movies movie);
		
		movies findById(Long id);
		
		void delete(Long id);
	}


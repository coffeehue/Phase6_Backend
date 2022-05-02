package com.mymovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.movies;
import com.mymovies.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	@Override
	public List<movies> findAll() {
		return movieRepository.findAll();
	}
	@Override
	public movies save(movies movie) {
		movieRepository.save(movie);
		return movie;
	}
	@Override
	public movies findById(Long id) {
		if(movieRepository.findById(id).isPresent())
		{
			return movieRepository.findById(id).get();
		}
		return null;
	}
	
	@Override
	public void delete(Long id) {
		movies Movie = findById(id);
		movieRepository.delete(Movie);
		
	}

}

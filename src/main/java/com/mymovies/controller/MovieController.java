package com.mymovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymovies.models.movies;
import com.mymovies.service.MovieService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	public ResponseEntity<List<movies>> get(){
		List<movies> Movies = movieService.findAll();
		return new ResponseEntity<List<movies>>(Movies,HttpStatus.OK);
	}
	
	@PostMapping("/movies")
	public ResponseEntity<movies> save(@RequestBody movies movie){
		movies Moviesnew = movieService.save(movie);
		return new ResponseEntity<movies>(Moviesnew,HttpStatus.OK);
	}
	
	@GetMapping("/movies/{id}")
	public ResponseEntity<movies> get(@PathVariable("id")Long id){
		movies Movie = movieService.findById(id);
		return new ResponseEntity<movies>(Movie,HttpStatus.OK);
	}
	
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")Long id){
		movieService.delete(id);
		return new ResponseEntity<String>("Movie Deleted Successfully",HttpStatus.OK);
	}
	
	
}

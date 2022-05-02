package com.mymovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymovies.models.movies;

@Repository
public interface MovieRepository extends JpaRepository<movies, Long> {

}

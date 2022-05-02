package com.mymovies.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mymovies.models.Bookings;
import com.mymovies.repository.BookingRepository;


@Service
public interface BookingService {
	

	List<Bookings> findAll();
	
	Bookings save(Bookings booking);
	
	Bookings findById(Long id);
	
	void delete(Long id);

}

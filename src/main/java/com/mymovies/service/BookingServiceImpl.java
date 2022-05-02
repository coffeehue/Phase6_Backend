package com.mymovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.models.Bookings;
import com.mymovies.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository bookingRepository;
	@Override
	public List<Bookings> findAll() {
		return bookingRepository.findAll();
	}
	@Override
	public Bookings save(Bookings booking) {
		bookingRepository.save(booking);
		return booking;
	}
	@Override
	public Bookings findById(Long id) {
		if(bookingRepository.findById(id).isPresent())
		{
			return bookingRepository.findById(id).get();
		}
		return null;
	}
	
	@Override
	public void delete(Long id) {
		Bookings Booking = findById(id);
		bookingRepository.delete(Booking);
		
	}
}

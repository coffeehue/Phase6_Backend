package com.mymovies.controller;

import java.util.LinkedList;
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

import com.mymovies.models.Bookings;
import com.mymovies.repository.BookingRepository;
import com.mymovies.service.BookingService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class BookingController {

	
	@Autowired
	BookingService bookingService;
	private BookingRepository bookingRepository;
	
	@GetMapping("/bookings")
	public ResponseEntity<List<Bookings>> get(){
		List<Bookings> Movies = bookingService.findAll();
		return new ResponseEntity<List<Bookings>>(Movies,HttpStatus.OK);
	}
	
	@PostMapping("/bookings")
	public ResponseEntity<Bookings> save(@RequestBody Bookings movie){
		Bookings Bookingnew = bookingService.save(movie);
		return new ResponseEntity<Bookings>(Bookingnew,HttpStatus.OK);
	}
	
	@GetMapping("/bookings/{id}")
	public ResponseEntity<Bookings> get(@PathVariable("id")Long id){
		Bookings Booking = bookingService.findById(id);
		return new ResponseEntity<Bookings>(Booking,HttpStatus.OK);
	}
	
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")Long id){
		bookingService.delete(id);
		return new ResponseEntity<String>("Booking Deleted Successfully",HttpStatus.OK);
	}
	
	@GetMapping("bookingsbyuser/{userid}")
	public List<Bookings> getusername(@PathVariable Long userid)
	{
		List<Bookings> bookings =  (List<Bookings>) bookingService.findAll();
		List<Bookings> booking = new LinkedList<Bookings>();
		
		for(int i=0,j=0;i<bookings.size();i++)
		{
			if(bookings.get(i).getUserId().equals(userid))
			{
				booking.add(j, bookings.get(i));
				j++;
			}
			
		}
		return booking;
	}
	
}

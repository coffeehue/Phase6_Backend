package com.mymovies.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymovies.models.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long>  {

}

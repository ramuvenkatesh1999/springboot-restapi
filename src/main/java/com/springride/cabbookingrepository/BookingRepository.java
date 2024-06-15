package com.springride.cabbookingrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springride.cabbookingentity.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
	public List<Booking> findByBookingType(String bookingType);

}

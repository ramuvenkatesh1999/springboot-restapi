package com.springride.cabbookingapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springride.cabbookingdto.BookingDTO;
import com.springride.cabbookingexception.CabBookingException;
import com.springride.cabbookingservice.CabBookingService;

public class CabBookingAPI {
	
	@Autowired
    private CabBookingService cabBookingService;

	@Autowired
	private Environment environment;

	@GetMapping(value="/cab/{ bookingType}")
	public ResponseEntity<List<BookingDTO>> getDetailsByBookingType (@PathVariable String bookingType) throws CabBookingException{

	List<BookingDTO> bookingDTO = cabBookingService.getDetailsBybookingType (bookingType);

	return new ResponseEntity<List<BookingDTO>> (bookingDTO, HttpStatus.OK);
	
	}

	@PostMapping(value="cab", consumes="/Application/Json")
	public ResponseEntity<String> bookCab (@RequestBody BookingDTO bookingDTO) throws CabBookingException{

	Integer bookingId = cabBookingService.bookcab (bookingDTO);

	String succcemessage =environment.getProperty("(API.BOOKING_SUCCESS}")+":"+bookingId;

	return new ResponseEntity<String>(succcemessage, HttpStatus.CREATED);
}
}

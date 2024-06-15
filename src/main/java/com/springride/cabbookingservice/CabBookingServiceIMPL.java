package com.springride.cabbookingservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springride.cabbookingdto.BookingDTO;
import com.springride.cabbookingentity.Booking;
import com.springride.cabbookingentity.Cab;
import com.springride.cabbookingexception.CabBookingException;
import com.springride.cabbookingrepository.BookingRepository;
import com.springride.cabbookingrepository.CabRepository;
import com.springride.cabbookingvalidator.BookingValidator;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CabBookingServiceIMPL implements CabBookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CabRepository cabRepository;
	
	@Autowired
	private BookingValidator bookingValidator;

	@Override
	public Integer bookcab(BookingDTO bookingDTO) throws CabBookingException {
		
		
		
		Optional<Cab> cabdetails = cabRepository.findBycabNo (bookingDTO.getCabDTO().getCabNO());

		Cab cab =cabdetails.orElseThrow(()-> new CabBookingException("CabBookingException"));

		if(cab.getAvailability()=="NO") {

		throw new CabBookingException("Service.CAB_NOT_AVAILABLE");

		}

		Booking booking = new Booking();
		booking.setBookingId (bookingDTO.getBookingId());
		booking.setBookingtype (bookingDTO.getBookingtype());
		booking.setCustomerName (bookingDTO.getCustomerName());
		booking.setCab (cab);
		cab.setAvailability("NO");
		Booking a =bookingRepository.save (booking);
		return a.getBookingId();

		
	}

	@Override
	public List<BookingDTO> getDetailsBybookingType(String bookingtype) throws CabBookingException {
	List<Booking> bookingdetails=	bookingRepository.findByBookingType (bookingtype);

		if (bookingdetails.isEmpty()) {

		throw new CabBookingException(" Service.NO_DETAILS_FOUND");

		}

		List<BookingDTO> list=new ArrayList<>();
		for (Booking booking:bookingdetails) {
		BookingDTO bookingdto=new BookingDTO();
		bookingdto.setBookingId(booking.getBookingId());
		bookingdto.setBookingtype (booking.getBookingtype());
		bookingdto.setCustomerName (booking.getCustomerName()); 
		bookingdto.setPhoneNo (booking.getPhoneNo());

		list.add(bookingdto);
		}

		return list;
		
	}
	

}

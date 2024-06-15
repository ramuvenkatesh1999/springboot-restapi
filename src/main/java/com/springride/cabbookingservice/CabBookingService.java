package com.springride.cabbookingservice;

import java.util.List;

import com.springride.cabbookingdto.BookingDTO;
import com.springride.cabbookingexception.CabBookingException;

public interface CabBookingService {
	public Integer bookcab (BookingDTO bookingDTO) throws CabBookingException;
	public List<BookingDTO> getDetailsBybookingType(String customerName) throws CabBookingException;
	

}

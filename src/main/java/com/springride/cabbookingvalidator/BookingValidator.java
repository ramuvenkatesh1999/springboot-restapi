package com.springride.cabbookingvalidator;

import com.springride.cabbookingdto.BookingDTO;
import com.springride.cabbookingexception.CabBookingException;

public class BookingValidator {

	public void validate (BookingDTO bookingDTO) throws CabBookingException

	{

	if (Boolean.FALSE.equals (validatePhoneNo (bookingDTO.getPhoneNo()))) throw new CabBookingException("Validator.INVALID_PHONENO");

	}

	public Boolean validatePhoneNo (Long phoneNo) {

	return phoneNo.toString().matches("[6-9](1) [0-9](9)");

	}
}

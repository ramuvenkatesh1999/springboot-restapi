package com.springride.cabbookingutility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.springride.cabbookingexception.CabBookingException;

public class LoggingAspect {
	
	private static final Log LOGGER= LogFactory.getLog(LoggingAspect.class);
	public void logserviceException(CabBookingException exception) {
		
	}

}

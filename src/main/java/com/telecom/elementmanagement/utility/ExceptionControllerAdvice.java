package com.telecom.elementmanagement.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.telecom.elementmanagement.exception.ElementException;



public class ExceptionControllerAdvice {

	 private static final Logger LOGGER = LogManager.getLogger(ExceptionControllerAdvice.class);
    @Autowired
	private Environment environment;
    
    @ExceptionHandler(ElementException.class)
    public ResponseEntity<ErrorInfo> handlerElemenException(ElementException exception)   {
    	
    	LOGGER.error(exception.getMessage(), exception);
    	 
    	
    	ErrorInfo errorInfo = new ErrorInfo();
    	errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
    	errorInfo.setErrorMessage(environment.getProperty(exception.getMessage()));
    	
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    	
    }
    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> generalExceptionHandler (Exception exception){
    	
    	LOGGER.error(exception.getMessage(), exception);
    	
    	ErrorInfo errorInfo = new ErrorInfo();
    	errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    	errorInfo.setErrorMessage(environment.getProperty("General.Exception_Message"));
    	
		return new ResponseEntity<ErrorInfo>(HttpStatus.INTERNAL_SERVER_ERROR);
   
    }
    
}

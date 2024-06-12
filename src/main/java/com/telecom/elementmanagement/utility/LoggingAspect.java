package com.telecom.elementmanagement.utility;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.telecom.elementmanagement.exception.ElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.tele.element...(..))", throwing = "exception")
    public void logServiceException(ElementException exception) throws ElementException  {
    	LOGGER.error("Exception occurred: " + exception.getMessage(), exception);
}
}
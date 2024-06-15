package com.telecom.elementmanagement.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.elementmanagement.dto.ElementDTO;
import com.telecom.elementmanagement.exception.ElementException;
import com.telecom.elementmanagement.repository.ElementManagementRepository;
import com.telecom.elementmanagement.utility.ExceptionControllerAdvice;
import com.telecom.elementmanagment.entity.Elements;


@Service


public class ElementManagementServiceIMPL  implements ElementmanagementService   {
	
	
	private static final Logger LOGGER = LogManager.getLogger(ElementmanagementService.class);
	@Autowired
    private ElementManagementRepository elementmanagementrepository;

	@Override
	public Iterable<Elements> getAllElement() throws ElementException {
		// TODO Auto-generated method stub
		return elementmanagementrepository.findAll() ;
	}

	@Override
	public Elements creatElement(ElementDTO elementDTO) throws ElementException {
		// TODO Auto-generated method stub
		Elements element = new Elements();
		   element.setName(elementDTO.getName());
		   element.setIpAddress(elementDTO.getIpAddress());
		   
		    return elementmanagementrepository.save(element);
	}

	@Override
	public Elements updateElement(Long id, ElementDTO elementDTO) {
		// TODO Auto-generated method stub
		Optional<Elements> optionalElement= elementmanagementrepository.findById(id);
		if
		(optionalElement.isPresent()) {
			
	    Elements element =optionalElement.get();
	    element.setName(elementDTO.getName());
	    element.setIpAddress(elementDTO.getIpAddress());
	    return elementmanagementrepository.save(element);
			
		} else {
			throw new RuntimeException("Element not found with:" + id);
		}
	}

	@Override
	public void deleteElement(Long id) {
		// TODO Auto-generated method stub
		elementmanagementrepository.deleteById(id);
		
	}
	
	                                  
}

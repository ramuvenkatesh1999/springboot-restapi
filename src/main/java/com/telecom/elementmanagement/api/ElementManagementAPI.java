package com.telecom.elementmanagement.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.elementmanagement.dto.ElementDTO;
import com.telecom.elementmanagement.exception.ElementException;
import com.telecom.elementmanagement.service.ElementmanagementService;
import com.telecom.elementmanagment.entity.Elements;

@RestController
@RequestMapping ("/api/elements")
public class ElementManagementAPI {

	private static final Logger LOGGER = LogManager.getLogger(ElementManagementAPI.class);
	
	@Autowired
	  private ElementmanagementService  elementmanagementservice;
  
  @GetMapping
  public Iterable<Elements> getAllelement() throws ElementException{
		return elementmanagementservice.getAllElement();
	  
  }  
 
  @PostMapping
  public Elements createElement (@RequestBody ElementDTO elementDTO) throws ElementException {
      return elementmanagementservice.creatElement(elementDTO);
  }
  @PutMapping("/{id}")
  public Elements updateElement (@PathVariable Long id, @RequestBody ElementDTO elementDTO) {
  	return elementmanagementservice.updateElement(id, elementDTO);
  	
  }
  
  @DeleteMapping("/{id}")
  public void deleteElement (@PathVariable Long id) {
	  elementmanagementservice.deleteElement(id);
  }
}

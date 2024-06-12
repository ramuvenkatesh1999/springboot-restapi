package com.telecom.elementmanagement.service;

import com.telecom.elementmanagement.dto.ElementDTO;
import com.telecom.elementmanagement.exception.ElementException;
import com.telecom.elementmanagment.entity.Elements;

public interface ElementmanagementService {
	public Iterable<Elements> getAllElement() throws ElementException;
	public Elements creatElement(ElementDTO elementDTO) throws ElementException;
	public Elements updateElement(Long id, ElementDTO elementDTO);
	public  void deleteElement(Long id);

}

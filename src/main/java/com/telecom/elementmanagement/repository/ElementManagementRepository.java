package com.telecom.elementmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.telecom.elementmanagment.entity.Elements;



public interface ElementManagementRepository extends CrudRepository<Elements, Long> {

}

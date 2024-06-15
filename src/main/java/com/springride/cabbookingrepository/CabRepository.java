package com.springride.cabbookingrepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springride.cabbookingentity.Cab;

@Repository
public interface CabRepository extends CrudRepository<Cab, Integer> {
	public Optional<Cab> findBycabNo(Integer cabNO);

}

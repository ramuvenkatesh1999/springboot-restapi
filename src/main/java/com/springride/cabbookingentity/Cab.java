package com.springride.cabbookingentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cab {
	@Id
	 private Integer cabNO;
	 private String modelName;
	 private Long driverphoneNo;
	 private String availability;
	public Integer getCabNO() {
		return cabNO;
	}
	public void setCabNO(Integer cabNO) {
		this.cabNO = cabNO;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Long getDriverphoneNo() {
		return driverphoneNo;
	}
	public void setDriverphoneNo(Long driverphoneNo) {
		this.driverphoneNo = driverphoneNo;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	 
	 
	 
}

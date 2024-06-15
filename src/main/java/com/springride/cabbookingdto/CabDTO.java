package com.springride.cabbookingdto;

public class CabDTO {
	
	 private Integer cabNO;
	 private String modelName;
	 private Long driverphoneNo;
	 private String availability;
	 
	 
	public CabDTO() {
		super();
		
	}


	public CabDTO(Integer cabNO, String modelName, Long driverphoneNo, String availability) {
		super();
		this.cabNO = cabNO;
		this.modelName = modelName;
		this.driverphoneNo = driverphoneNo;
		this.availability = availability;
	}


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

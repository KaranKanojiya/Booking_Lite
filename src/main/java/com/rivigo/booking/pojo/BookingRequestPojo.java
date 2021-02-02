package com.rivigo.booking.pojo;

import javax.validation.constraints.NotNull;

public class BookingRequestPojo {

	
	String source;
	String destination;
	Double weightInKg;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getWeightInKg() {
		return weightInKg;
	}
	public void setWeightInKg(Double weightInKg) {
		this.weightInKg = weightInKg;
	}
	
	
}

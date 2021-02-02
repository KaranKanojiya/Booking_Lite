package com.rivigo.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vehicle")
public class VehicleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "vid")
	private Long vId;
		
	@Column(name = "vnumber")
	private String vNumber;
	
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "booking_status")
	private boolean  bookingStatus;
	
	@Column(name = "vowner")
	private String vOwner;
	
	@Column(name = "vregistereddate")
	private String vRegisteredDate;
	
	@Column(name="maxweightcarrykg")
	private Double maxWeightCarryKg;
	
	@Column(name="cost")
	private Double cost;
	
	

	public Long getvId() {
		return vId;
	}

	public void setvId(Long vId) {
		this.vId = vId;
	}

	public String getvNumber() {
		return vNumber;
	}

	public void setvNumber(String vNumber) {
		this.vNumber = vNumber;
	}

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

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getvOwner() {
		return vOwner;
	}

	public void setvOwner(String vOwner) {
		this.vOwner = vOwner;
	}

	public String getvRegisteredDate() {
		return vRegisteredDate;
	}

	public void setvRegisteredDate(String vRegisteredDate) {
		this.vRegisteredDate = vRegisteredDate;
	}

	public Double getMaxWeightCarryKg() {
		return maxWeightCarryKg;
	}

	public void setMaxWeightCarryKg(Double maxWeightCarryKg) {
		this.maxWeightCarryKg = maxWeightCarryKg;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	
}

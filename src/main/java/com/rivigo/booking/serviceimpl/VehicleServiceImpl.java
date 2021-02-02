package com.rivigo.booking.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivigo.booking.entity.VehicleEntity;
import com.rivigo.booking.exception.CustomValidationException;
import com.rivigo.booking.pojo.BookingRequestPojo;
import com.rivigo.booking.pojo.BookingResponsePojo;
import com.rivigo.booking.repository.VehicleRepo;
import com.rivigo.booking.util.Constant;
import com.rivigo.booking.util.StringUtil;

@Service
public class VehicleServiceImpl {


	@Autowired
	private VehicleRepo vehicleRepo;

	public List<VehicleEntity> getVehicleList() {

		return vehicleRepo.findAll();
	}

	public List<BookingResponsePojo> getBookingList(BookingRequestPojo bookingRequestPojo) throws CustomValidationException {

		if (StringUtil.isNullOrEmpty(bookingRequestPojo.getSource())
				||StringUtil.isNullOrEmpty(bookingRequestPojo.getDestination())
				|| bookingRequestPojo.getWeightInKg() < Double.MIN_VALUE)
		{
			throw new CustomValidationException("Mandatory Attributes are Missing");
		}
		List<BookingResponsePojo> result=new ArrayList<BookingResponsePojo>();

		List<VehicleEntity> lvehicleEntity=vehicleRepo.bookVehicle(bookingRequestPojo.getSource(),bookingRequestPojo.getDestination(),bookingRequestPojo.getWeightInKg());
		for(VehicleEntity vehEntity:lvehicleEntity)
		{
			BookingResponsePojo bookingResponsePojo=new BookingResponsePojo();
			bookingResponsePojo.setVehicleNumber(vehEntity.getvNumber());
			bookingResponsePojo.setCost(1000);
			result.add(bookingResponsePojo);
		}
		return result;
	}

	public HashMap<String,String> addVehicle(List<VehicleEntity> vehList) {
		HashMap<String,String> map=new HashMap<String, String>();
		if(vehList!=null)
		{
			vehicleRepo.saveAll(vehList);
			map.put(Constant.BOOKING_MODULE_MESSAGE,Constant.SUCCESSFULL_MESSAGE);
		}
		else 
		{
			map.put(Constant.BOOKING_MODULE_MESSAGE,Constant.FAILED_MESSAGE);
		}
		return map;
	}


}

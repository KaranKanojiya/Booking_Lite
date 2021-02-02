package com.rivigo.booking.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rivigo.booking.entity.ErrorDetails;
import com.rivigo.booking.entity.VehicleEntity;
import com.rivigo.booking.exception.CustomValidationException;
import com.rivigo.booking.pojo.BookingRequestPojo;
import com.rivigo.booking.pojo.BookingResponsePojo;
import com.rivigo.booking.serviceimpl.VehicleServiceImpl;
import com.rivigo.booking.util.Constant;
import com.rivigo.booking.util.DateUtil;





@RestController
@RequestMapping(value = "/booking")
public class BookingController {

	Logger logger = (Logger) LoggerFactory.getLogger(BookingController.class);


	@Autowired
	private VehicleServiceImpl vehicleServiceImpl;

	@GetMapping("/allVehicle")
	public  ResponseEntity<Object> getVehicleList(){

		try {
			List<VehicleEntity> resulList=vehicleServiceImpl.getVehicleList();
			if(resulList!=null)
			{
				if(resulList.isEmpty())
				{
					HashMap<String,String> map=new HashMap<String, String>();
					map.put(Constant.BOOKING_MODULE_MESSAGE,Constant.BOOKING_MODULE_VEHICLE_UNAVAILABLE);
					return ResponseEntity.status(HttpStatus.OK).body(map);
				}
				else
					return ResponseEntity.status(HttpStatus.OK).body(resulList);			}

		}
		catch (Exception e) {
			logger.error("Exception Occurred while fetching booking Vehicle : " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.OK).body(ErrorDetails.getInternalServerError(e));
		}
		return ResponseEntity.status(HttpStatus.OK).body(ErrorDetails.getInternalServerError());


	}


	@PostMapping("/bookVehicle")
	public ResponseEntity<Object> getVehicle(@RequestBody BookingRequestPojo bookingRequestPojo)
	{
		try {
			List<BookingResponsePojo> resulList=vehicleServiceImpl.getBookingList(bookingRequestPojo);


			if(resulList!=null)
			{
				if(resulList.isEmpty())
				{
					HashMap<String,String> map=new HashMap<String, String>();
					map.put(Constant.BOOKING_MODULE_MESSAGE,Constant.BOOKING_MODULE_VEHICLE_UNAVAILABLE);
					return ResponseEntity.status(HttpStatus.OK).body(map);
				}
				else
					return ResponseEntity.status(HttpStatus.OK).body(resulList);

			}

		}
		catch (CustomValidationException cve) {
			logger.error("CustomValidationException Occurred while booking Vehicle : " + cve.getMessage(), cve);
			return ResponseEntity.status(HttpStatus.OK).body(ErrorDetails.getCustomValidationError(cve));
		}
		catch (Exception e) {
			logger.error("Exception Occurred while fetching booking Vehicle : " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.OK).body(ErrorDetails.getInternalServerError(e));
		}
		return ResponseEntity.status(HttpStatus.OK).body(ErrorDetails.getInternalServerError());

	}

	@PostMapping("/addVehicle")
	public ResponseEntity<Object> addVehicle(@RequestBody List<VehicleEntity> vehList)
	{
		HashMap<String,String> map=vehicleServiceImpl.addVehicle(vehList);
		if(map ==null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}else if(map !=null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		return null;

	}


}

package com.rivigo.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rivigo.booking.entity.VehicleEntity;
import com.rivigo.booking.pojo.BookingRequestPojo;

public interface VehicleRepo extends JpaRepository<VehicleEntity,Long>{

	@Query(value = "select * from vehicle  where source IN(:source) AND destination IN(:destination) AND booking_status IN(false) AND maxweightcarrykg >= :weight ", nativeQuery = true)
	List<VehicleEntity> bookVehicle(@Param("source")String source,@Param("destination") String destination,@Param("weight") Double weight);

	
	

}

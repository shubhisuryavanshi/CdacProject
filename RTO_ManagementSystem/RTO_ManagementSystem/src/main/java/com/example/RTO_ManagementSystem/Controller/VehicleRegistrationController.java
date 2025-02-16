package com.example.RTO_ManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RTO_ManagementSystem.Dao.User_Dao;
import com.example.RTO_ManagementSystem.Dao.VehicleRegistrationDao;
import com.example.RTO_ManagementSystem.Entity.User_Entity;
import com.example.RTO_ManagementSystem.Entity.VehicleRegistrationEntity;



@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class VehicleRegistrationController {
	
	@Autowired
	VehicleRegistrationDao vehicleRegistrationDao;
	
	@Autowired
	User_Dao user_Dao;
	
	@PostMapping("/VehicleSaveData")
	public VehicleRegistrationEntity VehicleSaveData(@RequestBody VehicleRegistrationEntity vehicleRegistrationEntity, @RequestParam("user_id") int user_id) {
		 User_Entity user_Entity = user_Dao.findById(user_id);  //user_Dao.findByUserId(user_id);
		 vehicleRegistrationEntity.setUser_Entity(user_Entity);  	 
		return vehicleRegistrationDao.VehicleSaveData(vehicleRegistrationEntity);
	}
	
	@GetMapping("/getVehicleDataByUserId")
	public VehicleRegistrationEntity getByUserId(@RequestParam int user_id) {
	    return vehicleRegistrationDao.getByUserId(user_id);
	}

	@GetMapping("/GetAllVehicalData")
	public List<VehicleRegistrationEntity> getMethodName() {
		return vehicleRegistrationDao.GetAllVehicalData();
	}
	
}

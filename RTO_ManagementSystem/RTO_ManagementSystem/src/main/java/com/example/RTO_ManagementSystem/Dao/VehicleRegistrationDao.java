package com.example.RTO_ManagementSystem.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RTO_ManagementSystem.Entity.User_Entity;
import com.example.RTO_ManagementSystem.Entity.VehicleRegistrationEntity;
import com.example.RTO_ManagementSystem.Entity.VehicleRegistrationStatus;
import com.example.RTO_ManagementSystem.Repo.VehicleRegistrationRepo;

@Repository
public class VehicleRegistrationDao {
	
	@Autowired
	VehicleRegistrationRepo vehicleRegistrationRepo;
	
	@Autowired
	User_Dao user_Dao;

	public VehicleRegistrationEntity VehicleSaveData(VehicleRegistrationEntity vehicleRegistrationEntity) {
		vehicleRegistrationEntity.setRegistrationStatus(VehicleRegistrationStatus.InActive);
		return vehicleRegistrationRepo.save(vehicleRegistrationEntity);
	}

	public VehicleRegistrationEntity getByUserId(int user_id) {
		User_Entity user_Entity = user_Dao.findById(user_id);
		return vehicleRegistrationRepo.findById(user_id);
	}

	public List<VehicleRegistrationEntity> GetAllVehicalData() {
		return vehicleRegistrationRepo.findAll();
	}
	
	/*
	 * public String findByVehical_id(String vehicle_id) { return
	 * vehicleRegistrationRepo.findByVehicle_id(vehicle_id); }
	 */


}

package com.example.RTO_ManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.RTO_ManagementSystem.Dao.InsuranceDao;
import com.example.RTO_ManagementSystem.Dao.User_Dao;
import com.example.RTO_ManagementSystem.Entity.InsuranceEntity;
import com.example.RTO_ManagementSystem.Entity.User_Entity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class InsuranceController {

	@Autowired
	InsuranceDao insuranceDao;
	
	@Autowired
    User_Dao user_Dao;
	
	@PostMapping("/InsuranceSaveData")
	public InsuranceEntity InsuranceSaveData(@RequestBody InsuranceEntity insuranceEntity, @RequestParam("user_id") int user_id) {
	 User_Entity user_Entity = user_Dao.findById(user_id);  //user_Dao.findByUserId(user_id);
	insuranceEntity.setUser_Entity(user_Entity);
	return insuranceDao.InsuranceSaveData(insuranceEntity);
	}
	
	@GetMapping("/GetByInsuranceId")
	public InsuranceEntity GetByInsuranceId(@RequestParam int insurance_id) {
		return insuranceDao.GetByInsuranceId(insurance_id);
	}
	
	
	@GetMapping("/GetAllInsuranceData")
	public List<InsuranceEntity> GetAllInsuranceData() {
		return insuranceDao.GetAllInsuranceData();
	}
	
}

package com.example.RTO_ManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RTO_ManagementSystem.Dao.DrivingTestDao;
import com.example.RTO_ManagementSystem.Dao.Driving_Licenses_Dao;
import com.example.RTO_ManagementSystem.Dao.Learner_LicensesDao;
import com.example.RTO_ManagementSystem.Dao.LicenseRenewalDao;
import com.example.RTO_ManagementSystem.Entity.DrivingTestAppoinment;
import com.example.RTO_ManagementSystem.Entity.Driving_Licenses;
import com.example.RTO_ManagementSystem.Entity.Learner_Licenses;
import com.example.RTO_ManagementSystem.Entity.LicenseRenewal;

import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class AdminController {
	
	@Autowired
	Driving_Licenses_Dao driving_Licenses_Dao;
	
	@Autowired
	DrivingTestDao drivingTestDao;
	
//	@Autowired
//	InsuranceDao insuranceDao;
	
	@Autowired
	Learner_LicensesDao learner_LicensesDao;
	
	@Autowired
	LicenseRenewalDao licenseRenewalDao;
	
	@PutMapping("UpdateDrivingLicanseFromAdmin")
	public Driving_Licenses UpdateDrivingLicanseFromAdmin(@RequestParam int license_id, @RequestBody Driving_Licenses driving_Licenses,@RequestParam String drivingStatus) {
		Driving_Licenses driving_Licenses2 = driving_Licenses_Dao.UpdateDrivingLicanse(license_id,driving_Licenses,drivingStatus);
		return driving_Licenses2;
	}
	
	
	@PutMapping("UpdateLearner_LicanseFromAdmin")
	public Learner_Licenses UpdateLearner_LicanseFromAdmin(@RequestParam int learner_id, @RequestBody Learner_Licenses learner_Licenses,@RequestParam String learningStatus) {
		Learner_Licenses learner_Licenses2 = learner_LicensesDao.UpdateLearner_LicanseFromAdmin(learner_id,learner_Licenses,learningStatus);
		return learner_Licenses2;
	}
	
	
	@PutMapping("UpdateDrivingTestFromAdmin")
	public DrivingTestAppoinment UpdateDrivingTestFromAdmin(@RequestParam int appointment_id, @RequestBody DrivingTestAppoinment drivingTestAppoinment, @RequestParam String testStatus) {
		DrivingTestAppoinment drivingTestAppoinment2 = drivingTestDao.UpdateDrivingTestFromAdmin(appointment_id,drivingTestAppoinment,testStatus);
		return drivingTestAppoinment2;
	}
	
	@PutMapping("/UpdateLicenseRenewalFromAdmin")
	public LicenseRenewal putMethodName( @RequestParam int renewal_id,@RequestBody LicenseRenewal licenseRenewal,@RequestParam String licenserRenewalStatus) {
		LicenseRenewal licenseRenewal2 = licenseRenewalDao.UpdateLicenseRenewalFromAdmin(renewal_id,licenseRenewal,licenserRenewalStatus);
		return licenseRenewal2;
	}

}

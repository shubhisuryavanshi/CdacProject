package com.example.RTO_ManagementSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.RTO_ManagementSystem.Entity.DrivingStatus;
import com.example.RTO_ManagementSystem.Entity.Driving_Licenses;
import com.example.RTO_ManagementSystem.Entity.License_Type;
import com.example.RTO_ManagementSystem.Entity.UserStatus;
import com.example.RTO_ManagementSystem.Entity.User_Entity;
import com.example.RTO_ManagementSystem.Entity.Vehicle_Type;
import com.example.RTO_ManagementSystem.Repo.Driving_Licenses_Repo;

@Repository
public class Driving_Licenses_Dao 
{
    @Autowired
    Driving_Licenses_Repo driving_Licenses_Repo;
    
    public Driving_Licenses SaveData(Driving_Licenses driving_Licenses,String status, String action, String role)
    {
    	driving_Licenses.setDrivingStatus(DrivingStatus.inactive);
    	
    	
    	 if ("Bike".equals(action)) 
    	 {
    		 driving_Licenses.setVehicle_Type(Vehicle_Type.Bike);
    	 } else if ("Car".equals(action)) 
    	 {
    		 driving_Licenses.setVehicle_Type(Vehicle_Type.Car);
    	 }
    	 
    	 
    	 if ("Private".equals(role)) 
    	 {
    	       driving_Licenses.setLicense_Type(License_Type.Private);
    	       
    	 }else if ("Commercial".equals(role))
    	 {
    		 driving_Licenses.setLicense_Type(License_Type.Commercial);
    	 }
    
    	return driving_Licenses_Repo.save(driving_Licenses);
    }
    
    // Get All Licenses Data 
    
    public List<Driving_Licenses> GetAllLicensesData()
    {
    	return driving_Licenses_Repo.findAll();
    }
    
    //Get and Update Data By Licenses_Id
    
    public Driving_Licenses GetDataById(int license_id)
    {
    	return driving_Licenses_Repo.findById(license_id).get();
    }

	public Driving_Licenses UpdateDrivingLicanse(int license_id, Driving_Licenses driving_Licenses,String drivingStatus) {
		Optional<Driving_Licenses> optional = driving_Licenses_Repo.findById(license_id);
		
		 if (optional.isPresent()) {
		        Driving_Licenses driving_Licenses2 = optional.get();
		        
		        if (driving_Licenses.getDrivingStatus() != null) {
		        	if("active".equals(drivingStatus)) {
		        		driving_Licenses2.setDrivingStatus(DrivingStatus.active);
		        	}else if("inactive".equals(drivingStatus)) {
		        		driving_Licenses2.setDrivingStatus(DrivingStatus.inactive);
		        	}
		        }
		        if (driving_Licenses.getRemark() != null) {
		        	driving_Licenses2.setRemark(driving_Licenses.getRemark());
		        }
		        return driving_Licenses_Repo.save(driving_Licenses2);
		 }     
		        
		return null;
	}
}

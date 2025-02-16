package com.example.RTO_ManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RTO_ManagementSystem.Dao.Driving_Licenses_Dao;
import com.example.RTO_ManagementSystem.Dao.User_Dao;
import com.example.RTO_ManagementSystem.Entity.Driving_Licenses;
import com.example.RTO_ManagementSystem.Entity.User_Entity;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class Driving_License_Controller 
{
    @Autowired
    Driving_Licenses_Dao driving_Licenses_Dao;
    
    @Autowired
    User_Dao user_Dao;
    
    
    @PostMapping("LicensesSaveData")
    public Driving_Licenses SaveData(@RequestBody Driving_Licenses driving_Licenses, @RequestParam("user_id") int user_id,@RequestParam(name = "status", required = false) String status,@RequestParam(name = "action", required = false) String action,@RequestParam(name = "role", required = false)  String role)
    {
    	User_Entity user_Entity  = user_Dao.findById(user_id);

        // Set the fetched user_Entity to the Driving_Licenses object
        driving_Licenses.setUser_Entity(user_Entity);
        
    	return driving_Licenses_Dao.SaveData(driving_Licenses,status,action, role);
    }
    
    
    @GetMapping("GetAllLicensesData")
    public List<Driving_Licenses> GetAllLicensesData() 
    {
    	return driving_Licenses_Dao.GetAllLicensesData();
    }
    
    @GetMapping("GetDataById")
    public Driving_Licenses GetIdByLicensesData(@RequestParam("license_id") int license_id)
    {
    	return driving_Licenses_Dao.GetDataById(license_id);
    }
    
}

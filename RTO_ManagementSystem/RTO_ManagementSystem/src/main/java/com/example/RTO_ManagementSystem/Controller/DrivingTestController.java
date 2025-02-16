package com.example.RTO_ManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RTO_ManagementSystem.Dao.DrivingTestDao;
import com.example.RTO_ManagementSystem.Dao.User_Dao;
import com.example.RTO_ManagementSystem.Entity.DrivingTestAppoinment;
import com.example.RTO_ManagementSystem.Entity.User_Entity;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class DrivingTestController 
{
     @Autowired 
     DrivingTestDao drivingTestDao;
     
     @Autowired
     User_Dao user_Dao;
     
     @PostMapping("DrivingAppoimentInsertData")
     public DrivingTestAppoinment DrivingAppoimentInsertData(@RequestBody DrivingTestAppoinment drivingTestAppoinment, @RequestParam("user_id") int user_id)
     {
      User_Entity user_Entity =	user_Dao.findById(user_id);
      drivingTestAppoinment.setUser_Entity(user_Entity);
      
      return drivingTestDao.DrivingAppoimentInsertDao(drivingTestAppoinment);
     }
     
     @GetMapping("AllDataDrivingTest")
     public List<DrivingTestAppoinment> AllDataDrivingTest()
     {
    	 return drivingTestDao.AllDataDrivingTest();
     }
     
     @GetMapping("DataAppoimentById")
     public DrivingTestAppoinment DataAppoimentById(@RequestParam("appointment_id") int appointment_id)
     {
    	 return drivingTestDao.DrivingAppoimentById(appointment_id);
     }
}

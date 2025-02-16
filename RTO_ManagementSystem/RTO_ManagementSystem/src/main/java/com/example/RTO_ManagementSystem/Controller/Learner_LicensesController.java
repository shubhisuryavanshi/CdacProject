package com.example.RTO_ManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RTO_ManagementSystem.Dao.Learner_LicensesDao;
import com.example.RTO_ManagementSystem.Dao.User_Dao;
import com.example.RTO_ManagementSystem.Entity.Learner_Licenses;
import com.example.RTO_ManagementSystem.Entity.User_Entity;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class Learner_LicensesController
{
     @Autowired
     Learner_LicensesDao learner_LicensesDao;
     
     @Autowired
     User_Dao user_Dao;
     
     @PostMapping("/SaveLearnerData")
     public Learner_Licenses SaveLearnerData(@RequestBody Learner_Licenses learner_Licenses, @RequestParam("user_id") int user_id)
     {
    	 User_Entity user_Entity = user_Dao.findById(user_id);  //user_Dao.findByUserId(user_id);
    	 learner_Licenses.setUser_Entity(user_Entity);
    	 return learner_LicensesDao.InsertLearningData(learner_Licenses);
     }
     
     @GetMapping("GetAllLearnerData")
     public List<Learner_Licenses> GetAllLearnerData()
     {
    	return learner_LicensesDao.AllLearnerData();
     }
}

package com.example.RTO_ManagementSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RTO_ManagementSystem.Entity.DrivingTestAppoinment;
import com.example.RTO_ManagementSystem.Entity.Learner_Licenses;
import com.example.RTO_ManagementSystem.Entity.TestStatus;
import com.example.RTO_ManagementSystem.Repo.DrivingAppoimentRepo;

@Repository
public class DrivingTestDao 
{
   @Autowired
   DrivingAppoimentRepo drivingAppoimentRepo;
   
   public DrivingTestAppoinment DrivingAppoimentInsertDao(DrivingTestAppoinment drivingTestAppoinment)
   {
	   return drivingAppoimentRepo.save(drivingTestAppoinment);
   }
   
   public List<DrivingTestAppoinment> AllDataDrivingTest()
   {
	   return drivingAppoimentRepo.findAll();
   }
   
   public DrivingTestAppoinment DrivingAppoimentById(int appointment_id)
   {
	   return drivingAppoimentRepo.findById(appointment_id).get();
   }
   
   public DrivingTestAppoinment UpdateDrivingTestFromAdmin(int appointment_id,
			DrivingTestAppoinment drivingTestAppoinment,String testStatus) {
		Optional<DrivingTestAppoinment> optional = drivingAppoimentRepo.findById(appointment_id);
		
		 if (optional.isPresent()) {
			 DrivingTestAppoinment drivingTestAppoinment2 = optional.get();
		        
		        if (drivingTestAppoinment.getTestStatus() != null) {
		              if ("Scheduled".equals(testStatus)) {
		            	  drivingTestAppoinment2.setTestStatus(TestStatus.Scheduled);
		              }else if ("Completed".equals(testStatus)) {
		            	  drivingTestAppoinment2.setTestStatus(TestStatus.Completed);
		              } else if ("Cancelled".equals(testStatus)) {
		            	  drivingTestAppoinment2.setTestStatus(TestStatus.Cancelled);
		              }
		              if (drivingTestAppoinment.getRemark() != null) {
				        	drivingTestAppoinment2.setRemark(drivingTestAppoinment.getRemark());
				        }      
		        }
		        return drivingAppoimentRepo.save(drivingTestAppoinment2);
		 }     
		        
		return null;
}
}

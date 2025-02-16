package com.example.RTO_ManagementSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RTO_ManagementSystem.Entity.DrivingStatus;
import com.example.RTO_ManagementSystem.Entity.Driving_Licenses;
import com.example.RTO_ManagementSystem.Entity.LearnerStatus;
import com.example.RTO_ManagementSystem.Entity.Learner_Licenses;
import com.example.RTO_ManagementSystem.Repo.Learner_LicensesRepo;

@Repository
public class Learner_LicensesDao
{
       @Autowired
       Learner_LicensesRepo learner_LicensesRepo;
       
       public  Learner_Licenses InsertLearningData(Learner_Licenses learner_Licenses)
       {
    		  learner_Licenses.setLearnerStatus(LearnerStatus.inactive);  
    	       return  learner_LicensesRepo.save(learner_Licenses);
       }
       
       
//       public Learner_Licenses SaveLearnerDataDao(Learner_Licenses learner_Licenses)
//       {
//    	   learner_Licenses.setLearnerStatus(LearnerStatus.active);
//    	  return learner_LicensesRepo.save(learner_Licenses);
//       }
//       
       
       
       public List<Learner_Licenses> AllLearnerData()
       {
    	  return learner_LicensesRepo.findAll();
       }


	public Learner_Licenses UpdateLearner_LicanseFromAdmin(int learner_id, Learner_Licenses learner_Licenses,String learningStatus) {
		Optional<Learner_Licenses> optional = learner_LicensesRepo.findById(learner_id);
		
		 if (optional.isPresent()) {
			 Learner_Licenses learner_Licenses2 = optional.get();
		        
		        if (learner_Licenses.getLearnerStatus() != null) {
		        	if("active".equals(learningStatus)) {
		        		learner_Licenses2.setLearnerStatus(LearnerStatus.active);
		        	}else if("inactive".equals(learningStatus)) {
		        		learner_Licenses2.setLearnerStatus(LearnerStatus.inactive);
		        	}
		        }
		        if (learner_Licenses.getRemark() != null) {
		        	learner_Licenses2.setRemark(learner_Licenses.getRemark());
		        }
		        return learner_LicensesRepo.save(learner_Licenses2);
		 }     
		        
		return null;
	}
}

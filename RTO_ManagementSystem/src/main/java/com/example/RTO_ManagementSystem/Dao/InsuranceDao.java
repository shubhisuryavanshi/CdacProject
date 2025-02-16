package com.example.RTO_ManagementSystem.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RTO_ManagementSystem.Entity.InsuranceEntity;
import com.example.RTO_ManagementSystem.Repo.InsuranceRepo;

@Repository
public class InsuranceDao {
	
   @Autowired
   InsuranceRepo insuranceRepo;

public InsuranceEntity InsuranceSaveData(InsuranceEntity insuranceEntity) {
	return insuranceRepo.save(insuranceEntity);
}

public InsuranceEntity GetByInsuranceId(int insurance_id) {
	return insuranceRepo.findById(insurance_id).get();
}

public List<InsuranceEntity> GetAllInsuranceData() {
	return insuranceRepo.findAll();
}

}

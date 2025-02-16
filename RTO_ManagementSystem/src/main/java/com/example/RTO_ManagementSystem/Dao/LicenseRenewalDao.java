package com.example.RTO_ManagementSystem.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RTO_ManagementSystem.Entity.LicenseRenewal;
import com.example.RTO_ManagementSystem.Entity.LicenserRenewalStatus;
import com.example.RTO_ManagementSystem.Entity.Payment;
import com.example.RTO_ManagementSystem.Repo.LicenseRenewalRepo;

@Repository
public class LicenseRenewalDao 
{
   @Autowired
   LicenseRenewalRepo licenseRenewalRepo;
   
   public LicenseRenewal SaveLicenseRenewalData(LicenseRenewal licenseRenewal, int user_id,int license_id, int payment_id) {
	   return licenseRenewalRepo.save(licenseRenewal);
   }
   
   public List<LicenseRenewal> AllDataLicenseRenewal(){
	   return licenseRenewalRepo.findAll();
   }
   
   public LicenseRenewal FindByIdLicenseRenewal(int renewal_id){
	   return licenseRenewalRepo.findById(renewal_id).get();
   }

public LicenseRenewal UpdateLicenseRenewalFromAdmin(int renewal_id, LicenseRenewal licenseRenewal,
		String licenserRenewalStatus) {
	if("Pending".equals(licenserRenewalStatus)){
		licenseRenewal.setLicenserRenewalStatus(LicenserRenewalStatus.Pending);
	}if("Completed".equals(licenserRenewalStatus)){
		licenseRenewal.setLicenserRenewalStatus(LicenserRenewalStatus.Completed);
	}if("Approved".equals(licenserRenewalStatus)){
		licenseRenewal.setLicenserRenewalStatus(LicenserRenewalStatus.Approved);
	}
	return licenseRenewalRepo.save(licenseRenewal);
}
}

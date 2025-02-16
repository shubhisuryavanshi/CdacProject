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
import com.example.RTO_ManagementSystem.Dao.LicenseRenewalDao;
import com.example.RTO_ManagementSystem.Dao.PaymentDao;
import com.example.RTO_ManagementSystem.Dao.User_Dao;
import com.example.RTO_ManagementSystem.Entity.Driving_Licenses;
import com.example.RTO_ManagementSystem.Entity.LicenseRenewal;
import com.example.RTO_ManagementSystem.Entity.Payment;
import com.example.RTO_ManagementSystem.Entity.User_Entity;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class LicenseRenewalController 
{
    @Autowired
    LicenseRenewalDao licenseRenewalDao;
    
    @Autowired
    User_Dao user_Dao;
    
    @Autowired
    Driving_Licenses_Dao driving_Licenses_Dao;
    
    @Autowired
    PaymentDao paymentDao;
    
    @PostMapping("LicenseRenewalDataSave")
    public LicenseRenewal LicenseRenewalDataSave(@RequestBody LicenseRenewal licenseRenewal, @RequestParam("user_id") int user_id, @RequestParam("license_id") int license_id,@RequestParam("payment_id") int payment_id)
    {
      User_Entity user_Entity =	user_Dao.findById(user_id);
      licenseRenewal.setUser_Entity(user_Entity);
    	
      Driving_Licenses driving_Licenses =   driving_Licenses_Dao.GetDataById(license_id);
      licenseRenewal.setDriving_Licenses(driving_Licenses);
      
      Payment payment =  paymentDao.findByPaymentId(payment_id);
      licenseRenewal.setPayment(payment);
      	
    	return licenseRenewalDao.SaveLicenseRenewalData(licenseRenewal, user_id, license_id, payment_id);
    					
    }
    
    @GetMapping("AllDataLicenseRenewal")
    public List<LicenseRenewal> AllDataLicenseRenewal()
    {
    	return licenseRenewalDao.AllDataLicenseRenewal();
    }
    
    @GetMapping("FindByIdLicenseRenewal")
    public LicenseRenewal FindByIdLicenseRenewal(@RequestParam("renewal_id") int renewal_id)
    {
    	return licenseRenewalDao.FindByIdLicenseRenewal(renewal_id);
    }
}

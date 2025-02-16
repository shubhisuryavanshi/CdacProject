package com.example.RTO_ManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RTO_ManagementSystem.Dao.PaymentDao;
import com.example.RTO_ManagementSystem.Dao.User_Dao;
import com.example.RTO_ManagementSystem.Entity.Payment;
import com.example.RTO_ManagementSystem.Entity.User_Entity;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class PaymentController 
{
   @Autowired
   PaymentDao paymentDao;
   
   @Autowired
   User_Dao user_Dao;
   
   @PostMapping("SavePaymentData")
   public Payment SavePaymentData(@RequestBody Payment payment,@RequestParam("user_id") int user_id, @RequestParam(name="Payment_Method", required=false) String Payment_Method)
   {
	   User_Entity user_Entity = user_Dao.findById(user_id);
	   payment.setUser_Entity(user_Entity);
	    
	   return paymentDao.SavePaymentDataDao(payment, Payment_Method);
   }
   
   
}

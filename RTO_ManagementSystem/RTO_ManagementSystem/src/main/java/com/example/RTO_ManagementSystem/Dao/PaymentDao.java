package com.example.RTO_ManagementSystem.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RTO_ManagementSystem.Entity.Payment;
import com.example.RTO_ManagementSystem.Entity.PaymentMethod;
import com.example.RTO_ManagementSystem.Repo.PaymentRepo;

@Repository
public class PaymentDao 
{
  @Autowired
  PaymentRepo paymentRepo;
  
  public Payment SavePaymentDataDao(Payment payment, String Payment_Method)
  {
	  if("Cash".equals(Payment_Method))
	  {
		 payment.setPaymentMethod(PaymentMethod.Cash);
	  }else if("Card".equals(Payment_Method))
	  {
		  payment.setPaymentMethod(PaymentMethod.Card);
	  }else if("Online".equals(Payment_Method))
	  {
		  payment.setPaymentMethod(PaymentMethod.Online);
	  }
	  
	  return paymentRepo.save(payment);
  }
  
  
  
  public List<Payment> GetAllPaymentData(){
	  return paymentRepo.findAll();
  }
  
  
  
  
  
	  public Payment findByPaymentId(int Payment_id){
		  return paymentRepo.findById(Payment_id).get();
	  }
}

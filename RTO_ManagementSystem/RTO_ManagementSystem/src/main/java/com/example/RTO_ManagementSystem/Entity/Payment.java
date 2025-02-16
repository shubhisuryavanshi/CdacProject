package com.example.RTO_ManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int payment_id;
   
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false) 
   private User_Entity user_Entity;
   
   private String payment_amount;
   
   private String payment_date;
   
   @Enumerated(EnumType.STRING)
   private PaymentMethod paymentMethod;
   
   private int transaction_id;
   
   private String service_name;
   
   private String Payment_Status;

public int getPayment_id() {
	return payment_id;
}

public void setPayment_id(int payment_id) {
	this.payment_id = payment_id;
}

public User_Entity getUser_Entity() {
	return user_Entity;
}

public void setUser_Entity(User_Entity user_Entity) {
	this.user_Entity = user_Entity;
}

public String getPayment_amount() {
	return payment_amount;
}

public void setPayment_amount(String payment_amount) {
	this.payment_amount = payment_amount;
}

public String getPayment_date() {
	return payment_date;
}

public void setPayment_date(String payment_date) {
	this.payment_date = payment_date;
}

public PaymentMethod getPaymentMethod() {
	return paymentMethod;
}

public void setPaymentMethod(PaymentMethod paymentMethod) {
	this.paymentMethod = paymentMethod;
}

public int getTransaction_id() {
	return transaction_id;
}

public void setTransaction_id(int transaction_id) {
	this.transaction_id = transaction_id;
}

public String getPayment_Status() {
	return Payment_Status;
}

public void setPayment_Status(String payment_Status) {
	Payment_Status = payment_Status;
}


public String getService_name() {
	return service_name;
}

public void setService_name(String service_name) {
	this.service_name = service_name;
}

public Payment(int payment_id, User_Entity user_Entity, String payment_amount, String payment_date,
		PaymentMethod paymentMethod, int transaction_id, String payment_Status) {
	super();
	this.payment_id = payment_id;
	this.user_Entity = user_Entity;
	this.payment_amount = payment_amount;
	this.payment_date = payment_date;
	this.paymentMethod = paymentMethod;
	this.transaction_id = transaction_id;
	Payment_Status = payment_Status;
}

@Override
public String toString() {
	return "Payment [payment_id=" + payment_id + ", user_Entity=" + user_Entity + ", payment_amount=" + payment_amount
			+ ", payment_date=" + payment_date + ", paymentMethod=" + paymentMethod + ", transaction_id="
			+ transaction_id + ", Payment_Status=" + Payment_Status + "]";
}

public Payment() {
	super();
	// TODO Auto-generated constructor stub
}

   
   
}

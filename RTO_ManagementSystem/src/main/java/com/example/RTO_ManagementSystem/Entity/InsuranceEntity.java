package com.example.RTO_ManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InsuranceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insurance_id;
	
	private String vehicle_id;
	
    @ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
    private User_Entity user_Entity;
	    
	
	private String insurance_company;
	
	private String policy_number;
	
	private String expiry_date;
	
	private Double premium_amount;

	public int getInsurance_id() {
		return insurance_id;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public String getInsurance_company() {
		return insurance_company;
	}

	public String getPolicy_number() {
		return policy_number;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public Double getPremium_amount() {
		return premium_amount;
	}

	public void setInsurance_id(int insurance_id) {
		this.insurance_id = insurance_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public void setInsurance_company(String insurance_company) {
		this.insurance_company = insurance_company;
	}

	public void setPolicy_number(String policy_number) {
		this.policy_number = policy_number;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public void setPremium_amount(Double premium_amount) {
		this.premium_amount = premium_amount;
	}

	public User_Entity getUser_Entity() {
		return user_Entity;
	}

	public void setUser_Entity(User_Entity user_Entity) {
		this.user_Entity = user_Entity;
	}
	
	
	

}

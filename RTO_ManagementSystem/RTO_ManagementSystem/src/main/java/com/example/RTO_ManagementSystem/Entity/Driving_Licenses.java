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
public class Driving_Licenses
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int license_id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Creates foreign key
    private User_Entity user_Entity;
    
    @Enumerated(EnumType.STRING)
    private License_Type license_Type;
    
    private String issue_date;
    
    private String expiry_date;
    
    private long license_number;
    
    @Enumerated(EnumType.STRING)
    private Vehicle_Type vehicle_Type;
    
    @Enumerated(EnumType.STRING)
    private DrivingStatus drivingStatus;
    
    private String remark;

	public int getLicense_id() {
		return license_id;
	}

	public void setLicense_id(int license_id) {
		this.license_id = license_id;
	}

	public User_Entity getUser_Entity() {
		return user_Entity;
	}

	public void setUser_Entity(User_Entity user_Entity) {
		this.user_Entity = user_Entity;
	}

	public License_Type getLicense_Type() {
		return license_Type;
	}

	public void setLicense_Type(License_Type license_Type) {
		this.license_Type = license_Type;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public long getLicense_number() {
		return license_number;
	}

	public void setLicense_number(long license_number) {
		this.license_number = license_number;
	}

	public Vehicle_Type getVehicle_Type() {
		return vehicle_Type;
	}

	public void setVehicle_Type(Vehicle_Type vehicle_Type) {
		this.vehicle_Type = vehicle_Type;
	}

	public DrivingStatus getDrivingStatus() {
		return drivingStatus;
	}

	public void setDrivingStatus(DrivingStatus drivingStatus) {
		this.drivingStatus = drivingStatus;
	}

	
	
	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Driving_Licenses [license_id=" + license_id + ", user_Entity=" + user_Entity + ", license_Type="
				+ license_Type + ", issue_date=" + issue_date + ", expiry_date=" + expiry_date + ", license_number="
				+ license_number + ", vehicle_Type=" + vehicle_Type + ", drivingStatus=" + drivingStatus
				+ ", getLicense_id()=" + getLicense_id() + ", getUser_Entity()=" + getUser_Entity()
				+ ", getLicense_Type()=" + getLicense_Type() + ", getIssue_date()=" + getIssue_date()
				+ ", getExpiry_date()=" + getExpiry_date() + ", getLicense_number()=" + getLicense_number()
				+ ", getVehicle_Type()=" + getVehicle_Type() + ", getDrivingStatus()=" + getDrivingStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Driving_Licenses(int license_id, User_Entity user_Entity, License_Type license_Type, String issue_date,
			String expiry_date, long license_number, Vehicle_Type vehicle_Type, DrivingStatus drivingStatus) {
		super();
		this.license_id = license_id;
		this.user_Entity = user_Entity;
		this.license_Type = license_Type;
		this.issue_date = issue_date;
		this.expiry_date = expiry_date;
		this.license_number = license_number;
		this.vehicle_Type = vehicle_Type;
		this.drivingStatus = drivingStatus;
	}

	public Driving_Licenses() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    


    
    
    
    
    
}

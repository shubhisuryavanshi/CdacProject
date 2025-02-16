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
public class VehicleRegistrationEntity {
	
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int registrationId;
	    
	    private String vehicle_id;
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
	    private User_Entity user_Entity;
	    
	    private String registrationDate;
	    
	    private String expiryDate;
	    
	    private String registrationNumber;
	    
	    @Enumerated(EnumType.STRING)
	    private VehicleRegistrationStatus registrationStatus; // active/inactive

		public int getRegistrationId() {
			return registrationId;
		}

		public String getVehicle_id() {
			return vehicle_id;
		}

		public User_Entity getUser_Entity() {
			return user_Entity;
		}

		public String getRegistrationDate() {
			return registrationDate;
		}

		public String getExpiryDate() {
			return expiryDate;
		}

		public String getRegistrationNumber() {
			return registrationNumber;
		}

		public VehicleRegistrationStatus getRegistrationStatus() {
			return registrationStatus;
		}

		public void setRegistrationId(int registrationId) {
			this.registrationId = registrationId;
		}

		public void setVehicle_id(String vehicle_id) {
			this.vehicle_id = vehicle_id;
		}

		public void setUser_Entity(User_Entity user_Entity) {
			this.user_Entity = user_Entity;
		}

		public void setRegistrationDate(String registrationDate) {
			this.registrationDate = registrationDate;
		}

		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}

		public void setRegistrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
		}

		public void setRegistrationStatus(VehicleRegistrationStatus registrationStatus) {
			this.registrationStatus = registrationStatus;
		}
	    
	    
	    

}

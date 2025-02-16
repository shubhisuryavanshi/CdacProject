package com.example.RTO_ManagementSystem.Entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class LicenseRenewal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int renewal_id;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Correct way to define foreign key
    private User_Entity user_Entity;

    @ManyToOne
    @JoinColumn(name = "license_id")  // Correct way to define foreign key
    private Driving_Licenses driving_Licenses;

    private LocalDate renewal_date;
    private LocalDate expiry_date;

    @Enumerated(EnumType.STRING)
    private LicenserRenewalStatus licenserRenewalStatus;

    @ManyToOne
    @JoinColumn(name = "payment_id")  // Correct way to define foreign key
    private Payment payment;

	public int getRenewal_id() {
		return renewal_id;
	}

	public void setRenewal_id(int renewal_id) {
		this.renewal_id = renewal_id;
	}

	public User_Entity getUser_Entity() {
		return user_Entity;
	}

	public void setUser_Entity(User_Entity user_Entity) {
		this.user_Entity = user_Entity;
	}

	public Driving_Licenses getDriving_Licenses() {
		return driving_Licenses;
	}

	public void setDriving_Licenses(Driving_Licenses driving_Licenses) {
		this.driving_Licenses = driving_Licenses;
	}

	public LocalDate getRenewal_date() {
		return renewal_date;
	}

	public void setRenewal_date(LocalDate renewal_date) {
		this.renewal_date = renewal_date;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}

	public LicenserRenewalStatus getLicenserRenewalStatus() {
		return licenserRenewalStatus;
	}

	public void setLicenserRenewalStatus(LicenserRenewalStatus licenserRenewalStatus) {
		this.licenserRenewalStatus = licenserRenewalStatus;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
    
    
}

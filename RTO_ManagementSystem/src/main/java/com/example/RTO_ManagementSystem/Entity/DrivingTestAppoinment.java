package com.example.RTO_ManagementSystem.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DrivingTestAppoinment
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int appointment_id;
   
	@ManyToOne
	@JoinColumn(name ="user_id",  nullable = false)
	private User_Entity user_Entity;
   
   private LocalDate test_date;   // year-month-day
   
   private LocalTime test_time;   // Hour-minute-second
   
   private String test_type;
   
   private String location;
   
   private String instructor_name;
   
   @Column(name="status")
   private TestStatus testStatus;
   
   private String remark;
   

public int getAppointment_id() {
	return appointment_id;
}

public void setAppointment_id(int appointment_id) {
	this.appointment_id = appointment_id;
}

public User_Entity getUser_Entity() {
	return user_Entity;
}

public void setUser_Entity(User_Entity user_Entity) {
	this.user_Entity = user_Entity;
}

public LocalDate getTest_date() {
	return test_date;
}

public void setTest_date(LocalDate test_date) {
	this.test_date = test_date;
}

public LocalTime getTest_time() {
	return test_time;
}

public void setTest_time(LocalTime test_time) {
	this.test_time = test_time;
}

public String getTest_type() {
	return test_type;
}

public void setTest_type(String test_type) {
	this.test_type = test_type;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getInstructor_name() {
	return instructor_name;
}

public void setInstructor_name(String instructor_name) {
	this.instructor_name = instructor_name;
}

public TestStatus getTestStatus() {
	return testStatus;
}

public void setTestStatus(TestStatus testStatus) {
	this.testStatus = testStatus;
}

public String getRemark() {
	return remark;
}

public void setRemark(String remark) {
	this.remark = remark;
}

   

   
   
}

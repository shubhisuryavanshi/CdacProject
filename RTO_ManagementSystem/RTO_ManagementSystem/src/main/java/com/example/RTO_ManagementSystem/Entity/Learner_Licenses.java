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
public class Learner_Licenses 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int learner_id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User_Entity user_Entity;
    
    private String issue_date;
    
    private String expiry_date;
    
    @Enumerated(EnumType.STRING)
    private LearnerStatus learnerStatus;
    
    private String remark;

	public int getLearner_id() {
		return learner_id;
	}

	public void setLearner_id(int learner_id) {
		this.learner_id = learner_id;
	}

	public User_Entity getUser_Entity() {
		return user_Entity;
	}

	public void setUser_Entity(User_Entity user_Entity) {
		this.user_Entity = user_Entity;
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

	public LearnerStatus getLearnerStatus() {
		return learnerStatus;
	}

	public void setLearnerStatus(LearnerStatus learnerStatus) {
		this.learnerStatus = learnerStatus;
	}

	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Learner_Licenses [learner_id=" + learner_id + ", user_Entity=" + user_Entity + ", issue_date="
				+ issue_date + ", expiry_date=" + expiry_date + ", learnerStatus=" + learnerStatus
				+ ", getLearner_id()=" + getLearner_id() + ", getUser_Entity()=" + getUser_Entity()
				+ ", getIssue_date()=" + getIssue_date() + ", getExpiry_date()=" + getExpiry_date()
				+ ", getLearnerStatus()=" + getLearnerStatus() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Learner_Licenses(int learner_id, User_Entity user_Entity, String issue_date, String expiry_date,
			LearnerStatus learnerStatus) {
		super();
		this.learner_id = learner_id;
		this.user_Entity = user_Entity;
		this.issue_date = issue_date;
		this.expiry_date = expiry_date;
		this.learnerStatus = learnerStatus;
	}

	public Learner_Licenses() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}

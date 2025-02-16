package com.example.RTO_ManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RTO_ManagementSystem.Entity.DrivingTestAppoinment;

public interface DrivingAppoimentRepo extends JpaRepository<DrivingTestAppoinment, Integer>
{

}

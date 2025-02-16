package com.example.RTO_ManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.RTO_ManagementSystem.Entity.VehicleRegistrationEntity;
import java.util.List;


public interface VehicleRegistrationRepo extends JpaRepository<VehicleRegistrationEntity, Integer>
{
	@Query(value = "SELECT * FROM rtodb.vehicle_registration_entity WHERE user_id = :user_id", nativeQuery = true)
	public VehicleRegistrationEntity findById(@Param("user_id") int user_id);


}

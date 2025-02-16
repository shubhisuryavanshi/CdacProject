package com.example.RTO_ManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RTO_ManagementSystem.Entity.User_Entity;

public interface User_Repo extends JpaRepository<User_Entity, Integer>
{

	public User_Entity findByUsernameAndPassword(String username, String password);

}

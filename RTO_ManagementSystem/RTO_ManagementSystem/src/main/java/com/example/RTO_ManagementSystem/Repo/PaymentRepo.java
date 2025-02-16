package com.example.RTO_ManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RTO_ManagementSystem.Entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>
{

}

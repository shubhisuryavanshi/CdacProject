package com.example.RTO_ManagementSystem.Dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.RTO_ManagementSystem.Entity.LicenseStatus;
import com.example.RTO_ManagementSystem.Entity.UserStatus;
import com.example.RTO_ManagementSystem.Entity.User_Entity;
import com.example.RTO_ManagementSystem.Repo.User_Repo;

@Repository
public class User_Dao {
	
	@Autowired
	User_Repo user_Repo;
	
	public User_Entity SaveDataDao(User_Entity user_Entity) {
		user_Entity.setStatus(UserStatus.Active);
		user_Entity.setLicenseStatus(LicenseStatus.Pending);
		return user_Repo.save(user_Entity);
	}

	public User_Entity findByUsernameAndPassword(String username, String password) {
		return user_Repo.findByUsernameAndPassword(username, password);
	}

	
	
	public User_Entity UpdateProfile(int id, User_Entity user_Entity) {
	    Optional<User_Entity> optional = user_Repo.findById(id);
	    
	
	    
	    
	    if (optional.isPresent()) {
	        User_Entity user_Entity2 = optional.get();
	        
	       

	        if (user_Entity.getUsername() != null) {
	            user_Entity2.setUsername(user_Entity.getUsername());
	        }
	        if (user_Entity.getPassword() != null) {
	            user_Entity2.setPassword(user_Entity.getPassword());
	        }
	        if (user_Entity.getFirstName() != null) {
	            user_Entity2.setFirstName(user_Entity.getFirstName());
	        }
	        if (user_Entity.getMiddleName() != null) {
	            user_Entity2.setMiddleName(user_Entity.getMiddleName());
	        }
	        if (user_Entity.getLastName() != null) {
	            user_Entity2.setLastName(user_Entity.getLastName());
	        }
	        if (user_Entity.getEmail() != null) {
	            user_Entity2.setEmail(user_Entity.getEmail());
	        }
	        if (user_Entity.getPhoneNumber() != null) {
	            user_Entity2.setPhoneNumber(user_Entity.getPhoneNumber());
	        }
	        if (user_Entity.getAddress() != null) {
	            user_Entity2.setAddress(user_Entity.getAddress());
	        }
	        if (user_Entity.getStatus() != null) {
	            user_Entity2.setStatus(user_Entity.getStatus());
	        }
	        if (user_Entity.getDob() != null) {
	            user_Entity2.setDob(user_Entity.getDob());
	        }
	        if (user_Entity.getBloodGroup() != null) {
	            user_Entity2.setBloodGroup(user_Entity.getBloodGroup());
	        }
	      

	        return user_Repo.save(user_Entity2); // Save the updated entity and return it
	    }
	    return null; // Return null if user not found
	}


	

	
	public User_Entity findById(int user_id) {
		return user_Repo.findById(user_id).get();
		
	}

	public List<User_Entity> GetAllUser() {
		return user_Repo.findAll();
	}


}

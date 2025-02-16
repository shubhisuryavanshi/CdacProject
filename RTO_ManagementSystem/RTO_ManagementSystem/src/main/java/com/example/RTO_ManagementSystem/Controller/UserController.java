package com.example.RTO_ManagementSystem.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.RTO_ManagementSystem.Dao.User_Dao;
import com.example.RTO_ManagementSystem.Entity.User_Entity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class UserController {
	
	@Autowired
	User_Dao user_Dao;
	
	
	@PostMapping("/SaveData")
	public User_Entity SaveData(@RequestBody User_Entity user_Entity) {
		return user_Dao.SaveDataDao(user_Entity);
	}
	
	@GetMapping("/Login")
	public User_Entity login(@RequestParam String username, @RequestParam String password) {
	    return user_Dao.findByUsernameAndPassword(username, password);
	}
	
	
	@PutMapping("UpdateProfile/{id}")  // Use lowercase "id"
	public User_Entity UpdateProfile(@PathVariable int id, @RequestBody User_Entity user_Entity )  {
		 User_Entity UpdateProfile = user_Dao.UpdateProfile(id, user_Entity);
		return UpdateProfile;
		 
	}
        
	@GetMapping("/findById")
	public User_Entity findById(@RequestParam("user_id") int user_id) {
		return user_Dao.findById(user_id) ;
	}
	
	@GetMapping("/GetAllUser")
	public List<User_Entity> GetAllUser() {
		return user_Dao.GetAllUser();
	}
	
	

}

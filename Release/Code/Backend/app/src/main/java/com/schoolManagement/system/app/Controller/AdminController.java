package com.schoolManagement.system.app.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolManagement.system.app.Model.Admin;
import com.schoolManagement.system.app.Repository.AdminRepository;

@CrossOrigin(origins = { "*","http://localhost:1234", "http://localhost:3000" })
@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminRepository repository;
	
	@PostMapping("/")
	public Map<String, String> createAdmin(@Valid @RequestBody Admin admin) {
		HashMap<String, String> map = new HashMap<>();
		if (repository.findByuserName(admin.getUserName()) == null) {
			repository.save(admin);
			map.put("status", "200");
			map.put("message", "Admin Registered Succesfully !");
		} else {
			map.put("status", "500");
			map.put("message", "Username is Already Taken !");
		}
		return map;
	}
	
	@GetMapping("/")
	public List<Admin> getAllAdmins() {
		return repository.findAll();
	}
}

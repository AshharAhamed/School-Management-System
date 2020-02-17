package com.schoolManagement.system.app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.schoolManagement.system.app.Model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
	public Admin findByuserName(String userName);
}

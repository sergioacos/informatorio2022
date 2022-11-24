package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Organization;
import com.example.demo.repository.IUserRepository;
@Service
public class ServiceImplement implements IUserRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceImplement.class);
	
	public Organization findByNameOrganization(String NameOrganization) {
		return 
	}
 @Autowired
 private IUserRepository userRepository;
 
 public Organization save(Organization, organization) {
	 return userRepository.save(organization);
 }
 
}

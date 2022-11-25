package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Organization;

public interface IOrganService {
	
 public List<Organization> getAll();
 
 public Organization save(Organization organization);
}

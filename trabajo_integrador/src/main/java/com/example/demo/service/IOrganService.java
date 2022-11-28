package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrganDto;
import com.example.demo.entity.Organization;

public interface IOrganService {
	
 public List<Organization> getAll();
 
 public OrganDto save(OrganDto organizationDto);
 
 public Organization findByNameOrganization(String nameOrganization);
}

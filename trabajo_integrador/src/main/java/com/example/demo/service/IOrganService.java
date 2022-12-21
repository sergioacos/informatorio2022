package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrganDto;
import com.example.demo.entity.Organization;

public interface IOrganService {
	
 public List<OrganDto> getAll();
 
 public List<OrganDto> findByActiveTrue();
 
 public OrganDto update(OrganDto organizationDto);
 
 public OrganDto save(OrganDto organizationDto);
 
 public OrganDto findByNameOrganizationAndActiveTrue(String nameOrganization);
 
 public OrganDto findByCuitOrganization(Long cuitOrganization);
 
 public Organization findById(Long id);

public void deleteOrgan(Organization deleteorgan);

}

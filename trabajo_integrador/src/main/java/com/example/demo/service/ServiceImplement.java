package com.example.demo.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrganDto;
import com.example.demo.entity.Organization;
import com.example.demo.repository.IUserRepository;
import com.example.demo.wrapper.OrganWrapper;

@Service
public class ServiceImplement implements IOrganService{
	
	
	
	//public Organization findByNameOrganization(String NameOrganization) {
		//return 
	//}
 @Autowired
 private IUserRepository userRepository;
 

@Override
public List<Organization> getAll() {
	// TODO Auto-generated method stub
	return userRepository.findAll();
}

@Override
public OrganDto save(OrganDto organizationDto) {
	Organization organization = OrganWrapper.dtoToEntity(organizationDto);
	organizationDto = OrganWrapper.entityToDto(userRepository.save(organization));
	return organizationDto;
}

@Override
public Organization findByNameOrganization(String nameOrganization) {
	// TODO Auto-generated method stub
	return null;
}}

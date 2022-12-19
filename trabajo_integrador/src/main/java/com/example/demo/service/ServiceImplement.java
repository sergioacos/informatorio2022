package com.example.demo.service;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrganDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Organization;
import com.example.demo.repository.IAddressRepository;
import com.example.demo.repository.IOrganRepository;
import com.example.demo.wrapper.OrganWrapper;

@Service
public class ServiceImplement implements IOrganService{
	
	
	
	//public Organization findByNameOrganization(String NameOrganization) {
		//return 
	//}
 @Autowired
 private IOrganRepository organRepository;
 
 @Autowired
 private IAddressRepository addressRepository;
 
@Transactional
@Override
public List<Organization> getAll() {
	// TODO Auto-generated method stub
	return organRepository.findByActiveTrue();
}

@Override
public OrganDto save(OrganDto organizationDto) {
	Organization organization = OrganWrapper.dtoToEntity(organizationDto);
	organization.setReleaseDate((LocalDateTime.now()));
	organization.setActive(true);
	
	organizationDto = OrganWrapper.entityToDto(organRepository.save(organization));
	Address address=organization.getAddressOrganization();
	address.setOrganization(organization);
	addressRepository.save(address);
	return organizationDto;
}

@Override
public Organization findByNameOrganization(String nameOrganization) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public OrganDto findByCuitOrganization(BigInteger cuitOrganization) {
	// TODO Auto-generated method stub
	Organization organ= organRepository.findByCuitOrganization(cuitOrganization);
	OrganDto organDTo= OrganWrapper.entityToDto(organ);
	return organDTo;
}

@Override
public Organization findById(Long id) {
	// TODO Auto-generated method stub
	 Organization organ =organRepository.findById(id).orElse(null);
	return organ;
}

@Override
public void deleteOrgan(Organization deleteorgan) {
	// TODO Auto-generated method stub
	deleteorgan.setActive(false);
	organRepository.save(deleteorgan);
}


}

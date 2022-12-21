package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
	
	
	
 @Autowired
 private IOrganRepository organRepository;
 
 @Autowired
 private IAddressRepository addressRepository;
 
@Transactional
@Override
public List<OrganDto> getAll() {
	List<Organization>organizations=organRepository.findByActiveTrue();
	List<OrganDto>listaDto= new ArrayList();
	for (Organization e:organizations) {
		OrganDto organ= OrganWrapper.entityToDto(e);
		listaDto.add(organ);
	}
	return listaDto;
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
public OrganDto findByNameOrganizationAndActiveTrue(String nameOrganization) {
	Organization organ= organRepository.findByNameOrganizationAndActiveTrue(nameOrganization);
	OrganDto organDTo= OrganWrapper.entityToDto(organ);
	return organDTo;
	
}

@Override
public OrganDto findByCuitOrganization(Long cuitOrganization) {
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

@Override
public List<OrganDto> findByActiveTrue() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public OrganDto update(OrganDto organizationDto) {
	Organization organexist= organRepository.findByCuitOrganization(organizationDto.getCuitOrganization());
	if (organexist!=null) {
		Organization organPersist= new Organization();
		organPersist.setCuitOrganization(organexist.getCuitOrganization());
		organPersist.setAddressOrganization(organexist.getAddressOrganization());
		organPersist.setNameOrganization(organexist.getNameOrganization());
		organPersist.setKey_organization(organexist.getKey_organization());
		organPersist.setTelephoneNumber(organexist.getTelephoneNumber());
		organPersist.setEmailOrganization(organexist.getEmailOrganization());
		
		organexist=organRepository.save(organPersist);
		organizationDto= OrganWrapper.entityToDto(organexist);
		
		return organizationDto;
	}
	return null;
}


}

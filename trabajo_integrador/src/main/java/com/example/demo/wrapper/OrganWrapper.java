package com.example.demo.wrapper;

import com.example.demo.dto.OrganDto;
import com.example.demo.entity.Organization;

public class OrganWrapper {
 public static Organization dtoToEntity(OrganDto organDto) {
	 if(organDto == null)return new Organization();
	 
	 Organization entity = new Organization();
	 entity.setNameOrganization(organDto.getNameOrganization());
	 entity.setCuitOrganization(organDto.getCuitOrganization());
	 entity.setReleaseDate(organDto.getReleaseDate());
	 entity.setAddressOrganization(organDto.getAddressOrganization());
	 entity.setEvents(organDto.getEvents());
	 entity.setEmailOrganization(organDto.getEmailOrganization());
	 
	  return entity;
 }
 
 public static OrganDto entityToDto(Organization entity) {
	 if(entity == null)return new OrganDto();
	 OrganDto organDto = new OrganDto();
	 organDto.setNameOrganization(entity.getNameOrganization());
	 organDto.setCuitOrganization(entity.getCuitOrganization());
	 organDto.setReleaseDate(entity.getReleaseDate());
	 organDto.setAddressOrganization(entity.getAddressOrganization());
	 organDto.setEvents(entity.getEvents());
	 entity.setEmailOrganization(entity.getEmailOrganization());
	 
	  return organDto;
 }
}

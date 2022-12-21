package com.example.demo.controller;

import java.security.KeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrganDto;
import com.example.demo.entity.Organization;
import com.example.demo.service.IOrganService;

@RestController
@RequestMapping(value="api/v1/organization")
public class OrganController {
	
	private static final Logger log = LoggerFactory.getLogger(OrganController.class);
	
	@Autowired
	private IOrganService organservice;
	
	
		
	@GetMapping(value="/cuit/{cuit}")
	public ResponseEntity<HashMap<String, Object>> cuit(@PathVariable(value = "cuit")Long cuit)throws NotFoundException{
		HashMap<String,Object> response= new HashMap<>();
		OrganDto organization= organservice.findByCuitOrganization(cuit);
		log.info("organization"+ cuit.toString());
		
		if(organization!= null) {
			
			response.put("organization", organization);
			
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}else {
			throw new NotFoundException();
			
		}
	}
		
	@GetMapping(value="/all")
	
	public ResponseEntity<HashMap<String, Object>>all(){
		HashMap<String,Object> response = new HashMap<>();
		List<OrganDto> organizations = organservice.getAll();
		
		if(organizations.isEmpty()) {
		 response.put("mensaje","No hay organizaciones cargadas");
		 
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}else {
		response.put("organizations",organizations);
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
		}
	}
	
	@PostMapping ("/")
	public ResponseEntity<Map<String,Object>> newOrganization(@Valid @RequestBody OrganDto organizationDto)throws Exception{
		
		log.info("organization"+ organizationDto.toString());
		
		Map<String, Object> response= new HashMap<>();
		
		OrganDto newOrganization= organservice.save(organizationDto);
		
		response.put("organization", newOrganization);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	@PutMapping("/")
	public ResponseEntity<Map<String, Object>> update(@Valid@RequestBody OrganDto organDto)throws KeyException{
		
		Map<String, Object> response = new HashMap<>();
		OrganDto updateOrgan = organservice.findByCuitOrganization(organDto.getCuitOrganization());
		if(updateOrgan == null) {
			response.put("mensaje", "No se pudo actualizar la informacion de la empresa.");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(updateOrgan.getKey_organization().equals(organDto.getKey_organization())) {
		 updateOrgan = organservice.update(organDto);
		 response.put("organization", updateOrgan+"ha sido actualizada");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	
		
		}throw new KeyException();
		
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<Map<String, Object>>deleteOrgan(@Valid @RequestBody Organization organ)throws Exception{
		
		Map<String,Object> response= new HashMap<>();
		
		Organization deleteorgan = organservice.findById(organ.getId());
		if(deleteorgan!=null) {
		if(deleteorgan.getKey_organization().equals(organ.getKey_organization())) {
		
		 organservice.deleteOrgan(deleteorgan);
	 response.put("Mensaje", "La empresa fue eliminada existosamente");
	 return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	 }throw new KeyException();
		 
	 } throw new NotFoundException();
		
		
	
				
	}
}

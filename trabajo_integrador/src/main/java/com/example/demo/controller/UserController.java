package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrganDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Departament;
import com.example.demo.entity.Floor;
import com.example.demo.entity.NumberStreet;
import com.example.demo.entity.Organization;
import com.example.demo.service.IOrganService;

@RestController
@RequestMapping(value="api/v1/organization")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IOrganService organservice;
	
	/*@GetMapping(value="/{organization}")
	public ResponseEntity<HashMap<String, Object>> id(@PathVariable(value = "organization")Long id){
		HashMap<String,Object> response= new HashMap<>();
		/*Organization organization= new Organization().;
		
		if(organization.==id) {
			
			response.put("organization", organization);
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
	}*/
		
	@GetMapping(value="/cuit/{cuit}")
	public ResponseEntity<HashMap<String, Object>> cuit(@PathVariable(value = "cuit")Integer cuit){
		HashMap<String,Object> response= new HashMap<>();
		Organization organization= new Organization();
		log.info("organization"+ cuit.toString());
		
		if(organservice.findByCuitOrganization(cuit)!= null) {
			
			response.put("organization", organization);
			
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
	}
		
	@GetMapping(value="/all")
	
	public ResponseEntity<HashMap<String, Object>>all(){
		HashMap<String,Object> response = new HashMap<>();
		List<Organization> organizations = organservice.getAll();//new ArrayList<>();
		
		//if(organizations.isEmpty()) {
		// response.put("mensaje","No hay organizaciones cargadas");
		 
		//return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		//}else {
		response.put("organizations",organizations);
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
		//}
	}
	
	@PostMapping ("/")
	public ResponseEntity<Map<String,Object>> newOrganization(@Valid @RequestBody OrganDto organizationDto)throws Exception{
		
		log.info("organization"+ organizationDto.toString());
		
		Map<String, Object> response= new HashMap<>();
		
		OrganDto newOrganization= organservice.save(organizationDto);
		
		response.put("organization", newOrganization);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
		
	
				

}

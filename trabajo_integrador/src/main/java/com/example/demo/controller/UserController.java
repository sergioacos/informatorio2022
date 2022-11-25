package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@GetMapping(value="/{organization}")
	public ResponseEntity<HashMap<String, Object>> id(@PathVariable(value = "organization")Long id){
		HashMap<String,Object> response= new HashMap<>();
		if(id==5) {
			Organization organization= new Organization("carrefour", 20300, 20 /*,new Address(new Street("falsa"),new NumberStreet(123),new Departament(1),new Floor(2)),121,"djkj",new Date(21,10,1984)*/);
			response.put("organization", organization);
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
	}
		
	@PostMapping ("/")
	public ResponseEntity<Map<String,Object>> newOrganization(@RequestBody Organization organization){
		
		log.info("organization"+organization.toString());
		
		Map<String, Object> response= new HashMap<>();
		
		Organization newOrganization= organservice.save(organization);
		
		response.put("organization", newOrganization);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
		
	
				

}

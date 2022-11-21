package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/v1/")
public class UserController {
	
	@GetMapping(value="/{organization}")
	public ResponseEntity<HashMap<String,Object>> Hola(@PathVariable(value= "organization")Long id){
		HashMap<String,Object> response= new HashMap<>();
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
				}

}

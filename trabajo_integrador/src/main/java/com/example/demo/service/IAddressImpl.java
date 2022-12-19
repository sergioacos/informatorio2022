package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.NumberStreet;
import com.example.demo.entity.Street;
import com.example.demo.repository.IAddressRepository;
import com.example.demo.repository.INumberRepository;

@Service
public class IAddressImpl implements  IAddressService{
	
	@Autowired
	IAddressRepository addressRepository;
	
	@Autowired
	INumberRepository numberRepository;
	@Autowired
	IStreetRepository streetRepository;
	
	@Override
	public Address save(Address address) {
		Integer number=address.getNumber().getNumber();
		NumberStreet numberR=numberRepository.findByNumber(number);
		if(numberR==null){
		
		 addressRepository.save(address);
		}address.setNumber(numberR);
		addressRepository.save(address);
	    
		// TODO Auto-generated method stub
		return null;
	}
	public Address savestreet(Address address) {
		String street=address.getStreet().getName();;
		Street streetR=streetRepository.findByName(street);
		if(streetR==null){
		
		 addressRepository.save(address);
		}address.setStreet(streetR);
		addressRepository.save(address);
	    
		// TODO Auto-generated method stub
		return null;
	}

}

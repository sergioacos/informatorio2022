package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Departament;
import com.example.demo.entity.Floor;
import com.example.demo.entity.NumberStreet;
import com.example.demo.entity.Street;
import com.example.demo.repository.IAddressRepository;
import com.example.demo.repository.IDepartamentRepository;
import com.example.demo.repository.IFloorRepository;
import com.example.demo.repository.INumberRepository;
import com.example.demo.repository.IStreetRepository;

@Service
public class IAddressImpl implements  IAddressService{
	
	@Autowired
	IAddressRepository addressRepository;
	
	@Autowired
	INumberRepository numberRepository;
	@Autowired
	IStreetRepository streetRepository;
	
	@Autowired
	IDepartamentRepository departamentRepository;
	
	@Autowired
	IFloorRepository floorRepository;
	
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
			return address;
		}
		address.setStreet(streetR);
		return address;
	}
	public Address savedepartament(Address address) {
		String departament=address.getDepartament().getDepartament();
		Departament departamentR=departamentRepository.findByDepartament(departament);
		if(departamentR==null){
			return address;
		}
		address.setDepartament(departamentR);
		return address;
	}
	public Address savefloor(Address address) {
		Integer floor=address.getFloor().getFloor();
		Floor floorR=floorRepository.findByFloor(floor);
		if(floorR==null){
			return address;
		}
		address.setFloor(floorR);
		return address;
	}
}

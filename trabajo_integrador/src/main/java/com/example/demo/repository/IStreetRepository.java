package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Address;
import com.example.demo.entity.NumberStreet;
import com.example.demo.entity.Street;

public interface IStreetRepository extends JpaRepository<Street,Long> {
	public Street findByName (String name);
}

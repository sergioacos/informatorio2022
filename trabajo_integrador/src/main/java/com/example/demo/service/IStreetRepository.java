package com.example.demo.service;

import com.example.demo.entity.NumberStreet;
import com.example.demo.entity.Street;

public interface IStreetRepository {
	public Street findByName (String name);
}

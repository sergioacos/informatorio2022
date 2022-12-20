package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NumberStreet;
@Repository
public interface INumberRepository extends JpaRepository<NumberStreet, Long> {
	public NumberStreet findByNumber (Integer number);

}

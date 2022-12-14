package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
@Repository
public interface IPersonRepository extends JpaRepository<Person,Long> {
	public Person findByDni(Integer dni);
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Departament;

@Repository
public interface IDepartamentRepository extends JpaRepository<Departament, Long>{
	public Departament findByDepartament(String departament);

}

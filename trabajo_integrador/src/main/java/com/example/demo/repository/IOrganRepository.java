package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Organization;

@Repository
public interface IOrganRepository extends JpaRepository<Organization,Long> {
	
	public Organization findByNameOrganization(String nameOrganization);
	
	public Organization findByCuitOrganization(Integer cuitOrganization);
	
	public List<Organization> findByActiveTrue();

}

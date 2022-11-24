package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Organization;

@Repository
public interface IUserRepository extends JpaRepository<Organization,Long> {
	public Organization findByNameOrganization(String NameOrganization);

}

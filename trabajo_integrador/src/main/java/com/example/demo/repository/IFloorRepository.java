package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Floor;
@Repository
public interface IFloorRepository extends JpaRepository<Floor, Long>{
	public Floor findByFloor (Integer floor);

}

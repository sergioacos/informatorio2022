package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.Organization;
import com.example.demo.entity.Turn;

@Repository
public interface ITurnRepository extends JpaRepository<Turn,Long> {
	public Turn findByCreateDate(LocalDateTime createDate);
	public List<Turn> findByEventsAndOrganizationAndActivityTrue(Event event, Organization organization);
	public Turn findByKey(String keyturn);
	public List<Turn> findByOrganization( Organization organization);
}

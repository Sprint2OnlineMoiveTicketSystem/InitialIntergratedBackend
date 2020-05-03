package com.sprint.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Theater;

@Repository
public interface TheaterDao extends JpaRepository<Theater, Integer>{

	List<Theater> findByTheaterCity(String cityName) ;	
		
}

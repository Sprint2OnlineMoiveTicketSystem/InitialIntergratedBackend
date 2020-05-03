package com.sprint.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer>{

	
}

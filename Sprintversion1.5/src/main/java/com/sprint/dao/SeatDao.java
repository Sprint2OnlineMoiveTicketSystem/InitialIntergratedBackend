package com.sprint.dao;

import org.springframework.stereotype.Repository;

import com.sprint.model.Seat;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SeatDao extends JpaRepository<Seat, Integer>{

}

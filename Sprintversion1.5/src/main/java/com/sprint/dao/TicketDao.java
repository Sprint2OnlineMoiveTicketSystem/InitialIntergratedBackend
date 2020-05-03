package com.sprint.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Integer>{

}

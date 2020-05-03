package com.sprint.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Show;

@Repository
public interface ShowDao extends JpaRepository<Show, Integer>{

	List<Show> findByTheatersId(int theaterId) ;
}


package com.sprint.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.model.Screen;

@Repository
public interface ScreenDao extends JpaRepository<Screen, Integer>{

}

package com.sprint.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.ScreenDao;
import com.sprint.model.Screen;

@Service
@Transactional
public  class ScreenServiceImpl implements ScreenService{
	
	@Autowired
	private ScreenDao dao ;

	@Override
	public String deleteScreen(int id) {
		Optional<Screen> screen = dao.findById(id) ;
		if(!screen.isPresent() || screen == null) {
			return "No Screen found for given id!" ;
		}
		dao.deleteById(id);
		return "Screen Deleted Successfully!";
	}

	@Override
	public String updateScreen(Screen screen) {
		dao.save(screen) ;
		return "Screen Updated!" ;
	}

	

	@Override
	public Screen findScreenById(int screenId) {
		Optional<Screen> s = dao.findById(screenId) ;
		if(!s.isPresent() || s == null) {
			return null ;
		}
		Screen screen = s.get() ;
		return screen ;
	}

	
	

	

	
	

	
}

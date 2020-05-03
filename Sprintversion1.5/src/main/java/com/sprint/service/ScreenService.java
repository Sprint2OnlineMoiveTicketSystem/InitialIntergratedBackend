package com.sprint.service;

import java.util.List;

import com.sprint.model.Screen;

public interface ScreenService {
	
	public String updateScreen(Screen screen) ;
	
	public String deleteScreen(int id) ; 
	public Screen findScreenById(int screenId) ;
		
	

 }


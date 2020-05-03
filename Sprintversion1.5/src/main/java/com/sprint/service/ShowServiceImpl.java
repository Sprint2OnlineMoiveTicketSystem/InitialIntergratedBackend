package com.sprint.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.ShowDao;
import com.sprint.model.Show;

@Service
@Transactional
public class ShowServiceImpl implements ShowService{

	@Autowired
	private ShowDao dao ;
	
	@Override
	public String deleteShow(int id) {
		Optional<Show> show = dao.findById(id) ;
		if(!show.isPresent() || show == null) {
			return "No Show found for given id!" ;
		}
		dao.deleteById(id);
		return "Show Deleted Successfully!";
	}

}

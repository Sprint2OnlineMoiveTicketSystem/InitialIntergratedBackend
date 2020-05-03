package com.sprint.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.model.Movie;
import com.sprint.model.Screen;
import com.sprint.model.Theater;
import com.sprint.service.MovieService;
import com.sprint.service.ScreenService;
import com.sprint.service.TheaterService;

@RestController
@RequestMapping("/lookintoTheater")
public class TheaterController {

	@Autowired
	private MovieService movieService ;
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private ScreenService screenService;
	
	@RequestMapping("/showMovie/{theaterId}/{movieName}")
	public List<Movie> findMovieByTheaterId(@PathVariable("theaterId")int tid,@PathVariable("movieName")String movieName)
	{
		Theater theater = theaterService.findTheaterById(tid) ;
		if(theater.getTheaterId()==tid)
		{
		return movieService.searchMovie(movieName);
	}
		else
			return null;
	
	}
   
	@RequestMapping("/searchScreen/{screenId}")
	public Screen findScreenById(@PathVariable("screenId")int sid)
	{
		return screenService.findScreenById(sid);
	}
	
	//@RequestMapping("/showShows/{showId}")
	
}

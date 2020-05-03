package com.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.model.Movie;
import com.sprint.model.Screen;
import com.sprint.model.Show;
import com.sprint.model.Theater;
import com.sprint.service.MovieService;
import com.sprint.service.ScreenService;
import com.sprint.service.ShowService;
import com.sprint.service.TheaterService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private TheaterService theaterService ;
	
	@Autowired
	private MovieService movieService ;
	
	@Autowired
	private ScreenService screenService ;
	
	@Autowired
	private ShowService showService ;
	
	
	private List<Movie> moviesList ;
	private List<Screen> screenList ;
	private List<Show> showList ;
	
	@RequestMapping(value = "/theater/addTheater", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Theater addTheater(@RequestBody Theater theater) {
		return theaterService.addTheater(theater) ;
	}
	
	@RequestMapping(value = "/theater/{theaterId}", method = RequestMethod.DELETE)
	public String deleteTheater(@PathVariable("theaterId") Integer theaterId) {
		return theaterService.deleteTheater(theaterId) ;
	}
	
	@RequestMapping(value = "/movies/addMovie/{theaterId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addMovie(@RequestBody Movie movie,@PathVariable("theaterId") int theaterId) {
		Theater theater = theaterService.findTheaterById(theaterId) ;
		moviesList = theater.getMovies() ;
		moviesList.add(movie) ;
		theater.setMovies(moviesList);
		return theaterService.updateTheater(theater) ;
	}
	
	@RequestMapping(value = "/movies/deleteMovie/{movieId}", method = RequestMethod.DELETE)
	public String deleteMovie(@PathVariable("movieId") Integer movieId) {
		return movieService.deleteMovie(movieId) ;
	}
	
	@RequestMapping(value = "/movies/addScreen/{theaterId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addScreen(@PathVariable("theaterId") int theaterId, @RequestBody Screen screen) {
		Theater theater = theaterService.findTheaterById(theaterId) ;
		screenList = theater.getScreens() ;
		screenList.add(screen) ;
		theater.setScreens(screenList);
		return theaterService.updateTheater(theater) ;
	}
	
	@RequestMapping(value = "/movies/deleteScreen/{screenId}", method = RequestMethod.DELETE)
	public String deleteScreen(@PathVariable("screenId") Integer screenId) {
		return screenService.deleteScreen(screenId) ;
	}
	
	@RequestMapping(value = "/movies/screens/addShow/{screenId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addShow(@PathVariable("screenId") int screenId, @RequestBody Show show) {
		Screen screen = screenService.findScreenById(screenId) ;
		showList = screen.getShows() ;
		showList.add(show) ;
		screen.setShows(showList);
		return screenService.updateScreen(screen) ;
	}
	
	@RequestMapping(value = "/movies/screens/deleteshow/{showId}", method = RequestMethod.DELETE)
	public String deleteShow(@PathVariable("showId") Integer showId) {
		return showService.deleteShow(showId) ;
	}	
}

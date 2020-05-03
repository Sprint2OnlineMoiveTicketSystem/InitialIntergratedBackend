package com.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.model.Movie;
import com.sprint.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService service ;
	
	/* Method to search Movie by Name */
	@RequestMapping(value = "/searchMovie/{movieName}")
	public List<Movie> searchMovieByName(@PathVariable("movieName") String movieName){
		return service.getAllMovies(movieName) ;
	}
}

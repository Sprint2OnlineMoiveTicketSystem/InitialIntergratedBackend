
package com.sprint.service;

import java.util.List;

import com.sprint.model.Movie;

public interface MovieService {
	
	public String deleteMovie(int id) ;
	
	public List<Movie> getAllMovies(String movieName) ;

	public List<Movie> searchMovie(String movieName);
}

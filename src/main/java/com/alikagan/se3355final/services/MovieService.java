package com.alikagan.se3355final.services;

import com.alikagan.se3355final.dto.DataResponse;
import com.alikagan.se3355final.dto.GetMoviesResponse;
import com.alikagan.se3355final.dto.MovieDTO;
import com.alikagan.se3355final.entities.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {
    ResponseEntity<DataResponse<List<MovieDTO>>> getAll();
    ResponseEntity<DataResponse<Movie>> getMovieById(Long movieId);
    Movie findById(Long movieId);
    ResponseEntity<GetMoviesResponse> searchMovies(String query);
}

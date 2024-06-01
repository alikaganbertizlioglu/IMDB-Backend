package com.alikagan.se3355final.services;

import com.alikagan.se3355final.dto.DataResponse;
import com.alikagan.se3355final.dto.GetMoviesResponse;
import com.alikagan.se3355final.dto.MovieDTO;
import com.alikagan.se3355final.entities.Movie;
import com.alikagan.se3355final.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public ResponseEntity<DataResponse<List<MovieDTO>>> getAll() {
        List<MovieDTO> movies = movieRepository.findAllMoviesWithSelectedFields();
        DataResponse<List<MovieDTO>> dataResponse = new DataResponse<>();
        dataResponse.setData(movies);
        return ResponseEntity.ok(dataResponse);
    }

    @Override
    public ResponseEntity<DataResponse<Movie>> getMovieById(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        DataResponse<Movie> dataResponse = new DataResponse<>();
        dataResponse.setData(movie);
        return ResponseEntity.ok(dataResponse);
    }

    @Override
    public Movie findById(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public ResponseEntity<GetMoviesResponse> searchMovies(String query) {
        List<Movie> movies = movieRepository.findByTitleContainingIgnoreCase(query)
                .stream()
                .limit(3)
                .collect(Collectors.toList());
        GetMoviesResponse response = new GetMoviesResponse(movies);
        return ResponseEntity.ok(response);
    }


}

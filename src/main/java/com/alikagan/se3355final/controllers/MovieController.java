package com.alikagan.se3355final.controllers;

import com.alikagan.se3355final.dto.DataResponse;
import com.alikagan.se3355final.dto.GetMoviesResponse;
import com.alikagan.se3355final.dto.MovieDTO;
import com.alikagan.se3355final.entities.Movie;
import com.alikagan.se3355final.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/public/api/movies")
@CrossOrigin(origins = "https://wonderful-mushroom-0269ae10f.5.azurestaticapps.net")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResponse<List<MovieDTO>>> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DataResponse<Movie>> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/search/{searchStr}")
    public ResponseEntity<GetMoviesResponse> searchMovies(@PathVariable String searchStr) {
        return movieService.searchMovies(searchStr);
    }
}

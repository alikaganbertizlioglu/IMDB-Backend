package com.alikagan.se3355final.dto;

import com.alikagan.se3355final.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMoviesResponse {
    private List<Movie> movieList;
}

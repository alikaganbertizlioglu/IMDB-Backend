package com.alikagan.se3355final.services;


import com.alikagan.se3355final.entities.Movie;

import java.util.List;

public interface WatchlistService {
    void addMovieToUserWatchlist(Long userId,Long movieId);
    List<Movie> getWatchlistOfUser(Long userId);
}

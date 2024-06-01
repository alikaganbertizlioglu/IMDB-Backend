package com.alikagan.se3355final.services;

import com.alikagan.se3355final.entities.Movie;
import com.alikagan.se3355final.entities.User;
import com.alikagan.se3355final.entities.Watchlist;
import com.alikagan.se3355final.repository.MovieRepository;
import com.alikagan.se3355final.repository.WatchlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService{

    UserService2 userService2;
    MovieService movieService;
    WatchlistRepository watchlistRepository;

    @Autowired
    public WatchlistServiceImpl(UserService2 userService2, MovieService movieService,WatchlistRepository watchlistRepository) {
        this.userService2 = userService2;
        this.movieService = movieService;
        this.watchlistRepository = watchlistRepository;
    }

    @Override
    @Transactional
    public void addMovieToUserWatchlist(Long userId, Long movieId) {
        User user = userService2.findById(userId);
        Movie movie = movieService.findById(movieId);
        Watchlist watchlist = user.getWatchlist();

        // Check if the movie already exists in the user's watchlist
        if (watchlist != null && watchlist.getMovies().contains(movie)) {
            throw new IllegalStateException("The movie: "+ movie.getTitle() +" already exists in the user's watchlist");
        }

        // Add the movie to the user's watchlist
        if (watchlist == null) {
            watchlist = new Watchlist(user);
            user.setWatchlist(watchlist);
        }
        watchlist.getMovies().add(movie);
        watchlistRepository.save(watchlist);
    }

    @Override
    public List<Movie> getWatchlistOfUser(Long userId) {
        User user = userService2.findById(userId);
        Watchlist watchlist = user.getWatchlist();
        if (watchlist != null) {
            System.out.println(watchlist.getMovies());
            return watchlist.getMovies();
        }
        return List.of(); // Return an empty list if the user has no watchlist
    }


}

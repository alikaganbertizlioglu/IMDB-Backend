package com.alikagan.se3355final.services;

import com.alikagan.se3355final.dto.RatingInput;
import com.alikagan.se3355final.entities.Movie;
import com.alikagan.se3355final.entities.Rating;
import com.alikagan.se3355final.entities.User;
import com.alikagan.se3355final.repository.MovieRepository;
import com.alikagan.se3355final.repository.RatingRepository;
import com.alikagan.se3355final.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alikagan.se3355final.exceptions.ResourceNotFoundException;

@Service
public class RatingServiceImpl implements RatingService{
    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addRating(RatingInput ratingInputDTO) {
        Movie movie = movieRepository.findById(ratingInputDTO.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + ratingInputDTO.getMovieId()));

        User user = userRepository.findById(ratingInputDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + ratingInputDTO.getUserId()));

        // Check if the user has already rated the movie
        if (ratingRepository.findByMovieIdAndUserId(ratingInputDTO.getMovieId(), ratingInputDTO.getUserId()).isPresent()) {
            throw new IllegalArgumentException("You already rated that movie");
        }

        Rating rating = new Rating(null, movie, user, ratingInputDTO.getRating());
        ratingRepository.save(rating);
        movie.getRatings().add(rating);
        movieRepository.save(movie);  // Save movie to persist changes to ratings
    }

}

package com.alikagan.se3355final.services;

import com.alikagan.se3355final.entities.Actor;
import com.alikagan.se3355final.entities.Movie;
import com.alikagan.se3355final.repository.ActorRepository;
import com.alikagan.se3355final.repository.MovieRepository;
import com.alikagan.se3355final.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestServiceImpl {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    @Autowired
    public TestServiceImpl(ActorRepository actorRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public Optional<Actor> findActorById(Long id) {
        return actorRepository.findById(id);
    }
    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id);
    }

}

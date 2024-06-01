package com.alikagan.se3355final.repository;

import com.alikagan.se3355final.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("SELECT r FROM Rating r WHERE r.movie.id = :movieId AND r.user.id = :userId")
    Optional<Rating> findByMovieIdAndUserId(@Param("movieId") Long movieId, @Param("userId") Long userId);
}

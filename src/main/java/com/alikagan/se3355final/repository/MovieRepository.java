package com.alikagan.se3355final.repository;

import com.alikagan.se3355final.dto.MovieDTO;
import com.alikagan.se3355final.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT new com.alikagan.se3355final.dto.MovieDTO(m.id, m.title, m.posterUrl, AVG(r.rating)) " +
            "FROM Movie m LEFT JOIN m.ratings r GROUP BY m.id, m.title, m.posterUrl")
    List<MovieDTO> findAllMoviesWithSelectedFields();
}

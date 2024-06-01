package com.alikagan.se3355final.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="release_year")
    private Integer releaseYear;

    @Column(name = "genre")
    private String genre;

    @Column(name="poster_url")
    private String posterUrl;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "popularity_ranking")
    private int popularityRanking;

    @Column(name = "number_of_viewer")
    private int numberOfViewer;

    @Column(name = "length")
    private Integer length; // Added length attribute

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @JsonIgnore
    private List<Actor> actors = new ArrayList<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Rating> ratings = new ArrayList<>();

    public double getAvgRating() {
        return ratings.stream()
                .mapToDouble(Rating::getRating)
                .average()
                .orElse(0.0);
    }

    public long getNumberOfRatingVotes() {
        return ratings.size();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", popularityRanking=" + popularityRanking +
                ", numberOfViewer=" + numberOfViewer +
                '}';
    }
}

package com.alikagan.se3355final.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @OneToOne
   @JoinColumn(name="user_id")
    private User user;

   @ManyToMany
   @JoinTable(
           name="watchlist_movies",
           joinColumns = @JoinColumn(name = "watchlist_id"),
           inverseJoinColumns = @JoinColumn(name = "movie_id")
   )
   private List<Movie> movies = new ArrayList<>();

    public Watchlist(User user) {
        this.user = user;
    }
}

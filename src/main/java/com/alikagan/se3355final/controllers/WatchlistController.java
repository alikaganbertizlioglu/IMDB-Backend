package com.alikagan.se3355final.controllers;

import com.alikagan.se3355final.dto.AddWatchlistRequest;
import com.alikagan.se3355final.entities.Movie;
import com.alikagan.se3355final.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchlist")
@CrossOrigin(origins = "https://wonderful-mushroom-0269ae10f.5.azurestaticapps.net")
public class WatchlistController {
    private final WatchlistService watchlistService;

    @Autowired
    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMovieToWatchlist(@RequestBody AddWatchlistRequest request) {
        try {
            watchlistService.addMovieToUserWatchlist(request.getUserId(), request.getMovieId());
            return ResponseEntity.ok().build(); // Return 200 OK if successful
        } catch (IllegalStateException e) {
            // Return 400 Bad Request with the error message if movie already exists in watchlist
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Return 500 Internal Server Error for other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding the movie to the watchlist");
        }
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<List<Movie>> getUsersWatchlist(@PathVariable Long userId) {
        List<Movie> movies = watchlistService.getWatchlistOfUser(userId);
        return ResponseEntity.ok(movies);
    }
}

package com.alikagan.se3355final.repository;

import com.alikagan.se3355final.entities.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    Watchlist findByUserId(Long userId);

}

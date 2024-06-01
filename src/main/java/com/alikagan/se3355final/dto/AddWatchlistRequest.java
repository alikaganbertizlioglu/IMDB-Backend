package com.alikagan.se3355final.dto;

import lombok.Data;

@Data
public class AddWatchlistRequest {
    private Long userId;
    private Long movieId;
}

package com.alikagan.se3355final.dto;

import lombok.Data;

@Data
public class RatingInput {
    private Long movieId;
    private Long userId;
    private double rating;
}

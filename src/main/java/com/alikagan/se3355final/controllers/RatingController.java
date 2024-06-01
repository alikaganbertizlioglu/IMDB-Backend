package com.alikagan.se3355final.controllers;

import com.alikagan.se3355final.dto.RatingInput;
import com.alikagan.se3355final.dto.StringResponse;
import com.alikagan.se3355final.exceptions.ResourceNotFoundException;
import com.alikagan.se3355final.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
@CrossOrigin(origins = "https://wonderful-mushroom-0269ae10f.5.azurestaticapps.net")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/add")
    public ResponseEntity<StringResponse> addRating(@RequestBody RatingInput ratingInput) {
        try {
            ratingService.addRating(ratingInput);
            return new ResponseEntity<>(new StringResponse("Rating added successfully"), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new StringResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(new StringResponse(e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new StringResponse("An error occurred while adding the rating"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

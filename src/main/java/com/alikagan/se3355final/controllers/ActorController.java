package com.alikagan.se3355final.controllers;

import com.alikagan.se3355final.dto.GetActorsResponse;
import com.alikagan.se3355final.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api/actors")
@CrossOrigin
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/search/{searchStr}")
    public ResponseEntity<GetActorsResponse> searchActors(@PathVariable String searchStr) {
        return actorService.searchActors(searchStr);
    }
}

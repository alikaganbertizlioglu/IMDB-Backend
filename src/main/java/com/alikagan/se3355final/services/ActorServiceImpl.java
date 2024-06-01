package com.alikagan.se3355final.services;

import com.alikagan.se3355final.dto.GetActorsResponse;
import com.alikagan.se3355final.entities.Actor;
import com.alikagan.se3355final.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService{
    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ResponseEntity<GetActorsResponse> searchActors(String searchStr) {
        List<Actor> actors = actorRepository.findByNameContainingIgnoreCase(searchStr)
                .stream()
                .limit(3)
                .collect(Collectors.toList());
        GetActorsResponse response = new GetActorsResponse(actors);
        return ResponseEntity.ok(response);
    }
}

package com.alikagan.se3355final.services;

import com.alikagan.se3355final.dto.GetActorsResponse;
import org.springframework.http.ResponseEntity;

public interface ActorService {
    ResponseEntity<GetActorsResponse> searchActors(String searchStr);
}

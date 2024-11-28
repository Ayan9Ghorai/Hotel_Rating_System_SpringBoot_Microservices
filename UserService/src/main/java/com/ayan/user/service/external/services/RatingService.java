package com.ayan.user.service.external.services;

import com.ayan.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService
{

    // get

    // post

    @PostMapping("/rating")
    ResponseEntity<Rating> createRating(Rating rating);

    // put

    @PutMapping("/rating/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable String ratingId , Rating rating);

    // delete

    @DeleteMapping("/rating/{ratingId}")
    void deleteRating(@PathVariable String ratingId);

}

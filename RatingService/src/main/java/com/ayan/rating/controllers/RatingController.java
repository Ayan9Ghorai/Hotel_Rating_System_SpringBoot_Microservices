package com.ayan.rating.controllers;

import com.ayan.rating.entities.Rating;
import com.ayan.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController
{

    @Autowired
    private RatingService ratingService;

    //create rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    //get all ratings
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    //get all ratings
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }

}

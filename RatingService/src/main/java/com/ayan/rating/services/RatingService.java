package com.ayan.rating.services;

import com.ayan.rating.entities.Rating;

import java.util.List;

public interface RatingService
{

    // create
    Rating create(Rating rating);

    // get all ratings
    List<Rating> getAllRating();

    // get all by user id
    List<Rating> getRatingsByUserId(String userId);

    // get all by hotel id
    List<Rating> getRatingsByHotelId(String hotelId);
}

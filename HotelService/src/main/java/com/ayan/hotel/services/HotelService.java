package com.ayan.hotel.services;

import com.ayan.hotel.entities.Hotel;

import java.util.List;

public interface HotelService
{

    //create
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get hotel
    Hotel get(String id);

}

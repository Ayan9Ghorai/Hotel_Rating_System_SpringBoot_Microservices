package com.ayan.hotel.repositories;

import com.ayan.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String>
{
}

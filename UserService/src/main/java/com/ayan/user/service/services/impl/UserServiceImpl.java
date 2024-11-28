package com.ayan.user.service.services.impl;

import com.ayan.user.service.entities.Hotel;
import com.ayan.user.service.entities.Rating;
import com.ayan.user.service.entities.User;
import com.ayan.user.service.exceptions.ResourceNotFoundException;
import com.ayan.user.service.external.services.HotelService;
import com.ayan.user.service.repositories.UserRepository;
import com.ayan.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        //get user from database with help of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !!! : "+userId));

        //fetch ratings of the above user from RATING-SERVICE
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getUserId() , Rating[].class);
        logger.info("{} ",ratingsOfUser);

        List<Rating> ratingList = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingListWithHoteInfo = ratingList.stream().map(rating -> {

            //api call to HOTEL-SERVICE to get hotel info

//            ResponseEntity<Hotel> responseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = responseEntity.getBody();
//            logger.info("Response code from HOTEL-SERVICE : {}",responseEntity.getStatusCode());

            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            //set the hotel to rating
            rating.setHotel(hotel);

            //return modified rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingListWithHoteInfo);

        return user;
    }
}

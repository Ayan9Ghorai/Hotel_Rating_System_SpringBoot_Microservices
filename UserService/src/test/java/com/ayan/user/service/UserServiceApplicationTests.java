package com.ayan.user.service;

import com.ayan.user.service.entities.Rating;
import com.ayan.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	private RatingService ratingService;
//
//	@Test
//	void createRating(){
//
//		Rating rating = Rating.builder().rating("5").userId("demo").hotelId("demo").feedback("This is created using Feign Client").build();
//
//		ResponseEntity<Rating> ratingResponse = ratingService.createRating(rating);
//
//		System.out.println("New Rating Created , " + ratingResponse.getStatusCode());
//
//	}

}

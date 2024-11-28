package com.ayan.user.service.services;

import com.ayan.user.service.entities.User;

import java.util.List;

public interface UserService
{
    // User Operations

    // Create
    User saveUser(User user);

    // Get All User
    List<User> getAllUser();

    // Get single user of given userId
    User getUser(String userId);

    //TODO: delete
    //TODO: update

}

package com.ayan.user.service.repositories;

import com.ayan.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>
{

}

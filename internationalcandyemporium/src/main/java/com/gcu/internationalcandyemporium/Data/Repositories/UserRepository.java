package com.gcu.internationalcandyemporium.Data.Repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.internationalcandyemporium.Models.UserModel;


public interface UserRepository extends MongoRepository<UserModel, String>{

  Optional<UserModel> findByUsername(String username);
}

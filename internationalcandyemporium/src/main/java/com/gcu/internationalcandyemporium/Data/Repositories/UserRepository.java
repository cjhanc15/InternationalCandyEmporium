package com.gcu.internationalcandyemporium.Data.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.gcu.internationalcandyemporium.Models.UserModel;


public interface UserRepository extends CrudRepository<UserModel, Long>{
}

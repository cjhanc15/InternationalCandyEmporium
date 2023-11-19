package com.gcu.internationalcandyemporium.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.gcu.internationalcandyemporium.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    // Additional custom queries can be added here if needed
}
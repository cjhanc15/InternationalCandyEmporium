package com.gcu.Registration.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.Registration.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    // Additional custom queries can be added here if needed
}
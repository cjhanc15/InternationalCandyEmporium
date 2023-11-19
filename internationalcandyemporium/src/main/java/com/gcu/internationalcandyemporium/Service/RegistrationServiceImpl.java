package com.gcu.internationalcandyemporium.Service;

import org.springframework.stereotype.Service;
import com.gcu.internationalcandyemporium.Models.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public void processRegistration(User user) {
        System.out.println("Processing registration for: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Email: " + user.getEmailAddress());
        System.out.println("Phone Number: " + user.getPhoneNumber());
        System.out.println("Username: " + user.getUsername());
        // Omit printing the password for security reasons
        System.out.println("Registration successful!");
    }
}


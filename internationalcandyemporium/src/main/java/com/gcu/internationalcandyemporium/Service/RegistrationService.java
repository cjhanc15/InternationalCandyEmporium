package com.gcu.internationalcandyemporium.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.internationalcandyemporium.Data.UserDataService;
import com.gcu.internationalcandyemporium.Interfaces.RegistrationServiceInterface;
import com.gcu.internationalcandyemporium.Models.UserModel;

@Service
public class RegistrationService implements RegistrationServiceInterface {


    @Autowired 
    private PasswordEncoderConfig passwordEncoderConfig;
    private UserDataService userDataService;

    public RegistrationService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @Override
    public boolean processRegistration(UserModel user) {
        // Check if the username already exists
        if (userDataService.findByUsername(user.getUsername()) == null) {
            // create user
            String encodedPassword = passwordEncoderConfig.passwordEncoder().encode(user.getPassword());
            user.setPassword(encodedPassword);
            userDataService.create(new UserModel(user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPhoneNumber(), user.getUsername(), user.getPassword()));
            System.out.println("Registration successful for: " + user.getUsername());
            return true;
        } else {
            // handle the error
            System.out.println("Error: Username '" + user.getUsername() + "' is already taken.");
            return false;
        }
    }
    
}

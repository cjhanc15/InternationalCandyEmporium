package com.gcu.internationalcandyemporium.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Data.UserDataService;
import com.gcu.internationalcandyemporium.Models.UserModel;

@Service
public class SecurityService {

    @Autowired
    private UserDataService userDataService;

    public boolean authenticate(String username, String password){
        // Retrieve the user by username
        UserModel user = userDataService.findByUsername(username);
    
        if(user != null && password != null) {
            if(user.getPassword().equals(password)) {
                System.out.println("Security check: Successful login for user " + username);
                return true;
            } else {
                System.out.println("Security check: Failed login attempt for user " + username);
            }
        }
        return false;
    }
    
}

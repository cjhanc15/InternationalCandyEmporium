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
        //RETRIEVE ALL USERS & COMPARE USERNAME & PASSWORD
        UserModel user = userDataService.findByUsername(username);
        if(user.getPassword() == password) {
            System.out.println("Security check: Successful login");
            return true;
        }
        return false;
    }
}

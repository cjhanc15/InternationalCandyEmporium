package com.gcu.internationalcandyemporium.Business;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public boolean authenticate(String username, String password){
        System.out.println("Security check: Successful login");
        return true;
    }
}

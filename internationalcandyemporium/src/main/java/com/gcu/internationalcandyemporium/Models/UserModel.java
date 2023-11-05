package com.gcu.internationalcandyemporium.Models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {
    //variables
    @NotNull(message="User name is a required field")
    @Size(min=3, max=16, message="User name must be within 3 and 16 characters")
    private String username;
    
    @NotNull(message="Password is a required field")
    @Size(min=3, max=16, message="Password must be within 3 and 16 characters")
    private String password;
    
    //getters and setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

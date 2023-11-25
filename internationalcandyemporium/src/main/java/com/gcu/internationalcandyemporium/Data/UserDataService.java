package com.gcu.internationalcandyemporium.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Interfaces.DataAccessInterface;
import com.gcu.internationalcandyemporium.Models.ProductModel;
import com.gcu.internationalcandyemporium.Models.UserModel;
import com.gcu.internationalcandyemporium.Data.Repositories.UserRepository;

@Service
public class UserDataService implements DataAccessInterface<UserModel> {

    private UserRepository userRepository;
    
    @SuppressWarnings("unused")
    private javax.sql.DataSource dataSource;

    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDataService() {}

    @Override
    public List<UserModel> findAll() {
        Iterable<UserModel> userIterable = userRepository.findAll();
        List<UserModel> users = new ArrayList<>();
        try {
            for (UserModel user : userIterable) {
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserModel findById(String id) {
        try {
            Optional<UserModel> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                UserModel user = optionalUser.get();
                return new UserModel(
                    user.getId(), 
                    user.getFirstName(), 
                    user.getLastName(), 
                    user.getEmailAddress(), 
                    user.getPhoneNumber(), 
                    user.getUsername(),
                    user.getPassword()
                    );
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public UserModel findByUsername(String username) {
        Optional<UserModel> userModelOptional = userRepository.findByUsername(username);
        return userModelOptional.orElse(null);
    }
    
    

    @Override
    public boolean create(UserModel user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean update(UserModel user) {
        try {
            UserModel updatedUser = userRepository.save(user);
            return updatedUser != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(UserModel user) {
        try {
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

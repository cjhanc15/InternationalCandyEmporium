package com.gcu.internationalcandyemporium.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Interfaces.DataAccessInterface;
import com.gcu.internationalcandyemporium.Models.UserModel;
import com.gcu.internationalcandyemporium.Data.Entities.UserEntity;
import com.gcu.internationalcandyemporium.Data.Repositories.UserRepository;

@Service
public class UserDataService implements DataAccessInterface<UserModel> {

    private UserRepository userRepository;
    
    @SuppressWarnings("unused")
    private javax.sql.DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    public UserDataService(UserRepository userRepository, javax.sql.DataSource dataSource) {
        this.userRepository = userRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public UserDataService() {}

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        try {
            Iterable<UserEntity> userIterable = userRepository.findAll();
            users = new ArrayList<UserEntity>();
            userIterable.forEach(users::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserModel findById(int id) {
        // For now, just return null
        return null;
    }

    @Override
    public boolean create(UserModel user) {
        String sql = "INSERT INTO user (first_name, last_name, email_address, phone_number, password) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPhoneNumber(), user.getPassword());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
  
    @Override
    public boolean update(UserModel user) {
        // Placeholder implementation
        return true;
    }

    @Override
    public boolean delete(UserModel user) {
        // Placeholder implementation
        return true;
    }
}

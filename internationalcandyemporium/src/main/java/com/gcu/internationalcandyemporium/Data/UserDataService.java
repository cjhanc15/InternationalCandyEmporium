package com.gcu.internationalcandyemporium.Data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.internationalcandyemporium.Interfaces.DataAccessInterface;
import com.gcu.internationalcandyemporium.Models.UserModel;
import com.gcu.internationalcandyemporium.Data.Repositories.UserRepository;

@Service
public class UserDataService implements DataAccessInterface<UserModel> {

    private UserRepository userRepository;
    
    @SuppressWarnings("unused")
    private javax.sql.DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    public UserDataService(UserRepository userRepository, JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.jdbcTemplateObject = jdbcTemplate;
    }

    public UserDataService(UserRepository userRepository, javax.sql.DataSource dataSource) {
        this.userRepository = userRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public UserDataService() {}

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM USER";

        List<UserModel> users =  new ArrayList<UserModel>();
        try {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                UserModel user = new UserModel(
                srs.getLong("ID"), 
                srs.getString("FIRST_NAME"),
                srs.getString("LAST_NAME"),
                srs.getString("EMAIL_ADDRESS"),
                srs.getString("PHONE_NUMBER"),
                srs.getString("USERNAME"),
                srs.getString("PASSWORD"));
                users.add(user);
            }
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

    public UserModel findByUsername(String username) {
        String sql = "SELECT * FROM USER WHERE username = ?";
        List<UserModel> users = jdbcTemplateObject.query(sql, (rs, rowNum) -> {
            UserModel user = new UserModel(
            rs.getLong("ID"),
            rs.getString("FIRST_NAME"),
            rs.getString("LAST_NAME"),
            rs.getString("EMAIL_ADDRESS"),
            rs.getString("PHONE_NUMBER"),
            rs.getString("USERNAME"),
            rs.getString("PASSWORD")
            );
            return user;
        }, username);
    
        return users.isEmpty() ? null : users.get(0);
    }
    

    @Override
    public boolean create(UserModel user) {
        String sql = "INSERT INTO USER (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PHONE_NUMBER, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            int rows = jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPhoneNumber(), user.getUsername(), user.getPassword());
            return rows == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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

package com.gcu.internationalcandyemporium.Data.Repositories;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.internationalcandyemporium.Data.Entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
  @Override
  @Query("SELECT * FROM USERS")
  public List<UserEntity> findAll();
}

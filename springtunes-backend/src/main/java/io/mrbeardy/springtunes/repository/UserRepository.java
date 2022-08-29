package io.mrbeardy.springtunes.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.mrbeardy.springtunes.entity.User;

public interface UserRepository extends CrudRepository<User, UUID> {
    
    public User getUserByUsername(@Param("username") String username);

}

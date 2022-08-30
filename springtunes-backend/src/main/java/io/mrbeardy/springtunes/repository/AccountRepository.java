package io.mrbeardy.springtunes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.mrbeardy.springtunes.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    
    public Account getUserByUsername(@Param("username") String username);

}

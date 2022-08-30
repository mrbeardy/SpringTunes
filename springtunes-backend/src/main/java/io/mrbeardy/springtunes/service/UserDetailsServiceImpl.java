package io.mrbeardy.springtunes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import io.mrbeardy.springtunes.security.AppUserDetails;
import io.mrbeardy.springtunes.entity.Account;
import io.mrbeardy.springtunes.repository.AccountRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) 
        throws UsernameNotFoundException 
    {
        Account account = accountRepository.getUserByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("Could not find user with username '" + username + "'");
        }

        return new AppUserDetails(account);
    }
    
}

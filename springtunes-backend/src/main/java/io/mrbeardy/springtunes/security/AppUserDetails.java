package io.mrbeardy.springtunes.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import io.mrbeardy.springtunes.entity.Authority;
import io.mrbeardy.springtunes.entity.Account;

public class AppUserDetails implements UserDetails {

    private Account account;

    public AppUserDetails(Account account) {
        this.account = account;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<SimpleGrantedAuthority>();

        for (Authority authority : account.getAuthorities()) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole()));
        }

        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account.isEnabled();
    }
    
}

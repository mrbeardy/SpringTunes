package io.mrbeardy.springtunes.configuration;

import io.mrbeardy.springtunes.controllers.AdminController;
import io.mrbeardy.springtunes.controllers.AccountController;
import io.mrbeardy.springtunes.service.UserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String USER_ROLE = "USER";

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider(
        UserDetailsService userDetailsService,
        BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);

        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .mvcMatchers(AdminController.EndpointPath).hasRole(ADMIN_ROLE)
                .mvcMatchers(AccountController.EndpointPath).hasRole(USER_ROLE)
                .antMatchers("/**").permitAll()
                .and().httpBasic();

        return httpSecurity.build();
    }

}

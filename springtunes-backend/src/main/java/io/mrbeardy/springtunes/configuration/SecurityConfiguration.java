package io.mrbeardy.springtunes.configuration;

import io.mrbeardy.springtunes.controllers.AdminController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    private static final String roleAuthoritiesPrefix = "ROLE_";
    private static final String roleAdmin = "ADMIN";
    private static final String roleUser = "USER";

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(

                User.builder()
                        .username("user")
                        .password("{noop}password")
                        .authorities(roleAuthoritiesPrefix + roleUser)
                        .build(),

                User.builder()
                        .username("admin")
                        .password("{noop}admin")
                        .authorities(roleAuthoritiesPrefix + roleAdmin)
                        .build()

        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .mvcMatchers(AdminController.EndpointPath).hasRole(roleAdmin)
                .antMatchers("/**").permitAll()
                .and().httpBasic();

        return httpSecurity.build();
    }

}

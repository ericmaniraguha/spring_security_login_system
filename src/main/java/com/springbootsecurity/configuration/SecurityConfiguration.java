// Import necessary classes and interfaces
package com.springbootsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// Define the SecurityConfiguration class as a configuration class
@Configuration
public class SecurityConfiguration {
	
    // Create a bean for the PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Return a new instance of BCryptPasswordEncoder
        return new BCryptPasswordEncoder();
    }
  
    // Create a bean for the AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService detailsService) {
        // Create a new instance of DaoAuthenticationProvider
        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        // Set the UserDetailService for the DaoAuthenticationProvider
        daoProvider.setUserDetailsService(detailsService);
        // Return a new instance of ProviderManager with the DaoAuthenticationProvider
        return new ProviderManager(daoProvider);
    }

    // Create a bean for the SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configure HttpSecurity to disable CSRF protection and permit all requests
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic().and()
                .build();
    }
}

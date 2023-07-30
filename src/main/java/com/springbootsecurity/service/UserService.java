// Import necessary classes and interfaces
package com.springbootsecurity.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootsecurity.entity.ApplicationUser;
import com.springbootsecurity.entity.Role;

// Define the UserService class
@Service
public class UserService implements UserDetailsService {

    // Autowire the PasswordEncoder bean for password encoding
    @Autowired
    private PasswordEncoder encoder;

    // Implement the loadUserByUsername method from the UserDetailService interface
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Print a message to indicate the start of user details service
        System.out.println("In the user details service");

        // Check if the username is "Eric," if not, throw UsernameNotFoundException
        if (!username.equals("Eric"))
            throw new UsernameNotFoundException("Not Eric");

        // Create a Set to store user roles
        Set<Role> roles = new HashSet<>();
        // Add a new Role with roleId 1 and name "User" to the roles Set
        roles.add(new Role(1, "User"));

        // Return a new ApplicationUser with userId 1, username "Ethan",
        // encoded password, and the roles Set - hash my password.
        return new ApplicationUser(1, "Eric", encoder.encode("password"), roles);
    }
}

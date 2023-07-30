package com.springbootsecurity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springbootsecurity.entity.ApplicationUser;
import com.springbootsecurity.entity.Role;
import com.springbootsecurity.repository.RoleRepository;
import com.springbootsecurity.repository.UserRepository;

@SpringBootApplication
public class JwtAuthenticationSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationSpringBootApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        // This method creates a CommandLineRunner bean that will be executed when the application starts.
//        // It takes three parameters: RoleRepository, UserRepository, and PasswordEncoder.
//
//        return args -> {
//            // This is a lambda expression that implements the run method of CommandLineRunner.
//
//            // Check if the role "ADMIN" already exists in the roleRepository.
//            // If it exists, return and do nothing. Otherwise, continue with initialization.
//            if (roleRepository.findByAuthority("ADMIN") != null) {
//                return;
//            }
//
//            // Create a new Role with the name "ADMIN" and save it to the roleRepository.
//            Role adminRole = roleRepository.save(new Role("ADMIN"));
//
//            // Create a new Role with the name "USER" and save it to the roleRepository.
//            roleRepository.save(new Role("USER"));
//
//            // Create a Set to store roles and add the adminRole to it.
//            Set<Role> roles = new HashSet<>();
//            roles.add(adminRole);
//
//            // Create the admin user with id 1, username "admin", encoded password "password",
//            // and the roles Set. Then save the admin user to the userRepository.
//            ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), roles);
//            userRepository.save(admin);
//        };
//    }
    @Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
		};
	}
}

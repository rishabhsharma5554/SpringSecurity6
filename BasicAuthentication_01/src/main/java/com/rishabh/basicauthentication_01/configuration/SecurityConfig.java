package com.rishabh.basicauthentication_01.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import javax.naming.NoPermissionException;

@Configuration // Annotation to indicate that the class declares one or more @Bean methods
@EnableWebSecurity // Annotation to enable Spring Security's web security support
public class SecurityConfig {

    // Method to configure your users and authentication type (InMemory, JDBC etc)
    @Bean // Annotation to indicate that a method produces a bean to be managed by the Spring container
    public UserDetailsService userDetailsService()
    {
        // Creating a user named 'mohit' with password 'mohit' and authority 'read'
        UserDetails mohitUser = User
                .withUsername("mohit")
                .password(encodeLatest().encode("mohit"))
                .authorities("read")
                .build();

        // Authentication type is InMemory
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(mohitUser); // Adding the user to the InMemoryUserDetailsManager
        return userDetailsManager; // Returning the configured InMemoryUserDetailsManager
    }

    // Method to create a SecurityFilterChain
    @Bean
    public SecurityFilterChain authenticationFilterChain(HttpSecurity http) throws Exception {
        DefaultSecurityFilterChain dsfc = http
                .httpBasic(Customizer.withDefaults()) // Enabling HTTP Basic authentication
                .authorizeHttpRequests(authorize -> authorize.anyRequest()
                        .authenticated()) // All requests must be authenticated
                .build(); // Building the DefaultSecurityFilterChain
        return dsfc; // Returning the configured DefaultSecurityFilterChain
    }

    // Method to create a PasswordEncoder
    @Bean
    public PasswordEncoder encodeLatest()
    {
        return new BCryptPasswordEncoder(); // Returning a BCryptPasswordEncoder
    }

//    @Bean
//    public PasswordEncoder encodeOld(){
//        return NoOpPasswordEncoder.getInstance();
//    }
}


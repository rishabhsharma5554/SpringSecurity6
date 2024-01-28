package com.rishabh.basicauthentication_01.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

// This class is a Spring Component that implements the AuthenticationProvider interface
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    // This method is used to authenticate the user
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        // Extract the username and password from the authentication object
        String username = authentication.getName().toLowerCase();
        String password = authentication.getCredentials().toString().toLowerCase();

        // Check if the username and password match the expected values
        if("mohit".equals(username) && "mohit".equals(password)) {
            // If the credentials are valid, return an authenticated token
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            // If the credentials are invalid, throw an exception
            throw new BadCredentialsException("Invalid Username/Password.");
        }
    }

    // This method checks if the authentication type is supported
    @Override
    public boolean supports(Class<?> authentication) {
        // Check if the authentication type is UsernamePasswordAuthenticationToken
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

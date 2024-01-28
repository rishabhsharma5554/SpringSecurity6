package com.rishabhtech.rsapp.security.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthoritiesAuthorizationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

//	Manual way of Setting up User
	/*
	@Bean
	public InMemoryUserDetailsManager setUpUser()
	{
		ArrayList<GrantedAuthority> authoritiesList = new ArrayList<>();
		authoritiesList.add(new SimpleGrantedAuthority("admin"));
		authoritiesList.add(new SimpleGrantedAuthority("user"));
		authoritiesList.add(new SimpleGrantedAuthority("visitor"));
		
		UserDetails userRishabh = new User("rishabh","pass",authoritiesList);
		InMemoryUserDetailsManager im = new InMemoryUserDetailsManager();
		im.createUser(userRishabh);
		return im;
	}
		*/
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public InMemoryUserDetailsManager setUpUser() 
	{
		UserDetails rishabhUser = User
		.withUsername("rishabh")
		.password("pass")
		.authorities("admin")
		.build();
		
		UserDetails mohitUser = User
				.withUsername("mohit")
				.password("pass")
				.authorities("admin")
				.build();
		
//		InMemoryUserDetailsManager im = new InMemoryUserDetailsManager();
//		im.createUser(mohitUser);
//		im.createUser(rishabhUser);
		return new InMemoryUserDetailsManager(mohitUser,rishabhUser);
	}
	

	
}

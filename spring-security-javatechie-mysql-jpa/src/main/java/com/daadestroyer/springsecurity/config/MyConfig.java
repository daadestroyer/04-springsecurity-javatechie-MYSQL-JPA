package com.daadestroyer.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.daadestroyer.springsecurity.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		
		
//		http
//			.authorizeRequests()
//				.antMatchers("/secure-global/**")
//				.authenticated()
//				.anyRequest()
//				.permitAll()
//			.and()
//			.authorizeRequests()
//				.antMatchers("/secure-admin/**")
//				.authenticated()
//				.anyRequest()
//				.hasRole("ADMIN")
//			.and()
//			.formLogin()
//			.permitAll();
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/secure-admin/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated().and().formLogin();
		
		
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(encodePWD());
	}

	

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
}

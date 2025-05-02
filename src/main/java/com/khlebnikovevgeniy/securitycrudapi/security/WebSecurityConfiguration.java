package com.khlebnikovevgeniy.securitycrudapi.security;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfiguration {
	private final AccountAuthenticationProvider accountAuthenticationProvider;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.csrf(csrf -> csrf.disable())
         .authorizeHttpRequests()
         .requestMatchers(POST, "/api/accounts/**")
         .permitAll()
         .requestMatchers("/**")
         .authenticated()
         .anyRequest()
         .hasAnyRole("USER", "ADMIN")
         .and()
         .authenticationProvider(accountAuthenticationProvider)
         .httpBasic(withDefaults())
         .sessionManagement()
         .sessionCreationPolicy(STATELESS);
		 return http.build();
	}
		
}

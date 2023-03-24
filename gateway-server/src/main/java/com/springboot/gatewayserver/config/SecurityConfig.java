package com.springboot.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange(exchange -> exchange.pathMatchers("/eazybank/accounts-service/**").authenticated()
				.pathMatchers("/eazybank/card-service/**").authenticated()
				.pathMatchers("/eazybank/loans-service/**").permitAll())
		.oauth2ResourceServer().jwt();
		http.csrf().disable();
		
		return http.build();
	}
}

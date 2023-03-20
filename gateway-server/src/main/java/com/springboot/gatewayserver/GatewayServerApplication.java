package com.springboot.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
	
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes().
				route(p-> 
				p.path("/knijhawan/accounts-service/**")
				.filters(f-> f.rewritePath("/knijhawan/accounts-service/(?<segment>.*)","/${segment}")
						.addResponseHeader("X-Response-Time", new Date().toString()))
				.uri("lb://ACCOUNTS-SERVICE"))
				.route(p-> 
				p.path("/knijhawan/loans-service/**")
				.filters(f-> f.rewritePath("/knijhawan/loans-service/(?<segment>.*)","/${segment}")
						.addResponseHeader("X-Response-Time", new Date().toString()))
				.uri("lb://LOANS-SERVICE"))
				.route(p-> 
				p.path("/knijhawan/card-service/**")
				.filters(f-> f.rewritePath("/knijhawan/card-service/(?<segment>.*)","/${segment}")
						.addResponseHeader("X-Response-Time", new Date().toString()))
				.uri("lb://CARD-SERVICE")).build();
	
	}

}

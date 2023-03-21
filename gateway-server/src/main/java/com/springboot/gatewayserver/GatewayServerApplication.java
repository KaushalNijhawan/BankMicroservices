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
				p.path("/eazybank/accounts-service/**")
				.filters(f-> f.rewritePath("/eazybank/accounts-service/(?<segment>.*)","/${segment}")
						.addResponseHeader("X-Response-Time", new Date().toString()))
				.uri("lb://ACCOUNTS-SERVICE"))
				.route(p-> 
				p.path("/eazybank/loans-service/**")
				.filters(f-> f.rewritePath("/eazybank/loans-service/(?<segment>.*)","/${segment}")
						.addResponseHeader("X-Response-Time", new Date().toString()))
				.uri("lb://LOANS-SERVICE"))
				.route(p-> 
				p.path("/eazybank/card-service/**")
				.filters(f-> f.rewritePath("/eazybank/card-service/(?<segment>.*)","/${segment}")
						.addResponseHeader("X-Response-Time", new Date().toString()))
				.uri("lb://CARD-SERVICE")).build();
	
	}

}

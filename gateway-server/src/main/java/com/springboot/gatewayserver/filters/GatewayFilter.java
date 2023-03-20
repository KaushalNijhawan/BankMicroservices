package com.springboot.gatewayserver.filters;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Order(1)
@Component
public class GatewayFilter implements GlobalFilter {

	private Logger log = LoggerFactory.getLogger(GatewayFilter.class);
	private static final String CORRELATION_ID = "eazybank-correlation-id";
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
			HttpHeaders headers = exchange.getRequest().getHeaders();
			if(headers.containsKey(CORRELATION_ID)) {
				log.info("Inside the Filter Method which will be triggered from the Gateway Server with"
						+ "correlation Id  " + headers.get(CORRELATION_ID).get(0));
			}else{
				String correlationID = generateCorrelationID();
				exchange = exchange.mutate().request(exchange.getRequest().mutate().header(CORRELATION_ID, correlationID).build()).build();
			}
			return chain.filter(exchange);
	}
	
	public String generateCorrelationID() {
		return UUID.randomUUID().toString();
	}

}

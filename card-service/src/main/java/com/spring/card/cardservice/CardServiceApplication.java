package com.spring.card.cardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@RefreshScope
@EnableMongoRepositories
public class CardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardServiceApplication.class, args);
	}

//	@Bean
//	public TimedAspect timeAspect(MeterRegistry registry) {
//		return new TimedAspect(registry);
//	}
}

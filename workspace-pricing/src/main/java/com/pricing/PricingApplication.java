package com.pricing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.pricing.dao.PricingMapper;
import com.pricing.response.dtos.ProductPrice;

@SpringBootApplication
@PropertySource("classpath:/config/${environment:local}.properties")
public class PricingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PricingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PricingMapper repository) {
		return (args) -> {					
			repository.save(new ProductPrice(15117729,82.12,"USD"));
			repository.save(new ProductPrice(16696652,23.49,"USD"));
			repository.save(new ProductPrice(16483589,22.11,"USD"));
			repository.save(new ProductPrice(13860428,13.49,"USD"));
		};
		
	}
}

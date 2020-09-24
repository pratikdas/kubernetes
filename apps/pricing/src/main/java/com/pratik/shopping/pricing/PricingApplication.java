package com.pratik.shopping.pricing;

import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pratik.shopping.pricing.models.ProductPrice;
import com.pratik.shopping.pricing.repositories.PriceRepository;

@SpringBootApplication
public class PricingApplication {
	
	@Autowired
	private PriceRepository priceRepository;

	public static void main(String[] args) {
		SpringApplication.run(PricingApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	priceRepository.deleteAll();
	    	priceRepository.save(ProductPrice.builder().id(UUID.randomUUID().toString()).productName("Television").price(24.35).currency("USD").build());
	    	priceRepository.save(ProductPrice.builder().id(UUID.randomUUID().toString()).productName("Watch").price(244.35).currency("GBP").build());
	      };
	   }

}

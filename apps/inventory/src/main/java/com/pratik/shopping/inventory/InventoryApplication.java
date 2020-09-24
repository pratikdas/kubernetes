package com.pratik.shopping.inventory;

import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pratik.shopping.inventory.repositories.InventoryRepository;

@SpringBootApplication
public class InventoryApplication {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	inventoryRepository.deleteAll();
	    	inventoryRepository.save(InventoryItem.builder().itemID(UUID.randomUUID().toString()).productName("Television").itemsInStock(24).build());
	    	inventoryRepository.save(InventoryItem.builder().itemID(UUID.randomUUID().toString()).productName("Watch").itemsInStock(14).build());
	      };
	   }
}

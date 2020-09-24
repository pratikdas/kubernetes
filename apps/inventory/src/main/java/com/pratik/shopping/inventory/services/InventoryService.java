/**
 * 
 */
package com.pratik.shopping.inventory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.shopping.inventory.InventoryItem;
import com.pratik.shopping.inventory.repositories.InventoryRepository;

/**
 * @author Pratik Das
 *
 */
@Service
public class InventoryService {
	
	private InventoryRepository inventoryRepository;

	@Autowired
	public InventoryService(InventoryRepository inventoryRepository) {
		super();
		this.inventoryRepository = inventoryRepository;
	}
	
	public InventoryItem getInventoryItems(final String name) {
		return inventoryRepository.findByProductName(name);
	}
	
	

}

/**
 * 
 */
package com.pratik.shopping.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.shopping.inventory.InventoryItem;
import com.pratik.shopping.inventory.services.InventoryService;

/**
 * @author Pratik Das
 *
 */
@RestController
public class InventoryController {
	
	private InventoryService inventoryService;
	
	
	@Autowired
	public InventoryController(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}


    @GetMapping("/inventory/{name}")
	public InventoryItem getInventoryItem(@PathVariable("name") String name) {
		return inventoryService.getInventoryItems(name);
	}

}

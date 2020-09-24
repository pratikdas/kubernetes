/**
 * 
 */
package com.pratik.shopping.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.shopping.catalog.CatalogItem;
import com.pratik.shopping.catalog.services.CatalogService;

/**
 * @author Pratik Das
 *
 */
@RestController
public class CatalogController {
	
	private CatalogService catalogService;

	@Autowired
	public CatalogController(CatalogService catalogService) {
		super();
		this.catalogService = catalogService;
	}
	
	@GetMapping("/items/{productName}")
	public CatalogItem getCatalogItemsByCategory(@PathVariable(value = "productName") final String productName) {
		
		return catalogService.getCatalogItemByName(productName);
	}
	
	
	

}

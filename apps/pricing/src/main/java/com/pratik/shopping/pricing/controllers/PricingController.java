/**
 * 
 */
package com.pratik.shopping.pricing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.shopping.pricing.models.ProductPrice;
import com.pratik.shopping.pricing.services.PricingService;

/**
 * @author Pratik Das
 *
 */
@RestController
public class PricingController {
	
	private PricingService pricingService;
	
	
	
	@Autowired
	public PricingController(PricingService pricingService) {
		super();
		this.pricingService = pricingService;
	}




	@GetMapping(value = "product/{name}/price")
	@ResponseBody
	public ProductPrice getPrice(@PathVariable("name") String productNamme) {
		
		return pricingService.getPrice(productNamme);
		
	}

}

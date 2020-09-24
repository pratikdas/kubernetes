/**
 * 
 */
package com.pratik.shopping.pricing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.shopping.pricing.models.ProductPrice;
import com.pratik.shopping.pricing.repositories.PriceRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pratik Das
 *
 */
@Service
@Slf4j
public class PricingService {

	private PriceRepository priceRepository;

	@Autowired
	public PricingService(PriceRepository priceRepository) {
		super();
		this.priceRepository = priceRepository;
	}

	public ProductPrice getPrice(final String name) {
		log.info("count {}",priceRepository.count());
		
		ProductPrice productPrice = priceRepository.findByProductName(name);
        log.info("productPrice {} {}", name, productPrice);
		return productPrice;
	}

}

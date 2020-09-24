/**
 * 
 */
package com.pratik.shopping.pricing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratik.shopping.pricing.models.ProductPrice;

/**
 * @author Pratik Das
 *
 */
@Repository
public interface PriceRepository extends JpaRepository<ProductPrice, String>{
	
	 ProductPrice findByProductName(String name);

}

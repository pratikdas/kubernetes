/**
 * 
 */
package com.pratik.shopping.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratik.shopping.inventory.InventoryItem;

/**
 * @author Pratik Das
 *
 */

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, String>{
	
	InventoryItem findByProductName(String name);

}
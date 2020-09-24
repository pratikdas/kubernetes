/**
 * 
 */
package com.pratik.shopping.inventory.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.pratik.shopping.inventory.InventoryItem;
import com.pratik.shopping.inventory.repositories.InventoryRepository;
import static org.mockito.Mockito.*;

/**
 * @author fab
 *
 */
class InventoryServiceTest {
	
	private InventoryService inventoryService;
	
	@Mock
	private InventoryRepository inventoryRepository;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		inventoryRepository = mock(InventoryRepository.class);
		when(inventoryRepository.findByProductName("Television")).thenReturn(InventoryItem.builder().productName("Television").build());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	
	
	@Test
	void testInventoryServiceCreationWithRepo() {
		inventoryService = new InventoryService(inventoryRepository);
		assertNotNull(inventoryService);
	}

	/**
	 * Test method for {@link com.pratik.shopping.inventory.services.InventoryService#getInventoryItems(java.lang.String)}.
	 */
	@Test
	void testGetInventoryItems() {
		
		assertNotNull(inventoryRepository);
		inventoryService = new InventoryService(inventoryRepository);
		
		InventoryItem inventoryItem = inventoryService.getInventoryItems("Television");
	    assertNotNull(inventoryItem);
	
	}

}

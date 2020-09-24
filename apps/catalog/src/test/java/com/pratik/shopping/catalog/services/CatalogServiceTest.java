/**
 * 
 */
package com.pratik.shopping.catalog.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pratik.shopping.catalog.CatalogItem;
import com.pratik.shopping.catalog.config.AppProperties;

/**
 * @author Pratik Das
 *
 */
class CatalogServiceTest {
	
	private CatalogService catalogService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		AppProperties appProperties = new AppProperties();
		
		catalogService = new CatalogService(appProperties);
	}
	
	@Test
	void testGetCatalogItemByName_withValidResponse() {
		CatalogItem item = catalogService.getCatalogItemByName("Television");
		
		assertEquals("Television", item.getName());
		
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

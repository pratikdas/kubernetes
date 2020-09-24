/**
 * 
 */
package com.pratik.shopping.catalog;

import lombok.Builder;
import lombok.Data;

/**
 * @author Pratik Das
 *
 */
@Data
@Builder
public class CatalogItem {
	
	private String id;
	private String name;
	private String unitOfSale;
	private int numberOfStars;
	private double price;
	private int itemsInStock;
	private long lastUpdateTime;
	private String category;
	

}

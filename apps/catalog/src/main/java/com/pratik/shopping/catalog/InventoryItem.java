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
public class InventoryItem {
	private String name;
	private int itemsInStock;

}

/**
 * 
 */
package com.pratik.shopping.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pratik Das
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INVENTORY_ITEMS")
public class InventoryItem {
	
	@Id
	@Column(name = "item_id")
	private String itemID;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "items_in_stock")
	private Integer itemsInStock;

}

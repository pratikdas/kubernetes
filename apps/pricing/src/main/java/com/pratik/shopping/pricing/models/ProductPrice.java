/**
 * 
 */
package com.pratik.shopping.pricing.models;

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
@Table(name = "PRODUCT_PRICES")
public class ProductPrice {
	
	@Id
	private String id;
	
	@Column(name = "product_name")
	private String productName;
	private double price;
	private String currency;
	
	@Column(name = "last_updated_time")
	private Long lastUpdateTime;

}

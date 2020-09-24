/**
 * 
 */
package com.pratik.shopping.catalog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @author Pratik Das
 *
 */
@Configuration
@ConfigurationProperties(prefix = "api")
@Data
public class AppProperties {
	private String inventoryBaseURL;
	private String inventoryURL;
	private String pricingBaseURL;
	private String pricingURL;
}

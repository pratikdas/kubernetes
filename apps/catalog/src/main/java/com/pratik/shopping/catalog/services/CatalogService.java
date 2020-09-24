/**
 * 
 */
package com.pratik.shopping.catalog.services;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jayway.jsonpath.JsonPath;
import com.pratik.shopping.catalog.CatalogItem;
import com.pratik.shopping.catalog.config.AppProperties;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

/**
 * @author Pratik Das
 *
 */
@Service
@Slf4j
public class CatalogService {
	
	
	private AppProperties appProperties;
	
	@Autowired
	public CatalogService(AppProperties appProperties) {
		super();
		this.appProperties = appProperties;
	}



	public CatalogItem getCatalogItemByName(final String productName) {

		// fetch items For Sale from inventory microservice
		Integer itemsForSale = fetchItemsForSaleFromInventory(productName);
		
		// fetch price from pricing engine microservice
        Double price = fetchPriceFromPricingService(productName);
		
        CatalogItem catalogItem = CatalogItem.builder().id(UUID.randomUUID().toString())
				.category("cat 1")
				.itemsInStock(itemsForSale)
				.price(price)
				.name(productName)
				.build();
		return catalogItem;
	}



	private double fetchPriceFromPricingService(final String productName) {
		WebClient webClient = getWebClient(appProperties.getPricingBaseURL());
		Mono<String> apiResponse = webClient.get().uri("/product/"+productName+ "/price")
				                       .retrieve()
				                       .bodyToMono(String.class);
		String jsonResponsePrice = apiResponse.block();
		log.info("jsonResponse1 product {}", jsonResponsePrice);
        Double price = JsonPath.read(jsonResponsePrice, "$.price");

        return price;

	}

	private Integer fetchItemsForSaleFromInventory(final String productName) {
		log.info("inventory url {}",appProperties.getInventoryBaseURL());
		WebClient webClient = getWebClient(appProperties.getInventoryBaseURL());
		Mono<String> apiResponse = webClient.get().uri("/inventory/"+productName)
					                 .retrieve()
					                 .bodyToMono(String.class);
		String jsonResponseInventory = apiResponse.block();
		
		
		log.info("jsonResponse inventory {}", jsonResponseInventory);
		Integer itemsForSale = JsonPath.read(jsonResponseInventory, "$.itemsInStock");
		return itemsForSale;
	}

	private WebClient getWebClient(final String baseUrl) {
		TcpClient tcpClient = TcpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
				.doOnConnected(connection -> {
					connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
					connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
				});

		WebClient client = WebClient.builder()
				.baseUrl(baseUrl)
		        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient))).build();
		return client;
	}

}

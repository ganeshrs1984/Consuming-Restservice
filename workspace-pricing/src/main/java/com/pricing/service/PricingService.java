package com.pricing.service;

import com.pricing.response.dtos.ProductBO;
import com.pricing.response.dtos.ProductPrice;

public interface PricingService {

	public ProductBO getProductById(String productId);
	
	public boolean insertProductPrice(ProductPrice productprice);
	
	public boolean updateProductPrice(ProductPrice productprice);
	
}

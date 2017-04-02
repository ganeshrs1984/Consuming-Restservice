package com.pricing.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricing.beanfactory.ApplicationContextProvider;
import com.pricing.localemessage.Messages;
import com.pricing.response.dtos.ProductPrice;


public interface PricingDao {

 
	 public ProductPrice findByProductId(long productId);	 
		 
	 
	 public ProductPrice insertProductPrice(ProductPrice productPrice);
	 
	 public ProductPrice updateProductPrice(ProductPrice productPrice); 
	 
}

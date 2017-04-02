package com.pricing.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.pricing.beanfactory.ApplicationContextProvider;
import com.pricing.error.ProductException;
import com.pricing.localemessage.Messages;
import com.pricing.response.dtos.ProductPrice;

@Service
public class PricingDaoImpl implements PricingDao{

	 @Autowired
	 private PricingMapper pricingmapper;
	 
	 @Autowired
	 private Messages message;
	 
	 @Autowired
	 private ApplicationContextProvider applicationContextProvider;
	 
	 @Qualifier("duplicatePayload")
	 @Autowired
	 private ProductException productException;
	 
	 @Qualifier("payLoadNotFound")
	 @Autowired
	 private ProductException payLoadNotFound;
	 
	 
	 public ProductPrice findByProductId(long productId){		 
			return pricingmapper.findByProductId(productId);				
	 }
	 
	 public ProductPrice insertProductPrice(ProductPrice productPrice){		 
		    if(pricingmapper.exists(productPrice.getProductId())){
		    	throw productException;
		    }
			 return pricingmapper.save(productPrice); 		 							
	 }

	 
	 public ProductPrice updateProductPrice(ProductPrice productPrice){			    
		 if(pricingmapper.exists(productPrice.getProductId())){			 
			 return pricingmapper.save(productPrice); 
		 }		 	
		 	throw payLoadNotFound;
			 					
	 }

	 
}

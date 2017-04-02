package com.pricing.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pricing.beanfactory.ApplicationContextProvider;
import com.pricing.dao.PricingDao;
import com.pricing.error.ProductException;
import com.pricing.header.dtos.DefaultHeaderRequestDTO;
import com.pricing.helper.CommonUtils;
import com.pricing.localemessage.Messages;
import com.pricing.request.dtos.Item;
import com.pricing.request.dtos.Product;
import com.pricing.request.dtos.ProductDescription;
import com.pricing.request.dtos.Products;
import com.pricing.response.dtos.Price;
import com.pricing.response.dtos.ProductBO;
import com.pricing.response.dtos.ProductPrice;
import com.pricing.restservice.RestServiceTemplate;

@Service("pricingservice")
public class PricingServiceImpl implements PricingService{

	@Qualifier("redSkyRestServiceTemplate")
	@Autowired
	RestServiceTemplate<Products> redSkyRestServiceTemplate;
	
	@Qualifier("redSkyDefaultRequestDTO")
	@Autowired
	DefaultHeaderRequestDTO redSkyDefaultRequestDTO;
	
	@Autowired
	private PricingDao pricingdao;

 	@Autowired
 	Messages message;
 	
	
 	@Autowired
 	ApplicationContextProvider applicationContext;
  	
  	public ProductBO testServiceAppCon(){
  	  return (ProductBO) applicationContext.getApplicationContext().getBean("invalidProductId");  		
  	}
  	
	public ProductBO getProductById(String productId) {	  		
	  		if(CommonUtils.isProductIdValid(productId)){
	  			Products product = redSkyRestServiceTemplate.callRestService(redSkyDefaultRequestDTO,buildURLVariables(productId));	  			
	  			ProductPrice productprice = pricingdao.findByProductId(Long.valueOf(productId));	  				  			
	  			return createProductBO(Long.valueOf(productId),product,productprice);		
	  		}else{  	  				  			
	  		    throw applicationContext.getApplicationContext().getBean("invalidProduct",ProductException.class);
	  		}
	   
	} 


  	
  	public Map<String,Long> buildURLVariables(String productId){
		Map<String, Long> uriVariables = new HashMap<>();
	    uriVariables.put("id", Long.valueOf(productId));
	    return uriVariables;
  	}
  	 	

	private ProductBO createProductBO(Long productId,Products product,ProductPrice productprice){

		if(!Optional.ofNullable(productprice).isPresent() && !Optional.ofNullable(product).isPresent() ){		
			return (ProductBO) applicationContext.getApplicationContext().getBean("productPriceNotfound");
		}

			ProductBO productbo = new ProductBO();
			Price currentprice = new Price();
		
			if(!Optional.ofNullable(productprice).isPresent()){
				productbo.setError(message.getMessage("com.product.price.nf"));
			}else{
				currentprice.setCurrencyCode(productprice.getCode());
				currentprice.setValue(productprice.getPrice());		
				productbo.setCurrentPrice(currentprice);
			}	
	
			productbo.setStatus(200);
			productbo.setId(productId);		                                        
			productbo.setName(getProductDescription(product));
			
			return productbo;
	}


   private String getProductDescription(Products product){
		//null check  
	    String productDescription = Optional.ofNullable(product)
											    .map(Products::getProduct)
											    .map(Product::getItem)
											    .map(Item::getProductDescription)
											    .map(ProductDescription::getTitle)											
		                                        .orElse(message.getMessage("com.product.description.nf"));
	    return productDescription;
   }
   
	@Override
	public boolean insertProductPrice(ProductPrice productprice) {	
        pricingdao.insertProductPrice(productprice);
		return true;
	}
	
	@Override
	public boolean updateProductPrice(ProductPrice productprice) {	
        pricingdao.updateProductPrice(productprice);
		return true;
	}

	public RestServiceTemplate<Products> getRedSkyRestServiceTemplate() {
		return redSkyRestServiceTemplate;
	}

	public DefaultHeaderRequestDTO getRedSkyDefaultRequestDTO() {
		return redSkyDefaultRequestDTO;
	}

	public PricingDao getPricingdao() {
		return pricingdao;
	}

	public Messages getMessage() {
		return message;
	}

	public void setRedSkyRestServiceTemplate(RestServiceTemplate<Products> redSkyRestServiceTemplate) {
		this.redSkyRestServiceTemplate = redSkyRestServiceTemplate;
	}

	public void setRedSkyDefaultRequestDTO(DefaultHeaderRequestDTO redSkyDefaultRequestDTO) {
		this.redSkyDefaultRequestDTO = redSkyDefaultRequestDTO;
	}

	public void setPricingdao(PricingDao pricingdao) {
		this.pricingdao = pricingdao;
	}

	public void setMessage(Messages message) {
		this.message = message;
	}

 	public ApplicationContextProvider getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContextProvider applicationContext) {
		this.applicationContext = applicationContext;
	}

}

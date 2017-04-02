package com.pricing.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pricing.beanfactory.ApplicationContextProvider;
import com.pricing.error.ProductException;
import com.pricing.helper.CommonUtils;
import com.pricing.response.dtos.ProductPrice;

@Component
public class PricingValidator implements Validator {

 	@Autowired
 	private ApplicationContextProvider applicationContext;
 	
	@Override
	  public boolean supports(Class<?> clazz) {
	    return ProductPrice.class.isAssignableFrom(clazz);
	  }

	  @Override
	  public void validate(Object target, Errors errors) {
		 ProductPrice productprice = (ProductPrice) target;		 
		 if(!CommonUtils.isPriceValid(productprice.getPrice())){			
			throw getPoductExceptionBean("incorrectPrice");			 			 
		 }		 
		 if(!CommonUtils.isCurrencyCodeValid(productprice.getCode())){			 
			throw getPoductExceptionBean("badCurrencyCode");			 
		 }

	  }
	  
	  private  ProductException getPoductExceptionBean(String exceptionBean){
			return  (ProductException) applicationContext.getApplicationContext().getBean(exceptionBean);			
	  }
	  
}

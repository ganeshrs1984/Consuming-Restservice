package com.pricing.helper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pricing.beanfactory.ApplicationContextProvider;
import com.pricing.error.ErrorInfo;
import com.pricing.error.ProductException;

public class CommonUtils {
	
	@Autowired
	ApplicationContextProvider applicationContext;
	
	public static boolean isProductIdValid(String productId){
		
		try{
			  Long.parseLong(productId);		  
		}catch(NumberFormatException ne){
			return false;
		}
			return true;
	}

	public static boolean isPriceValid(double price){						
		   if(price > 0.0){
			   return true;
		   }
		   return false;
	}
			
	public static boolean isCurrencyCodeValid(String currencyCode){
		String code[] = {"USD","EUR","AUD"};		
		List<String> currencyCodeList = Arrays.asList(code);
		if(Optional.ofNullable(currencyCode).isPresent()){
			if(currencyCodeList.stream().anyMatch(e -> e.equals(currencyCode.toUpperCase()))){
				   return true;	
			}
		}	
		      	return false;		
	}
	
	
}

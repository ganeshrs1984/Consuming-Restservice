package com.pricing.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.pricing.beanfactory.ApplicationContextProvider;
import com.pricing.error.ErrorInfo;
import com.pricing.error.ProductException;
import com.pricing.helper.LogUtil;
import com.pricing.localemessage.Messages;
import com.pricing.response.dtos.ProductBO;
import com.pricing.response.dtos.ProductPrice;
import com.pricing.service.PricingService;
import com.pricing.validator.PricingValidator;


@RestController
public class PricingController{
		
	@Autowired
	private PricingService pricingservice;
	
	@Autowired
	private Messages message;
	
 	@Autowired
 	private ApplicationContextProvider applicationContext;
 	
	@Autowired
 	private PricingValidator pricingValidator;
	
	@Qualifier("payLoadSuccess")
	@Autowired
	private ProductBO payLoadSuccess;
	
 	@InitBinder
 	  public void setProductsBinder(WebDataBinder webDataBinder) { 		
 	    webDataBinder.setValidator(pricingValidator);
 	 }
	
	@RequestMapping(value="/product/{productId}", method = RequestMethod.GET)
	public ProductBO getPricingDetails(@PathVariable String productId){	
		ProductBO productBO = pricingservice.getProductById(productId);	
 		LogUtil.info(this.getClass().getSimpleName(),"getPricingDetails",RequestMethod.GET.name(),
 				" productid="+productId, "NA",productBO.toString()) ;
 				
		return productBO;
	}
	
	
	@RequestMapping(value="/product", method = RequestMethod.POST)
	public ProductBO insertPricingDetails(@Valid @RequestBody ProductPrice productprice){		
	    pricingservice.insertProductPrice(productprice);
	    LogUtil.info(this.getClass().getSimpleName(),"insertPricingDetails",RequestMethod.POST.name(),String.valueOf(productprice.getProductId()),
	    		"Productid="+productprice.getProductId()+" Price="+productprice.getPrice(), 	    		
				" status=200 Successfully-Posted");
		return payLoadSuccess;
	}
	
	@RequestMapping(value="/product/{productId}", method = RequestMethod.PUT)
	public ProductBO updatePricingDetails(@Valid @RequestBody ProductPrice productprice){
	    LogUtil.info(this.getClass().getSimpleName(),"updatePricingDetails",RequestMethod.PUT.name(),String.valueOf(productprice.getProductId()),
	    		"Productid="+productprice.getProductId()+" Price="+productprice.getPrice(), 	    		
				" status=200 Successfully-Posted");	
	  pricingservice.updateProductPrice(productprice);
		 return payLoadSuccess;
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)	
 	@ExceptionHandler(Exception.class)
 	@ResponseBody ErrorInfo
 	handleBadRequest(HttpServletRequest req, Exception e){				
		LogUtil.error(this.getClass().getSimpleName(), "handleBadRequest",HttpStatus.INTERNAL_SERVER_ERROR.value(),
 				req.getMethod(), req.getContextPath(), req.getRequestURI(),getPoductExceptionBean("technicalDifficulty").getErrorInfo().getErrorMessage());
		  return getPoductExceptionBean("technicalDifficulty").getErrorInfo();	 		   		
	}
 
	@ResponseStatus(HttpStatus.BAD_REQUEST)	
 	@ExceptionHandler(ProductException.class)
 	@ResponseBody ErrorInfo
    handleProductExceptionRequest(HttpServletRequest req, Exception e){				
		System.out.println("***************"+applicationContext.getApplicationContext().getBean("invalidProduct",ProductException.class).getErrorInfo().getErrorMessage());
		LogUtil.error(this.getClass().getSimpleName(), "handleProductExceptionRequest",HttpStatus.BAD_REQUEST.value(),
 				req.getMethod(), req.getContextPath(), req.getRequestURI(),((ProductException) e).getErrorInfo().getErrorMessage());
			 return ((ProductException) e).getErrorInfo();
	}	
		
 	@ResponseStatus(HttpStatus.BAD_REQUEST)	
 	@ExceptionHandler(HttpMessageNotReadableException.class)
 	@ResponseBody ErrorInfo
    handleHttpMessageNotReadableExceptionRequest(HttpServletRequest req, Exception e){		 		
 		LogUtil.error(this.getClass().getSimpleName(),"handleHttpMessageNotReadableExceptionRequest",HttpStatus.BAD_REQUEST.value(),
 				req.getMethod(), req.getContextPath(), req.getRequestURI(),getPoductExceptionBean("requestParserException").getErrorInfo().getErrorMessage());		
	  	return getPoductExceptionBean("requestParserException").getErrorInfo();				 		
	}	 
	 
    private  ProductException getPoductExceptionBean(String exceptionBean){
			return  (ProductException) applicationContext.getApplicationContext().getBean(exceptionBean);			
    }

	
}


package com.pricing.beanfactory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import com.pricing.error.ErrorInfo;
import com.pricing.error.ProductException;
import com.pricing.error.enums.EnumErrorId;
import com.pricing.header.dtos.DefaultHeaderRequestDTO;
import com.pricing.request.dtos.Products;
import com.pricing.response.dtos.ProductBO;
import com.pricing.restservice.RestServiceTemplate;


@Configuration
@PropertySource("classpath:locale/messages.properties")
public class Resources {

	
	
	@Value("${redskyEndpointUrl}")
	public String redskyEndpointUrl;
	
	@Autowired
	Environment env;
	
	@Bean(name="redSkyRestServiceTemplate")
	public RestServiceTemplate getRedSkyRestServiceTemplate(){	
		return new RestServiceTemplate(Products.class);
	}
	
	@Bean(name="redSkyDefaultRequestDTO")
	public DefaultHeaderRequestDTO getRedSkyHeaderDTO(){		
		Map<Object, Object> uriVariables= new HashMap<Object, Object>();
		DefaultHeaderRequestDTO defaultHeaderRequestDTO = new DefaultHeaderRequestDTO();
		defaultHeaderRequestDTO.setEndPointURL(redskyEndpointUrl);
		defaultHeaderRequestDTO.setHttpHeaders(new HttpHeaders());
		defaultHeaderRequestDTO.setEntity(defaultHeaderRequestDTO.getHttpHeaders());
		return defaultHeaderRequestDTO;
		
	}
	
	@Bean(name="restTemplate")
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:locale/messages");
		messageSource.setCacheSeconds(3600);
		return messageSource;
	}
		
	
	@Bean(name="productPriceNotfound")
	public ProductBO  getProductPriceNotFound(){	
		ProductBO productbo = new ProductBO();
		productbo.setError(env.getProperty("com.product.product.not.found"));
		productbo.setStatus(200);
		return productbo;
	}

	@Bean(name="payLoadSuccess")
	public ProductBO  getProductSuccessMessage(){	
		ProductBO productbo = new ProductBO();
		productbo.setMessage(env.getProperty("com.product.payload.success"));
		productbo.setStatus(200);
		return productbo;
	}

	@Bean(name="invalidProduct")
	public ProductException getInvalidProductException(){
		return new ProductException(getErrorInfo(HttpStatus.BAD_REQUEST.value(),EnumErrorId.IPD,env.getProperty("com.product.invalid.productid")));
	}
	
	@Bean(name="technicalDifficulty")
	public ProductException getTechnicalDifficultException(){
		return new ProductException(getErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(),EnumErrorId.TD,env.getProperty("com.product.technicalDifficulty")));
	}

	@Bean(name="badCurrencyCode")
	public ProductException getBadCurrencyCodeException(){
		return new ProductException(getErrorInfo(HttpStatus.BAD_REQUEST.value(),EnumErrorId.ICC,env.getProperty("com.product.price.currency.code.invalid")));
	}

	
	@Bean(name="incorrectPrice")
	public ProductException getIncorrectPriceException(){
		return new ProductException(getErrorInfo(HttpStatus.BAD_REQUEST.value(),EnumErrorId.IP,env.getProperty("com.product.price.price.invalid")));
	}
	
	@Bean(name="requestParserException")
	public ProductException getrequestParserException(){
		return new ProductException(getErrorInfo(HttpStatus.BAD_REQUEST.value(),EnumErrorId.FE,env.getProperty("com.product.payload.read.exception")));
	}
	
	
	@Bean(name="duplicatePayload")
	public ProductException getDuplicateException(){
		return new ProductException(getErrorInfo(HttpStatus.BAD_REQUEST.value(),EnumErrorId.DP,env.getProperty("com.product.product.already.avaialble")));
	}
	
	
	@Bean(name="payLoadNotFound")
	public ProductException getPayLoadNotFound(){
		return new ProductException(getErrorInfo(HttpStatus.BAD_REQUEST.value(),EnumErrorId.PNF,env.getProperty("com.product.product.not.found")));
	}

	public ErrorInfo getErrorInfo(int httpStatus,EnumErrorId id,String responseMessage){		
 		ErrorInfo errorInfo = new ErrorInfo(httpStatus,id,responseMessage);		
		return errorInfo;
	}
	



}

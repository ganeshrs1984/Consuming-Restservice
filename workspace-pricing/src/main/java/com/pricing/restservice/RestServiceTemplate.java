package com.pricing.restservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.pricing.error.ProductException;
import com.pricing.header.dtos.DefaultHeaderRequestDTO;
import com.pricing.helper.LogUtil;
import com.pricing.request.dtos.Products;

@Service
public class RestServiceTemplate<R> {
	
	public Class<R> responseClass;	
	
	public RestServiceTemplate(){
		this.responseClass = null;
	}
	
	public RestServiceTemplate(Class<R> responseClass){
		this.responseClass = responseClass;
	}
	
	@Qualifier("restTemplate")
	@Autowired
	RestTemplate restTemplate;
	
	@Qualifier("technicalDifficulty")
	@Autowired
	ProductException productException;
	
	public R callRestService(DefaultHeaderRequestDTO headerDto,Map uriVariables){
		ResponseEntity<R> reponse = null;
		try{		
			reponse = restTemplate.exchange(headerDto.getEndPointURL(), HttpMethod.GET, headerDto.getEntity(), responseClass, uriVariables);		    			
		   
			LogUtil.info(this.getClass().getSimpleName(), "callRestService", "GET", "NA", " endpointUrl="+headerDto.getEndPointURL(), reponse.getBody().toString());
			return reponse.getBody();
		}catch(HttpClientErrorException e){				
			LogUtil.warn(this.getClass().getSimpleName(), "callRestService",400, "GET","NA" , " endpointUrl="+headerDto.getEndPointURL()," HttpClientErrorException" + "NA");
			return null;
		}catch(Exception e){	
			LogUtil.error(this.getClass().getSimpleName(), "callRestService",400, "GET","NA" , " endpointUrl="+headerDto.getEndPointURL()," HttpClientErrorException" + "NA");
			throw e;
		}
	}

	  private HttpEntity<Object> getRequestEntity() {
		    return new HttpEntity<Object>(new HttpHeaders());
		  }

}

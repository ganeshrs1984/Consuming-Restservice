package com.pricing.header.dtos;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class DefaultHeaderRequestDTO {

	private String endPointURL;
	private HttpEntity<Object> entity;
	private HttpHeaders httpHeaders;
	
	
	public String getEndPointURL() {
		return endPointURL;
	}
	public void setEndPointURL(String endPointURL) {
		this.endPointURL = endPointURL;
	}
	public HttpEntity<Object> getEntity() {
		return entity;
	}
	public void setEntity(HttpHeaders httpHeaders) {
		entity = new HttpEntity<Object>(httpHeaders);
	}
	  
	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}
/*	public HeaderMappingVariablesDTO getHeaderMappingVariablesDTO() {
		return headerMappingVariablesDTO;
	}
	public void setHeaderMappingVariablesDTO(HeaderMappingVariablesDTO headerMappingVariablesDTO) {
		this.headerMappingVariablesDTO = headerMappingVariablesDTO;
	}*/

	
}

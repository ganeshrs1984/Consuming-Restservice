package com.pricing.response.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity(name="Product_Price")
public class ProductPrice implements Serializable{

	public ProductPrice(){};
	
	@Id
	@Column(name="PRODUCT_ID",unique=true,nullable=false)
	private long productId;

	@Column(name="PRICE",nullable=false)	
	private double price;
	
	@Column(name="CURRENCY_CODE",nullable=false)
	private String code;
	
	public ProductPrice(long productId,double price,String code){
		this.productId = productId;
		this.price = price;
		this.code = code;
	}
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

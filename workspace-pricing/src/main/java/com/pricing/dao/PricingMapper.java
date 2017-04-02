package com.pricing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pricing.response.dtos.ProductPrice;


@Repository
public interface PricingMapper extends JpaRepository<ProductPrice, Long> {
	
	ProductPrice findByProductId(Long productId);
	
}

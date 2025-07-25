package com.bank.repo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ActiveProfiles;

import com.bank.entity.ProductEntity;

@SpringBootTest
@ActiveProfiles("test")
class ProductRepoTest {

	@Autowired
	private IProductRepo productRepo; 
	
	@Test
	@Order(1)
	void testCreateProduct() {
		ProductEntity product = new ProductEntity();
		product.setProductID(123L);
		product.setProductName("Premium Savings Account");
		product.setDescription("High-yield savings product with monthly interest payout.");
		
		ProductEntity saved = productRepo.save(product); 
		
		assertNotNull(saved.getProductID());
		assertNotNull(saved.getProductName());
	}
}

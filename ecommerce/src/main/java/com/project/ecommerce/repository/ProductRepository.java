package com.project.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.dto.ProductDto;
import com.project.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "SELECT p.product_id, p.product_name, b.brand_id, b.brand_name FROM Product p LEFT OUTER JOIN Brand b ON p.product_id = b.product_id WHERE p.product_id = :id", 
			nativeQuery = true)
	List<ProductDto> findByIDProductwithBrands(@Param("id") int id);
}

package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "SELECT * FROM product p LEFT OUTER JOIN brand b ON p.product_id = b.product_id WHERE p.product_id = :id", 
			nativeQuery = true)
	Product findByIDProductwithBrands(@Param("id") int id);
}

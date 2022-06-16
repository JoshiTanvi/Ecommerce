package com.project.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Brand;
import com.project.ecommerce.model.Product;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	@Query(value="select b from Brand b where b.product = ?1")
	List<Brand> findByProduct(Product product);
}

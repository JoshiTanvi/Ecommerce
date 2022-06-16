package com.project.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Brand;
import com.project.ecommerce.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	@Query(value="select i from Item i where i.brand = ?1")
	List<Item> findByBrand(Brand id);
}

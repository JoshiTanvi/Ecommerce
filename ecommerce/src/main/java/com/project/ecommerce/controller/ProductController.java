package com.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.dto.ProductDto;
import com.project.ecommerce.exception.ResourceNotFoundException;
import com.project.ecommerce.model.Brand;
import com.project.ecommerce.model.Item;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.service.BrandService;
import com.project.ecommerce.service.ProductService;

@RestController
@RequestMapping("ecommerce/products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@Autowired
	BrandService brandService;
	
	@GetMapping
	public List<Product> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Product findById(@PathVariable("id") int id) {
		Product product = service.findById(id);
		if (product == null) {
			throw new ResourceNotFoundException();
		}
		return product;
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
		return service.save(product);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") int id) {
		Product product = service.findById(id);
		if (product == null) {
			throw new ResourceNotFoundException();
		}
		service.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	public Product update(@PathVariable("id") int id, @RequestBody Product product) {
		Product oldProduct = service.findById(id);
		if(oldProduct == null) {
			throw new ResourceNotFoundException();
		}
		return service.update(product);
	}
	

	@GetMapping(value = "/{id}/brands")
	public List<Brand> getAllBrands(@PathVariable("id") int id) {
		Product product = service.findById(id);
		if (product == null) {
			throw new ResourceNotFoundException();
		}
		return brandService.findBrandsByProduct(product);
	}
	
	@PutMapping(value = "/{id}/brands")
	public Brand updateBrand(@PathVariable("id") int id, @RequestBody Brand brand) {
		Product product = service.findById(id);
		if (product == null) {
			throw new ResourceNotFoundException();
		}
		return brandService.saveBrandToProduct(product, brand);
	}
	
	@GetMapping(value = "/{id}/brands/items")
	public Product getAllBrandswithItems(@PathVariable("id") int id) {
		Product product = service.findById(id);
		if (product == null) {
			throw new ResourceNotFoundException();
		}
		
		return service.findBrandsByProductwithItems(product);
	}
	
}
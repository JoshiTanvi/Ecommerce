package com.project.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.dto.ProductDto;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAll(){
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(model -> products.add(model));
		return products;
	}
	
	public Product findById(int id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);   //will throw exception if product is null
	}
	
	public void deleteById(int id){
		productRepository.deleteById(id);    //will throw exception if id is null
	}
	
	public Product update(Product product) {
		return productRepository.save(product);    //will throw exception if product is null
	}
	
	public List<ProductDto> findBrandsByProductwithItems(Product product) {
		List<ProductDto> brands = productRepository.findByIDProductwithBrands(product.getProduct_id());
		//brands.forEach(i -> i.setItems(itemService.findItemsByBrand(i)));
		return brands;
	}
}

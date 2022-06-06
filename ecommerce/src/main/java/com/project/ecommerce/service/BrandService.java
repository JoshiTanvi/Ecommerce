package com.project.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Brand;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.BrandRepository;
import com.project.ecommerce.repository.ProductRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ItemService itemService;

	public List<Brand> getAll(){
		List<Brand> brands = new ArrayList<Brand>();
		brandRepository.findAll().forEach(model -> brands.add(model));
		return brands;
	}
	
	public Brand findById(int id) {
		return brandRepository.findById(id).orElse(null);
	}
	
	public Brand save(Brand brand) {
		return brandRepository.save(brand);   //will throw exception if Brand is null
	}
	
	public void deleteById(int id){
		brandRepository.deleteById(id);    //will throw exception if id is null
	}
	
	public Brand update(Brand brand) {
		return brandRepository.save(brand);    //will throw exception if Brand is null
	}
	
	public List<Brand> findBrandsByProduct(Product product) {
		List<Brand> brands = new ArrayList<Brand>();
		brandRepository.findByProduct(product).forEach(model -> brands.add(model));
		return brands;
	}
	
	public Brand saveBrandToProduct(Product product, Brand brand) {
		Brand newbrand = new Brand(brand.getBrand_id(), brand.getBrand_name(), product);
		return save(newbrand);
	}
	
	/*
	 * public Brand getBrandwithItems(Brand brand) {
	 * 
	 * brand.setItems(itemService.findItemsByBrand(brand)); return brand; }
	 */
}

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

import com.project.ecommerce.exception.ResourceNotFoundException;
import com.project.ecommerce.model.Brand;
import com.project.ecommerce.model.Item;
import com.project.ecommerce.service.BrandService;
import com.project.ecommerce.service.ItemService;

@RestController
@RequestMapping("ecommerce/brands")
public class BrandController {

	@Autowired
	BrandService service;
	
	@Autowired
	ItemService itemService;
	
	@GetMapping
	public List<Brand> getAll() {
		return service.getAll();
	}

	@GetMapping(value = "/{id}")
	public Brand findById(@PathVariable("id") int id) {
		Brand brand = service.findById(id);
		if (brand == null) {
			throw new ResourceNotFoundException();
		}
		return brand;
	}

	@PostMapping
	public Brand create(@RequestBody Brand brand) {
		return service.save(brand);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") int id) {
		Brand brand = service.findById(id);
		if (brand == null) {
			throw new ResourceNotFoundException();
		}
		service.deleteById(id);
	}

	@PutMapping(value = "/{id}")
	public Brand update(@PathVariable("id") int id, @RequestBody Brand brand) {
		Brand oldBrand = service.findById(id);
		if (oldBrand == null) {
			throw new ResourceNotFoundException();
		}
		return service.update(brand);
	}
	
	@GetMapping(value = "/{id}/items")
	public List<Item> getAllItems(@PathVariable("id") int id) {
		Brand brand = service.findById(id);
		if (brand == null) {
			throw new ResourceNotFoundException();
		}
		return itemService.findItemsByBrand(brand);
	}
	
	@PutMapping(value = "/{id}/items")
	public Item updateItem(@PathVariable("id") int id, @RequestBody Item item) {
		Brand brand = service.findById(id);
		if (brand == null) {
			throw new ResourceNotFoundException();
		}
		return itemService.saveItemToBrand(brand, item);
	}

}

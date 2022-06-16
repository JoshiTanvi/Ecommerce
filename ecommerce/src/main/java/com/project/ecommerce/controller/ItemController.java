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
import com.project.ecommerce.service.ItemService;

@RestController
@RequestMapping("ecommerce/items")
public class ItemController {

	@Autowired
	ItemService service;
	
	@GetMapping
	public List<Item> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Item findById(@PathVariable("id") int id) {
		Item item = service.findById(id);
		if (item == null) {
			throw new ResourceNotFoundException();
		}
		return item;
	}
	
	@PostMapping
	public Item create(@RequestBody Item item) {
		return service.save(item);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") int id) {
		Item item = service.findById(id);
		if (item == null) {
			throw new ResourceNotFoundException();
		}
		service.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	public Item update(@PathVariable("id") int id, @RequestBody Item item) {
		Item oldItem = service.findById(id);
		if(oldItem == null) {
			throw new ResourceNotFoundException();
		}
		return service.update(item);
	}
}
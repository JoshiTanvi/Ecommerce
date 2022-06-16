package com.project.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Brand;
import com.project.ecommerce.model.Item;
import com.project.ecommerce.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAll(){
		List<Item> items = new ArrayList<Item>();
		itemRepository.findAll().forEach(model -> items.add(model));
		return items;
	}
	
	public Item findById(int id) {
		return itemRepository.findById(id).orElse(null);
	}
	
	public Item save(Item item) {
		return itemRepository.save(item);   //will throw exception if Item is null
	}
	
	public void deleteById(int id){
		itemRepository.deleteById(id);    //will throw exception if id is null
	}
	
	public Item update(Item item) {
		return itemRepository.save(item);    //will throw exception if Item is null
	}
	
	public List<Item> findItemsByBrand(Brand brand) {
		List<Item> items = new ArrayList<Item>();
		itemRepository.findByBrand(brand).forEach(model -> items.add(model));
		return items;
	}

	public Item saveItemToBrand(Brand brand, Item item) {
		Item newitem = new Item(item.getItem_id(), item.getItem_name(), brand);
		return save(newitem);
	}
	
}

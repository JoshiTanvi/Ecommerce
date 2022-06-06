package com.project.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int brand_id;

	@Column
	private String brand_name;

	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Item> items = new ArrayList<Item>();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	public Brand() {

	}

	public Brand(int brand_id, String brand_name, Product product) {

		this.brand_id = brand_id;
		this.brand_name = brand_name;
		// this.items = items;
		this.product = product;
	}

	public Brand(int brand_id, String brand_name, Product product, List<Item> items) {

		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.items = items;
		this.product = product;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	

}

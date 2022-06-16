package com.project.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.project.ecommerce.model.Brand;
import com.project.ecommerce.model.Item;

@Entity
public class ProductDto {
	
	@Id
	private int product_id;
	
	@Column
	private String product_name;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Brand> brands = new ArrayList<Brand>();
	
	/*
	 * public ProductDto( Object[] tuples, Map<String, Integer> aliasToIndexMap) {
	 * 
	 * this.product_id = longValue(tuples[aliasToIndexMap.get(ID_ALIAS)]);
	 * this.title = stringValue(tuples[aliasToIndexMap.get(TITLE_ALIAS)]); }
	 */
	public ProductDto(int product_id, String product_name, List<Brand> brands) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.brands = brands;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public List<Brand> getBrands() {
		return brands;
	}
	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

}

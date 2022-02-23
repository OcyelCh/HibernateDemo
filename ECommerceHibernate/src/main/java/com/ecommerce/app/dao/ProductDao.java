package com.ecommerce.app.dao;

import java.util.List;

import com.ecommerce.app.entity.Product;


public interface ProductDao {

	List<Product> getProducts();
	void deleteProduct(Product p);
	public List<Product> getProductByName(String name);

}

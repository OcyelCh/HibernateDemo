package com.ecommerce.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.CartDao;
import com.ecommerce.app.entity.Product;

@Repository
public class CartDaoImpl implements CartDao{

	List<Product> cart = new ArrayList<>();
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return cart;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		if(exists(product)){		
			for(Product p : cart) {
				if(p.equals(product)) {
					p.setProductQuantity(p.getProductQuantity()+1);
					return;
				}
			}
		} else {
			product.setProductQuantity(1);
			cart.add(product);
		}
		
	}
	
	private boolean exists(Product product) {
		for(Product p : cart) 
			if(p.equals(product))
				return true;
		return false;
	}

	@Override
	public double getTotal() {
		double total = 0;
		for(Product p : cart) 
			total += p.getPrice()*p.getProductQuantity(); 
		return total;
	}
	
	public void newCart() {
		cart.clear();
	}
	
}

package com.ecommerce.app.dao.impl;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.ProductDao;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.User;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	List<Product> productsList = new ArrayList<>();
	
	@Autowired
	private SessionFactory sessionFactory;
	/*
	 * public ProductDaoImpl() { //initProductsList(); }
	 */
	 
		/*
		 * private void initProductsList(){
		 * 
		 * 
		 * Product p1 = new Product(); p1.setProductId(1);
		 * p1.setProductName("Samsung S21"); p1.setCategory("mobile phone");
		 * p1.setPrice(800); p1.setProductQuantity(22);
		 * 
		 * Product p2 = new Product(); p2.setProductId(2);
		 * p2.setProductName("Smart tv 2"); p2.setCategory("tv"); p2.setPrice(500);
		 * p2.setProductQuantity(32);
		 * 
		 * Product p3 = new Product(); p3.setProductId(3);
		 * p3.setProductName("refrigerator"); p3.setCategory("home"); p3.setPrice(550);
		 * p3.setProductQuantity(34);
		 * 
		 * Product p4 = new Product(); p4.setProductId(4);
		 * p4.setProductName("laptop ???"); p4.setCategory("home office");
		 * p4.setPrice(1100); p4.setProductQuantity(324);
		 * 
		 * productsList.add(p1); productsList.add(p2); productsList.add(p3);
		 * productsList.add(p4); }
		 */
	@Override
	public List<Product> getProducts() {
		//initProductsList();
		List<Product> productsList = new ArrayList<>();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		productsList =session.createQuery("FROM Product").list();
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Products queried from database");
		return productsList;
	}

	@Override
	public void deleteProduct(Product p) {
		// TODO Auto-generated method stub
		for(Product pro : productsList) {
			if(pro.equals(p)) {
				if(pro.getProductQuantity() == 1)
					productsList.remove(pro);
				else
					pro.setProductQuantity(pro.getProductQuantity()-p.getProductQuantity());
			}
		}		
	}
	
	@Override
	public List<Product> getProductByName(String name) {
		List<Product> products = new ArrayList<>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		products =session.createQuery("FROM Product WHERE productName like '%"+name+"%'").list();
		session.getTransaction().commit();
		session.close();

		return products;
	}
}
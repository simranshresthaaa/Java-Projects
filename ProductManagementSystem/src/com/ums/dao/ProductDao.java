package com.ums.dao;

import java.util.List;

import com.ums.pojo.Product;

public interface ProductDao {
	public void addProduct();
	List<Product>viewAllProducts();
	Product viewProduct(int pid);
	public boolean deleteProduct(int pid);
	public void updateProduct(int pid);
	public void buyProduct();

}

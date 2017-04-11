package com.packt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.domain.Product;

public interface ProductsService {
	
	public List <Product> getAllProducts();
	public Product getProductById(int productId);
	public void processOrder(int productId, int count);
	public List <Product> getProductByCategory(String category);
	public Set <Product> getProductsByFilter(Map<String,List<String>> filterParams);
}

package com.packt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.dao.ProductsDao;
import com.packt.domain.Product;
@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	ProductsDao productsDao;
	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productsDao.getAllProducts();
		
	}
	@Override
	@Transactional
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return productsDao.getProductById(productId);
	}
	@Override
	@Transactional
	public void processOrder(int productId, int count) {
		productsDao.processOrder(productId, count);
		
	}
	@Override
	@Transactional
	public List <Product> getProductByCategory(String category) {
		
		return productsDao.getProductByCategory(category);
	}
	@Override
	@Transactional
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return productsDao.getProductsByFilter(filterParams);
	}

}

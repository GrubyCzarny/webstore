package com.packt.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.packt.domain.Product;

@Repository
public class ProductsDaoImpl implements ProductsDao {

	private List<Product> list;
	@Autowired
	SessionFactory sessionFactory;

	@Override

	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		list = new ArrayList<Product>();
		list = session.createQuery("From Product").getResultList();
		return list;
	}

	@Override
	public Product getProductById(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, productId);
		return product;
	}

	@Override
	public void processOrder(int productId, int count) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, productId);
		
		if (product.getUnitsInStock()<count){
			throw new IllegalArgumentException("Not enough units in store.Current amount is :"+ product.getUnitsInStock());
		}
		long nowa = product.getUnitsInStock() - count;
			Query query = session.createNativeQuery("UPDATE `spring`.`products` SET `units_in_stock`='"+nowa+"' WHERE `id`='"+productId+"'");
			query.executeUpdate();
			session.saveOrUpdate(product);
			
		
		

		
	}

	@Override
	public List <Product> getProductByCategory(String category) {
		Session session = sessionFactory.getCurrentSession();
		list = new ArrayList<Product>();
		Query query = session.createQuery("From Product where category=:categoryPar");
		query.setParameter("categoryPar", category);
		list = query.getResultList();
		
		return list;
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Session session = sessionFactory.getCurrentSession();
		list = new ArrayList<Product>();
		list = session.createQuery("From Product").getResultList();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<Product> productsByCondition = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("category")){
			for(String category:filterParams.get("category")){
				for(Product product:list){
					if(category.equalsIgnoreCase(product.getCategory())){
						productsByCategory.add(product);
					}
				}
			}
		}
		if (criterias.contains("condition")){
			for(String condition:filterParams.get("condition")){
				productsByCondition.addAll(this.getProductByCondition(condition));
			}
		}
		productsByCondition.retainAll(productsByCategory);
		return productsByCondition;
	}
	public List <Product> getProductByCondition(String condition) {
		Session session = sessionFactory.getCurrentSession();
		list = new ArrayList<Product>();
		Query query = session.createQuery("From Product where condition=:conditionPar");
		query.setParameter("conditionPar", condition);
		list = query.getResultList();
		
		return list;
	}
}

package com.packt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.packt.domain.Customer;
@Repository
public class CustomersDaoImpl implements CustomersDao {
	private List<Customer> customersList;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> getAll() {
		Session session = sessionFactory.getCurrentSession();
		customersList = new ArrayList<Customer>();
		customersList = session.createQuery("From Customer").getResultList();
		return customersList;
	}

}

package com.packt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.dao.CustomersDao;
import com.packt.domain.Customer;
@Service
public class CustomerServiceImpl implements CustomersService {
	@Autowired
	private CustomersDao customersDao;

	@Override
	@Transactional
	public List<Customer> getAll() {

		return customersDao.getAll();
	}

}

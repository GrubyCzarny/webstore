package com.packt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.domain.Customer;
import com.packt.service.CustomersService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomersService customersService;
	private List<Customer> customersList;

	@RequestMapping("/all")
	public String showCustomers(Model m) {
		customersList = new ArrayList<Customer>();
		customersList = customersService.getAll();
		m.addAttribute("customers", customersList);
		return "customers";

	}
}

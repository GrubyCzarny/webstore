package com.packt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.domain.Customer;
import com.packt.domain.Product;
import com.packt.service.CustomersService;
import com.packt.service.ProductsService;

@Controller
public class HomeController {



	@RequestMapping("/")
	public String showHome(Model m) {
		m.addAttribute("greeting", "Welcome to the internet store");
		m.addAttribute("tagline", "We provide best equipment available");
		return "home";
	}



}

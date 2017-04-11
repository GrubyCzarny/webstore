package com.packt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.domain.Product;
import com.packt.service.CustomersService;
import com.packt.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductsService productsService;
	@Autowired
	CustomersService customersService;
	private List<Product> productsList;

	@RequestMapping("/order")
	public String processOrder(@RequestParam("id") int productId, @RequestParam("count") int count, Model model) {
		productsService.processOrder(productId, count);
		Product product = productsService.getProductById(productId);

		model.addAttribute("product", product);

		return "order-confirmation";
	}

	@RequestMapping("/all")
	public String showProducts(Model m) {
		productsList = new ArrayList<Product>();
		productsList = productsService.getAllProducts();
		m.addAttribute("produkt", productsList);
		System.out.println(productsList);
		return "products";
	}
	
	@RequestMapping("/{category}")
	public String showProductsByCategory(Model m, @PathVariable("category") String prodCategory ){
		productsList = new ArrayList<Product>();
		productsList = productsService.getProductByCategory(prodCategory);
		m.addAttribute("produkt", productsList);
		return "products";
		
	}
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByCriteria(@MatrixVariable("ByCriteria")Map<String,List<String>> filterParams,Model m){
		m.addAttribute("produkt", productsService.getProductsByFilter(filterParams));
		return "products";
	}
	

}

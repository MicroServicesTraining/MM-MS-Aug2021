/**
 * 
 */
package com.mm.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author USER
 *
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@GetMapping("welcome")
	public String showWelcomePage() {
		return "<h1>Welcome to Products Service</h1>";
	}
	
	@GetMapping("admin")
	public String showAdminWelcomePage() {
		return "<h1>Welcome to Products Service - Admin</h1>";
	}
	
	@GetMapping("seller")
	public String showSellerWelcomePage() {
		return "<h1>Welcome to Products Service - Seller</h1>";
	}
	
	@GetMapping("customer")
	public String showCustomerWelcomePage() {
		return "<h1>Welcome to Products Service - Customer</h1>";
	}
	
}

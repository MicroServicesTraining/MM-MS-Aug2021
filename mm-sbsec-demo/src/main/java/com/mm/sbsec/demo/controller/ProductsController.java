/**
 * 
 */
package com.mm.sbsec.demo.controller;

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
	
	@GetMapping
	public String showWelcomePage() {
		return "<h1>Welcome to Products Service</h1>";
	}
	
}

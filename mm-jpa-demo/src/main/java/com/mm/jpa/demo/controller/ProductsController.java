/**
 * 
 */
package com.mm.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.jpa.demo.entity.Product;
import com.mm.jpa.demo.repository.ProductRepository;

/**
 * @author USER
 *
 */
@RestController
@RequestMapping("product")
public class ProductsController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("welcome")
	public String showWelcomePage() {
		return "<h1>Welcome to Products Management</h1>";
	}
	
	@GetMapping
	public List<Product> loadAllProducts(){
		return productRepository.findAll();
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/{id}")
	public Product modfyProduct(@RequestBody Product product, @PathVariable(name = "id") Long productId) {
		Product dbProduct = productRepository.getById(productId);
		if(dbProduct != null) {
			dbProduct = product;
			productRepository.save(product);
			return product;
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String removeProduct(@PathVariable Long id) {
		Product dbProduct = productRepository.getById(id);
		if(dbProduct != null) {
			productRepository.deleteById(id);
			return "Deleted Successfully...!";
		}
		return "No Product found...!";
	}
	
}

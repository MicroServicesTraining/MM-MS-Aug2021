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
@RequestMapping("/products/admin")
public class AdminController {
	
	@GetMapping("/newseller")
	public String addNewSeller() {
		return "<h1>New Seller Create Page</h1>";
	}
	
	@GetMapping("/allsellers")
	public String listAllSellers() {
		return "<h1>List of All Sellers</h>";
	}
	
}

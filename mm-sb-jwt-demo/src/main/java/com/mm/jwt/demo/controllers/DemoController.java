/**
 * 
 */
package com.mm.jwt.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dorak
 *
 */
@RestController
public class DemoController {
	
	@GetMapping("wish")
	public String sayHello() {
		return "<h2>Hello User</h2>";
	}
	
}

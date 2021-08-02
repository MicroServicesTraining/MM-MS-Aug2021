/**
 * 
 */
package com.mm.sbdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author USER
 *
 */
@RestController
@RequestMapping(path="/api/v1/hello")
public class HelloController {
	
	@GetMapping("/")
	public String sayHello() {
		return "<h1>Hello...!</h1>";
	}

}

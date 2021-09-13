/**
 * 
 */
package com.mm.umgmt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author USER
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping
	public ModelAndView gotoCustomerHomePage() {
		return new ModelAndView("customerhome");
	}
}

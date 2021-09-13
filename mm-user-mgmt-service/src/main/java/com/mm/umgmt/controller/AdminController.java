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
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	public ModelAndView gotoAdminHomePage() {
		return new ModelAndView("adminhome");
	}
	
}

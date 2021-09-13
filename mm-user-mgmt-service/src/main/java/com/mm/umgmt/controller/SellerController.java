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
@RequestMapping("/seller")
public class SellerController {

	@GetMapping
	public ModelAndView gotoSellerHomePage() {
		return new ModelAndView("sellerhome");
	}
}

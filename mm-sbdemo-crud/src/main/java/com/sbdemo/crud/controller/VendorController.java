/**
 * 
 */
package com.sbdemo.crud.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author USER
 *
 */
@RestController
@RequestMapping("/api/v1/vendor")
public class VendorController {

	List<String> vendors;

	/**
	 * 
	 */
	public VendorController() {
		this.vendors = new ArrayList<String>();
	}

	@GetMapping("home")
	public String showVendorsHomePage() {
		return "<h1>Welcome to Vendors Management Service</h1>";
	}

	@GetMapping
	public List<String> showVendors() {
		return vendors;
	}

	@PostMapping("/{vendorname}")
	public String createVendor(@PathVariable(name = "vendorname") String vendor) {
		vendors.add(vendor);
		return "Vendor Created Successfully";
	}

	@PutMapping("/{vendorname}/{newvendorname}")
	public String updateVendor(@PathVariable(name = "vendorname") String vendorName,
			@PathVariable(name = "newvendorname") String newVendorName) {
	
		Iterator<String> it = vendors.iterator();
		Boolean removed = false;
		while(it.hasNext()) {
			String vendor = it.next();
			if(vendorName.equalsIgnoreCase(vendor)) {
				it.remove();
				removed = true;
			}
		}
		if(removed) {
			vendors.add(newVendorName);
		}else {
			return "No vendor found with given name";
		}
		
		return "Vendor Updated Successfully";
	}
	//some commit
	@DeleteMapping("/{vendorname}")
	public String deleteVendor(@PathVariable(name = "vendorname") String vendorName) {
	
		Iterator<String> it = vendors.iterator();
		
		while(it.hasNext()) {
			String vendor = it.next();
			if(vendorName.equalsIgnoreCase(vendor)) {
				it.remove();
			}
		}
		
		return "Vendor Deleted Successfully";
	}

}

/**
 * 
 */
package com.mm.sb.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mm.sb.jpa.entity.Product;

/**
 * @author USER
 *
 */
@Component
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> loadAllProductsFromDb() {
		return productRepository.findAll();
	}

	@Override
	public Product loadProductDetailsById(Long productId) {
		Optional<Product> result = productRepository.findById(productId);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}
	
	@Override
	public Product loadProductDetailsByName(String productName) {
		Optional<Product> result = productRepository.findByName(productName);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}
	
	@Override
	public List<Product> getProductsByString(String str){
		Optional<List<Product>> result = productRepository.getProductsByString(str);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
		
	}

	@Override
	public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
		Optional<List<Product>> result = productRepository.getProductsByPriceRange(minPrice, maxPrice);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}

}

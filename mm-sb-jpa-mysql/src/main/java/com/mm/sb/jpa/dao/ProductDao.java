/**
 * 
 */
package com.mm.sb.jpa.dao;

import java.util.List;

import com.mm.sb.jpa.entity.Product;

/**
 * @author USER
 *
 */
public interface ProductDao {

	List<Product> loadAllProductsFromDb();

	Product loadProductDetailsById(Long productId);

	Product loadProductDetailsByName(String productName);

	List<Product> getProductsByString(String str);

	List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice);

}

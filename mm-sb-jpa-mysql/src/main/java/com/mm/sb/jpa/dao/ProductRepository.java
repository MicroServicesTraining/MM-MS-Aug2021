/**
 * 
 */
package com.mm.sb.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mm.sb.jpa.entity.Product;

/**
 * @author USER
 *
 */
@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByName(String productName);
	
	Optional<List<Product>> findByCategory(String category);
	
	
	/*
	 * @Query(value = "select p from Product p where p.name like %?1%") //positional
	 * parameters Optional<List<Product>> getProductsByString(String str);
	 * 
	 * @Query(value = "select p from Product p where p.price > ?1 and p.price < ?2")
	 * //positional parameters Optional<List<Product>>
	 * getProductsByPriceRange(Double minPrice, Double maxPrice);
	 */
	 
	
	//Named Parameters
	
	/*
	 * @Query(value = "select p from Product p where p.name like %:searchToken%")
	 * //Named parameters Optional<List<Product>> getProductsByString(@Param(value
	 * ="searchToken") String str);
	 * 
	 * @Query(value =
	 * "select p from Product p where p.price > :minPrice and p.price < :maxPrice")
	 * //Named parameters Optional<List<Product>>
	 * getProductsByPriceRange(@Param(value = "minPrice") Double
	 * minPrice, @Param(value = "maxPrice") Double maxPrice);
	 */
	
	
	//Native Queries
	
	//  @Query(value = "select * from products where name like %:searchToken%", nativeQuery = true) //Named parameters 
	//  Optional<List<Product>> getProductsByString(@Param(value = "searchToken") String str);
	  
	  @Query(value = "select * from products p where p.price > :minPrice and p.price < :maxPrice", nativeQuery = true) //Named parameters 
	  Optional<List<Product>> getProductsByPriceRange(@Param(value = "minPrice") Double minPrice, @Param(value = "maxPrice") Double maxPrice);
	 	 
	
	//  @Query(value = "getProductsByString") //Named Query 
	  Optional<List<Product>> getProductsByString(@Param(value = "searchToken") String str);
	  
	 // @Query(value = "getProductsByPriceRange") //Named Query
	//  Optional<List<Product>> getProductsByPriceRange(@Param(value = "minPrice") Double minPrice, @Param(value = "maxPrice") Double maxPrice);
	 
}

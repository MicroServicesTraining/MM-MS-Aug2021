/**
 * 
 */
package com.mm.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.jpa.demo.entity.Product;

/**
 * @author USER
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

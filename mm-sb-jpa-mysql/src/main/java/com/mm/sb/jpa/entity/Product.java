/**
 * 
 */
package com.mm.sb.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author USER
 *
 */
@Entity
@Table(name = "products")
@NamedQueries({
		@NamedQuery(query = "select p from Product p where p.price > :minPrice and p.price < :maxPrice", name = "getProductsByPriceRange") })

@NamedNativeQueries(value = {
	@NamedNativeQuery(name = "Product.getProductsByString", query = " select * from products  where name like :searchToken",resultClass = Product.class)
})
public class Product {

	@Id
	@Column(name = "prod_id")
	private Long id;

	@Column(name= "name")
	private String name;
	private String category;
	private Double price;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

}

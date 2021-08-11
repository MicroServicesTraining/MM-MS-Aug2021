/**
 * 
 */
package com.mm.sb.jpa.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mm.sb.jpa.vo.ProductVO;

/**
 * @author USER
 *
 */
//@JsonInclude(value = Include.NON_EMPTY)
public class ProductsResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 771394928200903052L;
	private String message;
	private List<ProductVO> productsList;
	private ProductVO product;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the productsList
	 */
	public List<ProductVO> getProductsList() {
		return productsList;
	}
	/**
	 * @param productsList the productsList to set
	 */
	public void setProductsList(List<ProductVO> productsList) {
		this.productsList = productsList;
	}
	/**
	 * @return the product
	 */
	public ProductVO getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	
}

/**
 * 
 */
package com.mm.sb.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mm.sb.jpa.dao.ProductDao;
import com.mm.sb.jpa.entity.Product;
import com.mm.sb.jpa.response.ProductsResponse;
import com.mm.sb.jpa.service.ProductService;
import com.mm.sb.jpa.service.ProductServiceContants;
import com.mm.sb.jpa.util.ProductsUtil;

/**
 * @author USER
 *
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductsUtil productsUtil;

	@Override
	public ResponseEntity<ProductsResponse> loadAllProductsFromDb() {
		ProductsResponse productResponse = new ProductsResponse();
		List<Product> productsList = productDao.loadAllProductsFromDb();
		if(CollectionUtils.isEmpty(productsList)) {
			productResponse.setMessage(ProductServiceContants.NO_PRODUCTS_AVAILABLE);
		}else {
			productResponse.setProductsList(productsUtil.convertToVosList(productsList));
		}
		
		
		return new ResponseEntity<ProductsResponse>(productResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProductsResponse> loadProductDetailsById(Long productId) {
		ProductsResponse productResponse = new ProductsResponse();
		Product product = productDao.loadProductDetailsById(productId);
		if(product == null) {
			productResponse.setMessage(ProductServiceContants.NO_PRODUCT_AVAILABLE);
		}else {
			productResponse.setProduct(productsUtil.convertToVo(product));
		}
		
		
		return new ResponseEntity<ProductsResponse>(productResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProductsResponse> loadProductDetailsByName(String productName) {
		ProductsResponse productResponse = new ProductsResponse();
		Product product = productDao.loadProductDetailsByName(productName);
		if(product == null) {
			productResponse.setMessage(ProductServiceContants.NO_PRODUCT_AVAILABLE_BY_NAME);
			return new ResponseEntity<ProductsResponse>(productResponse, HttpStatus.NOT_FOUND);
		}else {
			productResponse.setProduct(productsUtil.convertToVo(product));
			return new ResponseEntity<ProductsResponse>(productResponse, HttpStatus.OK);
		}	
	}

	@Override
	public ResponseEntity<ProductsResponse> getProductsByString(String str) {
		ProductsResponse productResponse = new ProductsResponse();
		List<Product> productsList = productDao.getProductsByString(str);
		if(productsList == null) {
			productResponse.setMessage(ProductServiceContants.NO_PRODUCTS_AVAILABLE);
			return new ResponseEntity<ProductsResponse>(productResponse, HttpStatus.NOT_FOUND);
		}else {
			productResponse.setProductsList(productsUtil.convertToVosList(productsList));
			return new ResponseEntity<ProductsResponse>(productResponse, HttpStatus.OK);
		}	
	}

	@Override
	public ResponseEntity<ProductsResponse> getProductsByPriceRange(Double minPrice, Double maxPrice) {
		ProductsResponse productResponse = new ProductsResponse();
		List<Product> productsList = productDao.getProductsByPriceRange(minPrice, maxPrice);
		if(productsList == null) {
			productResponse.setMessage(ProductServiceContants.NO_PRODUCTS_AVAILABLE);
			return new ResponseEntity<ProductsResponse>(productResponse, HttpStatus.NOT_FOUND);
		}else {
			productResponse.setProductsList(productsUtil.convertToVosList(productsList));
			return new ResponseEntity<ProductsResponse>(productResponse, HttpStatus.OK);
		}
	}
	

}

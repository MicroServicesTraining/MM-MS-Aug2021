/**
 * 
 */
package com.mm.sb.jpa.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mm.sb.jpa.entity.Product;
import com.mm.sb.jpa.vo.ProductVO;

/**
 * @author USER
 *
 */
@Component
public class ProductsUtil {

	public List<ProductVO> convertToVosList(List<Product> productsList) {
		List<ProductVO> productVosList = null;
		if (!CollectionUtils.isEmpty(productsList)) {
			productVosList = new ArrayList<ProductVO>();
			for (Product product : productsList) {
				productVosList.add(convertToVo(product));
			}
		}
		return productVosList;
	}

	public ProductVO convertToVo(Product product) {
		ProductVO productVO  = null;
		if(product != null) {
			productVO = new ProductVO();
			productVO.setId(product.getId());
			productVO.setName(product.getName());
			productVO.setCategory(product.getCategory());
			productVO.setPrice(product.getPrice());			
		}
		return productVO;
	}

}

package com.zym.pss.baseinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.dao.ProductDao;
import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.baseinfo.service.ProductService;
import com.zym.pss.core.service.impl.BaseServiceImpl;
import com.zym.pss.util.UtilFuns;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{
	
	ProductDao productDao ;
	@Resource
	public void setproductDao(ProductDao productDao) {
		super.setBaseDao(productDao);
		this.productDao = productDao;
	}
	
	@Override
	public void insert(Product entity) {
		entity.setId(UUID.randomUUID().toString());
		this.productDao.insert(entity);
	}
	@Override
	public Product findByProductNo(String productNo) {
		Map<String,Object> paramMap = new HashMap<String , Object>();
		paramMap.put("productNo", productNo);
		List<Product> productList = this.productDao.find(paramMap);
		
		if(UtilFuns.isNotEmpty(productList)){
			return productList.get(0);
		}
		return null;
	}
}	

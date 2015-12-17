package com.zym.pss.cargo.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.baseinfo.service.ProductService;
import com.zym.pss.cargo.dao.ProductULLDao;
import com.zym.pss.cargo.po.ProductULL;
import com.zym.pss.cargo.service.ProductULLService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("productULLService")
public class ProductULLServiceImpl extends BaseServiceImpl<ProductULL> implements ProductULLService {

	ProductULLDao productULLDao ;
	@Resource
	public void setproductULLDao(ProductULLDao productULLDao) {
		super.setBaseDao(productULLDao);
		this.productULLDao = productULLDao;
	} 
	@Resource
	ProductService productService ; 
	
	@Override
	public void insert(ProductULL entity) {
		entity.setId(UUID.randomUUID().toString());		//设置主键
		//设置货物的包装单位
		Product product = this.productService.findByProductNo(entity.getProductNo());
		entity.setPackingUnit(product.getPackingUnit());
		this.productULLDao.insert(entity);
	}
	
	@Override
	public void update(ProductULL entity) {
		//设置货物的包装单位
		Product product = this.productService.findByProductNo(entity.getProductNo());
		entity.setPackingUnit(product.getPackingUnit());
		this.productULLDao.update(entity);
	}
}

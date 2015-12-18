package com.zym.pss.cargo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.baseinfo.service.ProductService;
import com.zym.pss.cargo.dao.ProductPutDao;
import com.zym.pss.cargo.po.ProductPut;
import com.zym.pss.cargo.service.ProductPutService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("productPutService")
public class ProductPutServiceImpl extends BaseServiceImpl<ProductPut> implements ProductPutService{
	
	ProductPutDao productPutDao ;
	@Resource
	public void setProductPutDao(ProductPutDao productPutDao) {
		super.setBaseDao(productPutDao);
		this.productPutDao = productPutDao;
	}
	@Resource
	ProductService productService ; 
	
	@Override
	public void insert(ProductPut entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState(0);				//设置状态草稿
		//设置货物的包装单位
		Product product = this.productService.findByProductNo(entity.getProductNo());
		entity.setPackingUnit(product.getPackingUnit());

		this.productPutDao.insert(entity);
	}
	
	@Override
	public void update(ProductPut entity) {
		//设置货物的包装单位
		Product product = this.productService.findByProductNo(entity.getProductNo());
		entity.setPackingUnit(product.getPackingUnit());
		this.productPutDao.update(entity);
	}
	
	@Override
	public void updateState(String[] ids,Integer state) {
		Map<String,Object> paramMap = new HashMap<String , Object>();
		paramMap.put("state", state);
		paramMap.put("ids", ids);
		this.productPutDao.updateState(paramMap);
	}

}	

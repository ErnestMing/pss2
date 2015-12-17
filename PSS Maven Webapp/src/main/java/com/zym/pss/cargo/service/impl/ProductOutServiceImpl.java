package com.zym.pss.cargo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.baseinfo.service.ProductService;
import com.zym.pss.cargo.dao.ProductOutDao;
import com.zym.pss.cargo.po.ProductOut;
import com.zym.pss.cargo.service.ProductOutService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("productOutService")
public class ProductOutServiceImpl extends BaseServiceImpl<ProductOut> implements ProductOutService{
	
	ProductOutDao productOutDao ;
	@Resource
	public void setProductOutDao(ProductOutDao productOutDao) {
		super.setBaseDao(productOutDao);
		this.productOutDao = productOutDao;
	}
	@Resource
	ProductService productService ; 
	@Override
	public void insert(ProductOut entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState(0);				//设置状态草稿
		//设置货物的包装单位
		Product product = this.productService.findByProductNo(entity.getProductNo());
		entity.setPackingUnit(product.getPackingUnit());
		
		this.productOutDao.insert(entity);
	}
	
	@Override
	public void update(ProductOut entity) {
		//设置货物的包装单位
		Product product = this.productService.findByProductNo(entity.getProductNo());
		entity.setPackingUnit(product.getPackingUnit());
		this.productOutDao.update(entity);
	}
	
	@Override
	public void updateState(String[] ids,Integer state) {
		Map<String,Object> paramMap = new HashMap<String , Object>();
		paramMap.put("state", state);
		paramMap.put("ids", ids);
		this.productOutDao.updateState(paramMap);
	}

}	

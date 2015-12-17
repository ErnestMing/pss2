package com.zym.pss.cargo.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.ProductPutDao;
import com.zym.pss.cargo.po.ProductPut;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("productPutDao")
public class ProductPutImpl extends BaseDaoImpl<ProductPut> implements ProductPutDao {

	//设置命名空间
	public ProductPutImpl() {
		super.setNs("com.zym.pss.cargo.mapper.ProductPutMapper");
	}
	
	@Override
	public void updateState(Map<String, Object>  paramMap) {
		super.getSqlSession().update(super.getNs()+".updateState", paramMap);
	}
}

package com.zym.pss.cargo.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.ProductOutDao;
import com.zym.pss.cargo.po.ProductOut;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("productOutDao")
public class ProductOutImpl extends BaseDaoImpl<ProductOut> implements ProductOutDao {

	//设置命名空间
	public ProductOutImpl() {
		super.setNs("com.zym.pss.cargo.mapper.ProductOutMapper");
	}
	
	@Override
	public void updateState(Map<String, Object>  paramMap) {
		super.getSqlSession().update(super.getNs()+".updateState", paramMap);
	}
}

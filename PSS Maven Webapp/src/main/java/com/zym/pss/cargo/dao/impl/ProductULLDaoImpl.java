package com.zym.pss.cargo.dao.impl;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.ProductULLDao;
import com.zym.pss.cargo.po.ProductULL;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("productULLDao")
public class ProductULLDaoImpl extends BaseDaoImpl<ProductULL> implements ProductULLDao {
	
	//设置命名空间
	public ProductULLDaoImpl() {
		super.setNs("com.zym.pss.baseinfo.mapper.ProductULLMapper");
	}

}

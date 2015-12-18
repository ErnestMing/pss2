package com.zym.pss.baseinfo.dao.impl;

import org.springframework.stereotype.Repository;

import com.zym.pss.baseinfo.dao.ProductDao;
import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	//设置命名空间
	public ProductDaoImpl() {
		super.setNs("com.zym.pss.baseinfo.mapper.ProductMapper");
	}
}

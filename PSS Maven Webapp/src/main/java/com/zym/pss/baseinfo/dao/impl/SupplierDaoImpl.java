package com.zym.pss.baseinfo.dao.impl;

import org.springframework.stereotype.Repository;

import com.zym.pss.baseinfo.dao.SupplierDao;
import com.zym.pss.baseinfo.po.Supplier;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("supplierDao")
public class SupplierDaoImpl extends BaseDaoImpl<Supplier> implements SupplierDao {

	//设置命名空间
	public SupplierDaoImpl() {
		super.setNs("com.zym.pss.baseinfo.mapper.SupplierMapper");
	}
}

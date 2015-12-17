package com.zym.pss.baseinfo.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.dao.SupplierDao;
import com.zym.pss.baseinfo.po.Supplier;
import com.zym.pss.baseinfo.service.SupplierService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService{
	
	SupplierDao supplierDao ;
	@Resource
	public void setSupplierDao(SupplierDao supplierDao) {
		super.setBaseDao(supplierDao);
		this.supplierDao = supplierDao;
	}
	
	@Override
	public void insert(Supplier entity) {
		entity.setId(UUID.randomUUID().toString());
		this.supplierDao.insert(entity);
	}
}	

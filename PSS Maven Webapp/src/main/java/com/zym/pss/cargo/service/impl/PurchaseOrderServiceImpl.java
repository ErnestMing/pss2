package com.zym.pss.cargo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.dao.MaterialDao;
import com.zym.pss.baseinfo.dao.SupplierDao;
import com.zym.pss.cargo.dao.PurchaseOrderDao;
import com.zym.pss.cargo.po.PurchaseOrder;
import com.zym.pss.cargo.service.PurchaseOrderService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl extends BaseServiceImpl<PurchaseOrder> implements PurchaseOrderService{
	
	PurchaseOrderDao purchaseOrderDao ;
	@Resource
	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		super.setBaseDao(purchaseOrderDao);
		this.purchaseOrderDao = purchaseOrderDao;
	}
	
	@Resource
	MaterialDao materialDao ;
	@Resource
	SupplierDao supplierDao ; 
	
	@Override
	public void insert(PurchaseOrder entity) {
		entity.setId(UUID.randomUUID().toString());
		this.purchaseOrderDao.insert(entity);
	}

	@Override
	public void deleteByOrderNo(String tenantId,String orderNo) {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", tenantId);
		paraMap.put("orderNo", orderNo);
		
		this.purchaseOrderDao.deleteByOrderNo(paraMap);
	}
}	

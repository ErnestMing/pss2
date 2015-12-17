package com.zym.pss.cargo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.cargo.dao.SaleOrderDao;
import com.zym.pss.cargo.po.SaleOrder;
import com.zym.pss.cargo.service.SaleOrderService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("saleOrderService")
public class SaleOrderServiceImpl extends BaseServiceImpl<SaleOrder> implements SaleOrderService{
	
	SaleOrderDao saleOrderDao ;
	@Resource
	public void setSaleOrderDao(SaleOrderDao saleOrderDao) {
		super.setBaseDao(saleOrderDao);
		this.saleOrderDao = saleOrderDao;
	}
	
	@Override
	public void insert(SaleOrder entity) {
		entity.setId(UUID.randomUUID().toString());
		this.saleOrderDao.insert(entity);
	}

	@Override
	public void deleteByOrderNo(String tenantId , String orderNo) {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", tenantId);
		paraMap.put("orderNo", orderNo);
		
		this.saleOrderDao.deleteByOrderNo(paraMap);
	}
}	

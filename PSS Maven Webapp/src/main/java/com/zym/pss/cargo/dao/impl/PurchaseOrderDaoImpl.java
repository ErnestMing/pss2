package com.zym.pss.cargo.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.PurchaseOrderDao;
import com.zym.pss.cargo.po.PurchaseOrder;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("purchaseOrderDao")
public class PurchaseOrderDaoImpl extends BaseDaoImpl<PurchaseOrder> implements PurchaseOrderDao {

	//设置命名空间
	public PurchaseOrderDaoImpl() {
		super.setNs("com.zym.pss.cargo.mapper.PurchaseOrderMapper");
	}

	@Override
	public void deleteByOrderNo(Map<String,Object> paraMap) {
		super.getSqlSession().delete(super.getNs()+".deleteByOrderNo", paraMap);
	}
}

package com.zym.pss.cargo.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.SaleOrderDao;
import com.zym.pss.cargo.po.SaleOrder;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("saleOrderDao")
public class SaleOrderDaoImpl extends BaseDaoImpl<SaleOrder> implements SaleOrderDao {

	//设置命名空间
	public SaleOrderDaoImpl() {
		super.setNs("com.zym.pss.cargo.mapper.SaleOrderMapper");
	}

	@Override
	public void deleteByOrderNo(Map<String,Object> paraMap) {
		super.getSqlSession().delete(super.getNs()+".deleteByOrderNo",paraMap);
	}
}

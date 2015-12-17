package com.zym.pss.cargo.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.OrderDao;
import com.zym.pss.cargo.po.Order;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	//设置命名空间
	public OrderDaoImpl() {
		super.setNs("com.zym.pss.cargo.mapper.OrderMapper");
	}

	@Override
	public void updateState(Map<String, Object>  paramMap) {
		super.getSqlSession().update(super.getNs()+".updateState", paramMap);
	}
}

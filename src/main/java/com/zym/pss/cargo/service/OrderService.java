package com.zym.pss.cargo.service;

import java.io.Serializable;

import com.zym.pss.cargo.po.Order;
import com.zym.pss.core.service.BaseService;

public interface OrderService extends BaseService<Order> {

	/**
	 * 修改订单
	 * @param ids
	 */
	public void updateState(String[] ids,Integer state);
	
	/**
	 * 删除订单（采购订单，销售订单）
	 */
	public void delete(String tenantId , Serializable[] ids);
}

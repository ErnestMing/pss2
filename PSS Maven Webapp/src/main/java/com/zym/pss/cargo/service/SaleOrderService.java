package com.zym.pss.cargo.service;

import com.zym.pss.cargo.po.SaleOrder;
import com.zym.pss.core.service.BaseService;

public interface SaleOrderService extends BaseService<SaleOrder> {

	/**
	 * 删除销售订单下,所有要销售的货物信息
	 * @param orderNo
	 */
	public void deleteByOrderNo(String tenantId , String orderNo);
}

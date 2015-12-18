package com.zym.pss.cargo.service;

import com.zym.pss.cargo.po.PurchaseOrder;
import com.zym.pss.core.service.BaseService;

public interface PurchaseOrderService extends BaseService<PurchaseOrder> {

	/**
	 * 通过订单编号删除该订单下要采购的原材料
	 * @param orderNo
	 */
	public void deleteByOrderNo(String tenantId , String orderNo);
}

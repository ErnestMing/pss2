package com.zym.pss.cargo.dao;

import java.util.Map;

import com.zym.pss.cargo.po.PurchaseOrder;
import com.zym.pss.core.dao.BaseDao;

public interface PurchaseOrderDao extends BaseDao<PurchaseOrder> {

	/**
	 * 通过订单编号删除该订单下要采购的原材料
	 * @param paraMap
	 */
	public void deleteByOrderNo(Map<String, Object> paraMap);

}

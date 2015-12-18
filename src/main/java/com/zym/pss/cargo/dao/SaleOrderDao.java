package com.zym.pss.cargo.dao;

import java.util.Map;

import com.zym.pss.cargo.po.SaleOrder;
import com.zym.pss.core.dao.BaseDao;

public interface SaleOrderDao extends BaseDao<SaleOrder> {

	/**
	 * 删除销售订单下,所有要销售货物的信息
	 * @param paraMap
	 */
	public void deleteByOrderNo(Map<String, Object> paraMap);

}

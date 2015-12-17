package com.zym.pss.cargo.dao;

import java.util.Map;

import com.zym.pss.cargo.po.Stock;
import com.zym.pss.core.dao.BaseDao;

public interface StockDao extends BaseDao<Stock> {

	/**
	 * 通过货物编号,查询库存记录
	 * @param goodNo
	 * @param repositoryNo 
	 * @return
	 */
	public Stock findByGoodNo(Map<String, Object>  paraMap);
	/**
	 * 根据(物品编号和存储仓库)更新库存记录
	 * @param paraMap
	 */
	public void updateStockAmount(Map<String, Object> paraMap);

}

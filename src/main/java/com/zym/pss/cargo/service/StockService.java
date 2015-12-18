package com.zym.pss.cargo.service;

import com.zym.pss.cargo.po.Stock;
import com.zym.pss.core.service.BaseService;

public interface StockService extends BaseService<Stock> {

	/**
	 * 通过 (物品编号和存储的仓库)查询库存记录
	 * @param repositoryNo 
	 * @param string 
	 * @param string
	 */
	public Stock findByGoodNo(String goodNo, String repositoryNo, String tenantId);
	/**
	 * 根据(物品编号和存储仓库)更新库存量amount
	 * @param goodNo
	 * @param repositoryNo
	 * @param materialAmount 
	 */
	public void updateStockAmount(String tenantId , String goodNo, String repositoryNo, Double amout);

}

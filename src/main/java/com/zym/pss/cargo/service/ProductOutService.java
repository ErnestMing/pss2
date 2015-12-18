package com.zym.pss.cargo.service;

import com.zym.pss.cargo.po.ProductOut;
import com.zym.pss.core.service.BaseService;

public interface ProductOutService extends BaseService<ProductOut> {

	/**
	 * 更新出货单的状态
	 * @param ids
	 * @param state
	 */
	public void updateState(String[] ids, Integer state);
	
}

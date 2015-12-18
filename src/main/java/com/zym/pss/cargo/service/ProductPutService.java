package com.zym.pss.cargo.service;

import com.zym.pss.cargo.po.ProductPut;
import com.zym.pss.core.service.BaseService;

public interface ProductPutService extends BaseService<ProductPut> {

	public void updateState(String[] ids, Integer state);
	
}

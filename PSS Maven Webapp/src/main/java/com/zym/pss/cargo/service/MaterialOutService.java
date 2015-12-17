package com.zym.pss.cargo.service;

import com.zym.pss.cargo.po.MaterialOut;
import com.zym.pss.core.service.BaseService;

public interface MaterialOutService extends BaseService<MaterialOut> {

	public void updateState(String[] ids, Integer state);
	
}

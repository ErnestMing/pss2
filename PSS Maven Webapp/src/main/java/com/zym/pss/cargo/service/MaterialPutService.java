package com.zym.pss.cargo.service;

import com.zym.pss.cargo.po.MaterialPut;
import com.zym.pss.core.service.BaseService;

public interface MaterialPutService extends BaseService<MaterialPut> {

	public void updateState(String[] ids, Integer state);
	
}

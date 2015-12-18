package com.zym.pss.baseinfo.service;

import com.zym.pss.baseinfo.po.Material;
import com.zym.pss.core.service.BaseService;

public interface MaterialService extends BaseService<Material> {

	/**
	 * 通过原材料编号查询原材料信息
	 * @param materialNo
	 * @return
	 */
	public Material findByMaterialNo(String materialNo);
	
}

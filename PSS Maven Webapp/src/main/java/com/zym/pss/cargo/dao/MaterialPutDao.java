package com.zym.pss.cargo.dao;

import java.util.Map;

import com.zym.pss.cargo.po.MaterialPut;
import com.zym.pss.core.dao.BaseDao;

public interface MaterialPutDao extends BaseDao<MaterialPut> {
	/**
	 * 更新状态
	 * @param paramMap
	 */
	public void updateState(Map<String, Object>  paramMap);
}

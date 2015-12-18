package com.zym.pss.cargo.service;

import java.util.List;
import java.util.Map;

import com.zym.pss.cargo.vo.StockWarning;
import com.zym.pss.core.service.BaseService;

public interface StockWarningService extends BaseService<StockWarning> {

	/**
	 * 查询原材料上限预警信息
	 * @param object
	 * @return
	 */
	public List<StockWarning> findMUInfo(Map<String, Object> paraMap);
	/**
	 * 查询原材料下限预警信息
	 * @param object
	 * @return
	 */
	public List<StockWarning> findMLInfo(Map<String, Object> paraMap);
	/**
	 * 查询货物上限预警信息
	 * @param object
	 * @return
	 */
	public List<StockWarning> findPU(Map<String, Object> paraMap);
	/**
	 * 查询 货物下限预警信息
	 * @param object
	 * @return
	 */
	public List<StockWarning> findPL(Map<String, Object> paraMap);

}

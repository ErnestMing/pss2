package com.zym.pss.cargo.dao;

import java.util.List;
import java.util.Map;

import com.zym.pss.cargo.vo.StockWarning;
import com.zym.pss.core.dao.BaseDao;

public interface StockWarningDao extends BaseDao<StockWarning> {

	/**
	 * 查询原材料上限预警信息
	 * @param paraMap
	 * @return
	 */
	public List<StockWarning> findMU(Map<String, Object> paraMap);
	/**
	 * 查询原材料下限预警信息
	 * @param paraMap
	 * @return
	 */
	public List<StockWarning> findML(Map<String, Object> paraMap);
	/**
	 * 查询货物上限预警信息
	 * @param paraMap
	 * @return
	 */
	public List<StockWarning> findPU(Map<String, Object> paraMap);
	/**
	 * 查询货物下限预警信息
	 * @param paraMap
	 * @return
	 */
	public List<StockWarning> findPL(Map<String, Object> paraMap);

}

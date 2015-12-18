package com.zym.pss.multiTenant.dao;

import java.util.List;
import java.util.Map;

import com.zym.pss.multiTenant.po.Subsciber;
import com.zym.pss.multiTenant.vo.SubsciberVo;
import com.zym.pss.core.dao.BaseDao;

public interface SubsciberDao extends BaseDao<Subsciber> {

	/**
	 * 查询订购服务详细信息
	 */
	public List<SubsciberVo> findSubsciberVo(Map<String,Object> paraMap);

}

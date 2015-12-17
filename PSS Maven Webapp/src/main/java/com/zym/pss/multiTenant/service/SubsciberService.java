package com.zym.pss.multiTenant.service;

import java.util.List;
import java.util.Map;

import com.zym.pss.multiTenant.po.Subsciber;
import com.zym.pss.multiTenant.vo.SubsciberVo;
import com.zym.pss.core.service.BaseService;

public interface SubsciberService extends BaseService<Subsciber> {

	/**
	 * 查询订购详细信息
	 */
	public List<SubsciberVo> findSubsciberVoList(Map<String,Object> paraMap);
}


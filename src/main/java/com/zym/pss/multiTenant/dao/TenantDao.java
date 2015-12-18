package com.zym.pss.multiTenant.dao;

import java.util.Map;

import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.core.dao.BaseDao;

public interface TenantDao extends BaseDao<Tenant> {

	/**
	 * 更新状态
	 * @param paramMap
	 */
	public void updateState(Map<String, Object>  paramMap);
	/**
	 * 通过租户账号查询租户信息
	 * @param tenantNo
	 * @return
	 */
	public Tenant findByTenantNo(String tenantNo);

}

package com.zym.pss.multiTenant.service;

import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.core.service.BaseService;

public interface TenantService extends BaseService<Tenant> {

	/**
	 * 修改状态
	 * @param ids
	 */
	public void updateState(String[] ids,Integer state);

	/**
	 * 通过租户账号查询租户信息
	 * @param tenantNo
	 * @return
	 */
	public Tenant findByTenantNo(String tenantNo);
	
}

package com.zym.pss.multiTenant.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.multiTenant.dao.TenantDao;
import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.multiTenant.service.TenantService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("tenantService")
public class TenantServiceImpl extends BaseServiceImpl<Tenant> implements TenantService{
	
	TenantDao tenantDao ;
	@Resource
	public void setTenantDao(TenantDao tenantDao) {
		super.setBaseDao(tenantDao);
		this.tenantDao = tenantDao;
	}
	
	@Override
	public void insert(Tenant entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState(1);						//设置租户状态为启用
		this.tenantDao.insert(entity);
	}

	@Override
	public void updateState(String[] ids,Integer state) {
		Map<String,Object> paramMap = new HashMap<String , Object>();
		paramMap.put("state", state);
		paramMap.put("ids", ids);
		this.tenantDao.updateState(paramMap);
	}

	@Override
	public Tenant findByTenantNo(String tenantNo) {
		return this.tenantDao.findByTenantNo(tenantNo);
	}
}	

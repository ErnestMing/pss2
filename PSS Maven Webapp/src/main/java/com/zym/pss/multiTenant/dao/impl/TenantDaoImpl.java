package com.zym.pss.multiTenant.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.multiTenant.dao.TenantDao;
import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("tenantDao")
public class TenantDaoImpl extends BaseDaoImpl<Tenant> implements TenantDao {

	//设置命名空间
	public TenantDaoImpl() {
		super.setNs("com.zym.pss.multiTenant.mapper.TenantMapper");
	}

	@Override
	public void updateState(Map<String, Object>  paramMap) {
		super.getSqlSession().update(super.getNs()+".updateState", paramMap);
	}

	@Override
	public Tenant findByTenantNo(String tenantNo) {
		return super.getSqlSession().selectOne(super.getNs()+".findByTenantNo", tenantNo);
	}
}

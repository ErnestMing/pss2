package com.zym.pss.multiTenant.dao.impl;

import org.springframework.stereotype.Repository;

import com.zym.pss.multiTenant.dao.PricePolicyDao;
import com.zym.pss.multiTenant.po.PricePolicy;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("pricePolicyDao")
public class PricePolicyDaoImpl extends BaseDaoImpl<PricePolicy> implements PricePolicyDao {

	//设置命名空间
	public PricePolicyDaoImpl() {
		super.setNs("com.zym.pss.multiTenant.mapper.PricePolicyMapper");
	}
}

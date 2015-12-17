package com.zym.pss.multiTenant.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.multiTenant.dao.PricePolicyDao;
import com.zym.pss.multiTenant.po.PricePolicy;
import com.zym.pss.multiTenant.service.PricePolicyService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("pricePolicyService")
public class PricePolicyServiceImpl extends BaseServiceImpl<PricePolicy> implements PricePolicyService{
	
	PricePolicyDao pricePolicyDao ;
	@Resource
	public void setPricePolicyDao(PricePolicyDao pricePolicyDao) {
		super.setBaseDao(pricePolicyDao);
		this.pricePolicyDao = pricePolicyDao;
	}
	
	@Override
	public void insert(PricePolicy entity) {
		entity.setId(UUID.randomUUID().toString());
		this.pricePolicyDao.insert(entity);
	}
}	

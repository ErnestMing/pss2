package com.zym.pss.multiTenant.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.multiTenant.dao.SubsciberDao;
import com.zym.pss.multiTenant.po.Subsciber;
import com.zym.pss.multiTenant.service.SubsciberService;
import com.zym.pss.multiTenant.vo.SubsciberVo;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("subsciberService")
public class SubsciberServiceImpl extends BaseServiceImpl<Subsciber> implements SubsciberService{
	
	SubsciberDao subsciberDao ;
	@Resource
	public void setSubsciberDao(SubsciberDao subsciberDao) {
		super.setBaseDao(subsciberDao);
		this.subsciberDao = subsciberDao;
	}
	
	@Override
	public void insert(Subsciber entity) {
		entity.setId(UUID.randomUUID().toString());
		this.subsciberDao.insert(entity);
	}

	@Override
	public List<SubsciberVo> findSubsciberVoList(Map<String, Object> paraMap) {
		return this.subsciberDao.findSubsciberVo(paraMap);
	}
}	

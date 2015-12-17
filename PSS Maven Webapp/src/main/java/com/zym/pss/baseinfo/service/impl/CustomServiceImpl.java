package com.zym.pss.baseinfo.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.dao.CustomDao;
import com.zym.pss.baseinfo.po.Custom;
import com.zym.pss.baseinfo.service.CustomService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("customService")
public class CustomServiceImpl extends BaseServiceImpl<Custom> implements CustomService{
	
	CustomDao customDao ;
	@Resource
	public void setCustomDao(CustomDao customDao) {
		super.setBaseDao(customDao);
		this.customDao = customDao;
	}
	
	@Override
	public void insert(Custom entity) {
		entity.setId(UUID.randomUUID().toString());
		this.customDao.insert(entity);
	}
}	

package com.zym.pss.baseinfo.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import com.zym.pss.baseinfo.dao.RepositoryDao;
import com.zym.pss.baseinfo.po.Repository;
import com.zym.pss.baseinfo.service.RepositoryService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@org.springframework.stereotype.Repository("repositoryImpl")
public class RepositoryServiceImpl extends BaseServiceImpl<Repository> implements RepositoryService {

	RepositoryDao repositoryDao ;

	@Resource
	public void setRepositoryDao(RepositoryDao repositoryDao) {
		super.setBaseDao(repositoryDao);
		this.repositoryDao = repositoryDao;
	} 
	
	@Override
	public void insert(Repository entity) {
		//创建UUID主键
		entity.setId(UUID.randomUUID().toString());
		this.repositoryDao.insert(entity);
	}
	
}

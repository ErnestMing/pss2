package com.zym.pss.baseinfo.dao.impl;

import com.zym.pss.baseinfo.dao.RepositoryDao;
import com.zym.pss.baseinfo.po.Repository;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@org.springframework.stereotype.Repository("repositoryDao")
public class RepositoryDaoImpl extends BaseDaoImpl<Repository> implements RepositoryDao {

	public RepositoryDaoImpl() {
		super.setNs("com.zym.pss.baseinfo.mapper.RepositoryMapper");
	}
}

package com.zym.pss.core.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.zym.pss.core.dao.BaseDao;
import com.zym.pss.core.pargination.Page;
import com.zym.pss.core.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	BaseDao<T> baseDao ; 

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<T> findPage(Page page) {
		return this.baseDao.findPage(page);
	}

	@Override
	public List<T> find(Map paraMap) {
		return this.baseDao.find(paraMap);
	}

	@Override
	public T get(Serializable id) {
		return this.baseDao.get(id);
	}

	@Override
	public void insert(T entity) {
		this.baseDao.insert(entity);
	}

	@Override
	public void update(T entity) {
		this.baseDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		this.baseDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		this.baseDao.delete(ids);
	}

}

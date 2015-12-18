package com.zym.pss.core.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.zym.pss.core.dao.BaseDao;
import com.zym.pss.core.pargination.Page;

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

	//spring-mybatis1.0 无需此方法,spring-mybatis-1.2 必须注入
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	//命名空间
	private String ns ; 
	
	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}
	
	@Override
	public List<T> findPage(Page page) {
		return this.getSqlSession().selectList(this.getNs()+".findPage", page);
	}

	@Override
	public List<T> find(Map map) {
		return this.getSqlSession().selectList(ns+".find", map);
	}

	@Override
	public T get(Serializable id) {
		return this.getSqlSession().selectOne(ns+".get", id);
	}

	@Override
	public void insert(T entity) {
		this.getSqlSession().insert(ns + ".insert", entity);
	}

	@Override
	public void update(T entity) {
		this.getSqlSession().update(ns+".update", entity);
	}

	@Override
	public void deleteById(Serializable id) {
		this.getSqlSession().delete(ns + ".deleteById", id);
	}

	@Override
	public void delete(Serializable[] ids) {
		this.getSqlSession().delete(ns + ".delete", ids);
	}

}

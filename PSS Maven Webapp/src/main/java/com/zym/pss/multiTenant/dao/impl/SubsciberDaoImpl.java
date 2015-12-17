package com.zym.pss.multiTenant.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.multiTenant.dao.SubsciberDao;
import com.zym.pss.multiTenant.po.Subsciber;
import com.zym.pss.multiTenant.vo.SubsciberVo;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("subsciberDao")
public class SubsciberDaoImpl extends BaseDaoImpl<Subsciber> implements SubsciberDao {

	//设置命名空间
	public SubsciberDaoImpl() {
		super.setNs("com.zym.pss.multiTenant.mapper.SubsciberMapper");
	}

	@Override
	public List<SubsciberVo> findSubsciberVo(Map<String, Object> paraMap) {
		return super.getSqlSession().selectList(super.getNs()+".findVO",paraMap);
	}
}

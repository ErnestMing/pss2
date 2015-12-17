package com.zym.pss.sysadmin.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.zym.pss.sysadmin.dao.RoleFuncsDao;
import com.zym.pss.sysadmin.po.RoleFuncs;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("roleFuncsDao")
public class RoleFuncsDaoImpl extends BaseDaoImpl<RoleFuncs> implements RoleFuncsDao {

	//设置命名空间
	public RoleFuncsDaoImpl() {
		super.setNs("com.zym.pss.sysadmin.mapper.RoleFuncsMapper");
	}

	@Override
	public void deleteRoleFuncsRelation(Serializable roleId) {
		super.getSqlSession().selectList(super.getNs()+".deleteRelation", roleId);
	}
}

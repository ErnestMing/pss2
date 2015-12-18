package com.zym.pss.sysadmin.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.zym.pss.sysadmin.dao.UserRolesDao;
import com.zym.pss.sysadmin.po.UserRoles;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("userRolesDao")
public class UserRolesDaoImpl extends BaseDaoImpl<UserRoles> implements UserRolesDao {

	//设置命名空间
	public UserRolesDaoImpl() {
		super.setNs("com.zym.pss.sysadmin.mapper.UserRolesMapper");
	}

	@Override
	public void deleteUserRoleRelation(Serializable userId) {
		super.getSqlSession().selectList(super.getNs()+".deleteRelation", userId);
	}
}

package com.zym.pss.sysadmin.dao;

import java.io.Serializable;

import com.zym.pss.sysadmin.po.UserRoles;
import com.zym.pss.core.dao.BaseDao;

public interface UserRolesDao extends BaseDao<UserRoles> {

	/**
	 * 删除用户与角色之间的关系
	 * @param userId
	 */
	public void deleteUserRoleRelation(Serializable userId);

}

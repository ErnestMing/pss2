package com.zym.pss.sysadmin.dao;

import java.io.Serializable;

import com.zym.pss.sysadmin.po.RoleFuncs;
import com.zym.pss.core.dao.BaseDao;

public interface RoleFuncsDao extends BaseDao<RoleFuncs> {

	/**
	 * 删除角色与 权限之间的关系
	 * @param roleId
	 */
	public void deleteRoleFuncsRelation(Serializable roleId);

}

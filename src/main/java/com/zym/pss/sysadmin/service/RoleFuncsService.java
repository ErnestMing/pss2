package com.zym.pss.sysadmin.service;

import java.io.Serializable;

import com.zym.pss.sysadmin.po.RoleFuncs;
import com.zym.pss.core.service.BaseService;

public interface RoleFuncsService extends BaseService<RoleFuncs> {

	/**
	 * 检验该角色功能关系是否存在
	 * @param roleId
	 * @param functionId
	 */
	public Boolean isValidate(String roleId, String functionId);

	/**
	 * 删除角色与权限之间的关系
	 * @param serializable
	 */
	public void deleteRoleFuncsRelation(Serializable roleId );

}

package com.zym.pss.sysadmin.service;

import java.io.Serializable;

import com.zym.pss.sysadmin.po.UserRoles;
import com.zym.pss.core.service.BaseService;

public interface UserRolesService extends BaseService<UserRoles> {

	/**
	 * 验证该关联关系是否存在
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public Boolean isValidate(String userId, String roleId);

	/**
	 * 删除用户与角色之间的关系
	 * @param serializable
	 */
	public void deleteUserRoleRelation(Serializable userId);

}

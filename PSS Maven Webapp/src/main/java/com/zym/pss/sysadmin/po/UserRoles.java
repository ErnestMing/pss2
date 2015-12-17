package com.zym.pss.sysadmin.po;

import java.io.Serializable;
/**
 * @Description:用户角色关联实体
 * @Author: zym
 * @CreateDate: 2015年12月1日
 */
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 4398340091037487656L;

	private String id ; 		//id
	private String userId ; 		//用户ID
	private String roleId ; 		//角色ID
	
	public UserRoles() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}

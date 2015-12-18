package com.zym.pss.sysadmin.vo;

import java.io.Serializable;
/**
 * @Description:用户角色VO
 * @Author: zym
 * @CreateDate: 2015年12月2日
 */
public class UserRolesVo implements Serializable {

	private static final long serialVersionUID = -2400674881969336763L;

	private String userId ; 			//用户ID
	private String userNo ; 			//用户编号
	
	private String userRoleId ; 		//用户角色关联表ID
	
	private String roleId ; 			//角色ID
	private String roleName ; 			//角色名称
	
	public UserRolesVo() {
		super();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
}

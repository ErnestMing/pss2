package com.zym.pss.sysadmin.po;

import java.io.Serializable;
/**
 * @Description:角色和功能(资源)关联表
 * @Author: zym
 * @CreateDate: 2015年12月1日
 */
public class RoleFuncs implements Serializable {

	private static final long serialVersionUID = -2579389673334940495L;

	private String id ; 			//id
	private String roleId ; 		//角色ID 
	private String functionId ; 	//资源ID
	
	public RoleFuncs() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
}

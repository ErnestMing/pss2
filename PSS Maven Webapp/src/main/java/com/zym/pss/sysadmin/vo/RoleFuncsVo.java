package com.zym.pss.sysadmin.vo;

import java.io.Serializable;

public class RoleFuncsVo implements Serializable{

	private static final long serialVersionUID = -2095819928882188034L;

	private String roleId ; 		//角色ID
	private String roleNo ; 		//角色编号
	private String roleName ; 		//角色名称
	
	private String roleFuncsID ; 	//角色功能关联ID
	
	private String functionNo ; 	//资源编号
	private String functionURL ; 	//资源URL
	private String functionName ; 	//资源名称
	
	public RoleFuncsVo() {
		super();
	}
	
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getFunctionNo() {
		return functionNo;
	}
	public void setFunctionNo(String functionNo) {
		this.functionNo = functionNo;
	}
	public String getFunctionURL() {
		return functionURL;
	}
	public void setFunctionURL(String functionURL) {
		this.functionURL = functionURL;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleFuncsID() {
		return roleFuncsID;
	}

	public void setRoleFuncsID(String roleFuncsID) {
		this.roleFuncsID = roleFuncsID;
	}
}

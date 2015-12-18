package com.zym.pss.sysadmin.po;

import java.io.Serializable;
/**
 * @Description:角色 PO类 
 * @Author: zym
 * @CreateDate: 2015年12月1日
 */
public class Role implements Serializable{

	private static final long serialVersionUID = -6475223846310164645L;

	private String id ; 			//记录主键
	private String roleNo ; 		//角色编号
	private String name ; 			//角色名称
	private String description ; 			//角色描述
	private String tenantId ; 		//所属租户ID
	
	public Role() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}

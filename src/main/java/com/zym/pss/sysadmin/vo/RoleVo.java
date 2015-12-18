package com.zym.pss.sysadmin.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zym.pss.sysadmin.po.Function;

/**
 * @Description:角色VO类
 * @Author: zym
 * @CreateDate: 2015年12月3日
 */
public class RoleVo implements Serializable{

	private static final long serialVersionUID = -1200892983230406908L;

	private String id ; 			//记录主键
	
	//角色功能列表
	List<Function> roleFuncs = new ArrayList<Function>(); 
	
	private String roleNo ; 		//角色编号
	private String name ; 			//角色名称
	private String description ; 			//角色描述
	private String tenantId ; 		//所属租户ID
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Function> getRoleFuncs() {
		return roleFuncs;
	}
	public void setRoleFuncs(List<Function> roleFuncs) {
		this.roleFuncs = roleFuncs;
	}
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

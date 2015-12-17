package com.zym.pss.sysadmin.po;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -8506626611830661886L;

	private String id ; 			//用户ID
	private String userNo ; 		//用户编号
	private String password ; 		//密码
	private String telephone ; 		//联系方式
	private String email ; 			//邮箱
	private String address ; 		//地址
	private Integer status ; 		//状态
	private String tenantId ; 		//所属租户ID
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}

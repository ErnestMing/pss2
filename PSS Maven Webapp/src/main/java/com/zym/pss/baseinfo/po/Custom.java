package com.zym.pss.baseinfo.po;

import java.io.Serializable;
/**
 * @Description:客户信息
 * @Author: zym
 * @CreateDate: 2015年11月18日
 */
public class Custom implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id ; 			//ID
	private String customNo ; 			//客户编号
	private String name ; 				//客户名称
	private String shortName ; 			//简称
	private String contacts ; 			//联系人
	private String address ; 			//地址
	private String email ;				//邮编
	private String mobile ; 			//电话
	private String fax ; 				//传真
	private String memo ; 				//备注
	
	private String tenantId  ; 			//所属租户ID
	
	public Custom() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomNo() {
		return customNo;
	}
	public void setCustomNo(String customNo) {
		this.customNo = customNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}

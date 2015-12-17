package com.zym.pss.baseinfo.po;

import java.io.Serializable;
/**
 * @Description:供应商信息
 * @Author: zym
 * @CreateDate: 2015年11月17日
 */
public class Supplier implements Serializable{

	private static final long serialVersionUID = -4460022774866690178L;
	
	private String id ; 			//ID
	private String supplierName ; 	//供应商名称
	private String supplierNo ; 	//供应商编号
	private String shortName ; 		//简称
	private String contarcts ; 		//联系人
	private String address ; 		//地址
	private String email ; 			//邮箱
	private String mobile ; 		//电话
	private String phone ; 			//手机
	private String fax ; 			//传真
	private String memo ; 			//备注
	
	private String tenantId ; 		//所属租户ID
	
	public Supplier() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getContarcts() {
		return contarcts;
	}
	public void setContarcts(String contarcts) {
		this.contarcts = contarcts;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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

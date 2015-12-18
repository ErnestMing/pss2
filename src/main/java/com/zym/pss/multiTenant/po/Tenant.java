package com.zym.pss.multiTenant.po;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * @Description:租户信息PO类
 * @Author: zym
 * @CreateDate: 2015年12月8日
 */
public class Tenant implements Serializable{

	private static final long serialVersionUID = 2001298478417522783L;

	private String id ; 			//ID
	private String tenantNo  ;  	//租户编号
	private String password ; 		//租户密码
	private String name ; 			//租户名称
	private String company ; 		//所属企业
	private String contactor ;		//联系人
	private String address ; 		//地址
	private String telephone ; 		//联系电话
	private Integer state ; 		//状态
	
	/**
	 * 租户状态:1：待审核 2：启用 3：禁用 4:登录  5:未登录
	 */
	public static Map<String,Object> TENATN_STATE = new HashMap<String,Object>();
	
	private static final String TENANT_STATE_VALID = "启用" ;
	private static final String TENANT_STATE_INVALID = "禁用" ;
	private static final String TENANT_STATE_LOGIN = "已登录" ;
	private static final String TENANT_STATE_LOGOUT = "未登录" ;

	static{
		TENATN_STATE.put("1",TENANT_STATE_VALID) ;
		TENATN_STATE.put("2",TENANT_STATE_INVALID) ;
		TENATN_STATE.put("3",TENANT_STATE_LOGIN) ;
		TENATN_STATE.put("4",TENANT_STATE_LOGOUT) ;
	}
	
	
	public Tenant() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenantNo() {
		return tenantNo;
	}
	public void setTenantNo(String tenantNo) {
		this.tenantNo = tenantNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}
}

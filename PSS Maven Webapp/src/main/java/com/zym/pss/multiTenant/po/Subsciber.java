package com.zym.pss.multiTenant.po;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description:服务订阅记录
 * @Author: zym
 * @CreateDate: 2015年12月10日
 */
public class Subsciber implements Serializable {

	private static final long serialVersionUID = 6270873383804075952L;

	private String id ; 				//订阅记录ID
	private String tenantId ; 			//租户ID
	private String functionId ; 		//价格策略ID
	private Date beginDate ; 			//开始日期
	private Date endDate ;				//结束日期
	private Date supsciberDate ; 		//订购日期
	private Integer remainder ; 		//剩余服务天数
	
	public Subsciber() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getSupsciberDate() {
		return supsciberDate;
	}
	public void setSupsciberDate(Date supsciberDate) {
		this.supsciberDate = supsciberDate;
	}
	public Integer getRemainder() {
		return remainder;
	}
	public void setRemainder(Integer remainder) {
		this.remainder = remainder;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
}

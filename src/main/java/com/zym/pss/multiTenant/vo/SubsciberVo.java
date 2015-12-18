package com.zym.pss.multiTenant.vo;

import java.io.Serializable;
import java.util.Date;

import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.sysadmin.vo.FunctionVO;
/**
 * @Description:服务订阅VO类
 * @Author: zym
 * @CreateDate: 2015年12月10日
 */
public class SubsciberVo implements Serializable{

	private static final long serialVersionUID = -3031688295013276861L;

	//关联对象
	private Tenant tenant ; 			//租户信息
	private FunctionVO function ; 	//功能模块信息
	
	private String id ; 				//订阅记录ID
	private String tenantId ; 			//租户ID
	private String functionId ; 		//价格策略ID
	private Date beginDate ; 			//开始日期
	private Date endDate ;				//结束日期
	private Date supsciberDate ; 		//订购日期
	private Integer remainder ; 		//剩余服务天数(Oracle计算)
	
	
	public SubsciberVo() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public FunctionVO getFunction() {
		return function;
	}

	public void setFunction(FunctionVO function) {
		this.function = function;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
}

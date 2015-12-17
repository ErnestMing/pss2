package com.zym.pss.sysadmin.vo;

import java.io.Serializable;

import com.zym.pss.multiTenant.po.PricePolicy;
/**
 * @Description:Function服务和价格策略关联VO类
 * @Author: zym
 * @CreateDate: 2015年12月10日
 */
public class FunctionVO implements Serializable {

	private static final long serialVersionUID = -6071648755654112126L;

	private String id ; 				//资源ID
	private String functionNo ; 		//资源编号
	private String functionURL ; 		//资源URL
	private String functionName ; 		//资源名称
	private String description ; 		//资源描述
	
	private PricePolicy pricePolicy ; 			//价格策略

	public FunctionVO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PricePolicy getPricePolicy() {
		return pricePolicy;
	}

	public void setPricePolicy(PricePolicy pricePolicy) {
		this.pricePolicy = pricePolicy;
	}
}

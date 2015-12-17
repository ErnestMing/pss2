package com.zym.pss.multiTenant.po;

import java.io.Serializable;
/**
 * @Description:价格策略(制定模块对应的价格)
 * @Author: zym
 * @CreateDate: 2015年12月10日
 */
public class PricePolicy implements Serializable {

	private static final long serialVersionUID = -5176817025762476330L;

	private String id ; 				//价格策略ID
	private String pricepolicyNo ; 		//策略编号
	private String functionNo ; 		//模块编号
	private String functionName ; 		//模块名称
	private String unit ; 				//价格单位
	private Double price ; 				//价格
	
	public PricePolicy() {
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
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPricepolicyNo() {
		return pricepolicyNo;
	}

	public void setPricepolicyNo(String pricepolicyNo) {
		this.pricepolicyNo = pricepolicyNo;
	}
}

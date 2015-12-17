package com.zym.pss.cargo.po;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description:采购订单表
 * @Author: zym
 * @CreateDate: 2015年11月18日
 */
public class SaleOrder implements Serializable {

	private static final long serialVersionUID = 1073255298222301388L;

	private String id ; 				//ID
	
	private String salesOrderNo ; 		//销售订单编号
	private String customNo ; 			//客户编号
	private String customName ; 		//客户名称
	private String productNo ; 			//货物编号
	private String productName ; 		//货物名称
	private Double productAmount ; 		//货物数量
	private String packingUnit ; 		//包装单位
	private Date saleTime ; 			//销售日期
	private Date validStartTime ; 		//有效起日
	private Date validEndTime ; 		//有效止日
	
	private String tenantId ; 			//所属租户
	
	public SaleOrder() {
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
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}
	public Date getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}
	public Date getValidStartTime() {
		return validStartTime;
	}
	public void setValidStartTime(Date validStartTime) {
		this.validStartTime = validStartTime;
	}
	public Date getValidEndTime() {
		return validEndTime;
	}
	public void setValidEndTime(Date validEndTime) {
		this.validEndTime = validEndTime;
	}
	public String getSalesOrderNo() {
		return salesOrderNo;
	}
	public void setSalesOrderNo(String salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}

	public String getPackingUnit() {
		return packingUnit;
	}

	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
package com.zym.pss.cargo.po;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description:采购订单表
 * @Author: zym
 * @CreateDate: 2015年11月18日
 */
public class PurchaseOrder implements Serializable {

	private static final long serialVersionUID = 1073255298222301388L;

	private String id ; 				//ID
	private String purchaseOrderNo ; 	//采购订单编号
	private String materialNo ; 		//原材料编号
	private String materialName ; 		//原材料名称
	private String supplierNo ; 		//提供商编号
	private String supplierName ; 		//供货商名称
	private String phone ; 				//提供商的联系方式
	private String packingUnit ; 		//包装单位
	private Double materialAmount ; 	//采购原材料数量
	private Date purchaseTime ; 		//采购日期
	
	private String tenantId ; 			//所属租户
	
	public PurchaseOrder() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPackingUnit() {
		return packingUnit;
	}

	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}

	public Double getMaterialAmount() {
		return materialAmount;
	}

	public void setMaterialAmount(Double materialAmount) {
		this.materialAmount = materialAmount;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getSupplierNo() {
		return supplierNo;
	}

	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}

	public Date getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
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
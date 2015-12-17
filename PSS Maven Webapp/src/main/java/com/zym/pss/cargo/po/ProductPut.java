package com.zym.pss.cargo.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:货物入库
 * @Author: zym
 * @CreateDate: 2015年11月21日
 */
public class ProductPut implements Serializable {

	private static final long serialVersionUID = 6824378484398003418L;
	
	private String id ; 			//ID
	private String productNo ; 			//货物编号
	private String productName ; 		//货物名称
	private Double productAmount ; 		//货物数量
	private String packingUnit ; 		//包装单位
	private String operator ; 			//经办人
	private String repositoryNo ; 		//仓库编号
	private Date putTime ; 				//入库时间
	private Integer state ; 			//出库单状态
	private String memo ; 				//备注
	
	private String tenantId ; 			//所属租户
	
	public ProductPut() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getRepositoryNo() {
		return repositoryNo;
	}
	public void setRepositoryNo(String repositoryNo) {
		this.repositoryNo = repositoryNo;
	}
	public Date getPutTime() {
		return putTime;
	}
	public void setPutTime(Date putTime) {
		this.putTime = putTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Double getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
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

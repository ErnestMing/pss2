package com.zym.pss.cargo.po;

import java.io.Serializable;
/**
 * @Description:库存表
 * @Author: zym
 * @CreateDate: 2015年11月20日
 */
public class Stock implements Serializable{

	private static final long serialVersionUID = 9068830962990816948L;

	private String id ; 			//库存记录ID
	private String repositoryNo ; 		//仓库编号
	private String goodsNo ; 			//物品编号
	private String goodsName ; 			//物品名称
	private String goodsType ; 			//物品类型
	private Double amount ; 			//库存量
	private String packingUnit ; 		//包装单位
	
	private String tenantId ; 			//所属租户
	
	public Stock() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRepositoryNo() {
		return repositoryNo;
	}
	public void setRepositoryNo(String repositoryNo) {
		this.repositoryNo = repositoryNo;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

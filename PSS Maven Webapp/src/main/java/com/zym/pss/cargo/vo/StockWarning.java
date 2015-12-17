package com.zym.pss.cargo.vo;

import java.io.Serializable;

/**
 * @Description:库存预警业务对象
 * @Author: zym
 * @CreateDate: 2015年11月25日
 */
public class StockWarning implements Serializable {

	private static final long serialVersionUID = -8111308394314856059L;

	private String repositoryNo ; 			//仓库编号
	private String goodsNo ; 				//物品编号
	private String goodsName ; 				//物品名称
	private String goodsType ; 				//物品类型
	private String packingUnit ; 			//包装单位
	private Double amount ; 			//当前库存量
	private Double overUpperAmount ; 			//超出上限数量
	private Double overLowerAmount ; 			//低于下限数量
	
	public StockWarning() {
		super();
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
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getOverUpperAmount() {
		return overUpperAmount;
	}

	public void setOverUpperAmount(Double overUpperAmount) {
		this.overUpperAmount = overUpperAmount;
	}

	public Double getOverLowerAmount() {
		return overLowerAmount;
	}

	public void setOverLowerAmount(Double overLowerAmount) {
		this.overLowerAmount = overLowerAmount;
	}
}

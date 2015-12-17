package com.zym.pss.cargo.po;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description:领料出库单
 * @Author: zym
 * @CreateDate: 2015年11月19日
 */
public class MaterialOut implements Serializable{

	private static final long serialVersionUID = 6259647548737174658L;
	
	private String id  ; 			//ID
	private String materialNo ; 		//原材料编号
	private String materialName ; 		//原材料名称
	private Double materialAmount ; 	//原材料数量
	private String packingUnit ; 		//包装单位
	private String pickingPeople ; 		//领料人
	private String operator ; 			//操作者
	private Date outTime ; 				//出库时间
	private String repositoryNo ; 		//仓库编号
	private Integer State ; 			//状态
	private String memo ; 				//备注
	
	private String tenantId ; 			//所属租户ID
	
	public MaterialOut() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMaterialNo() {
		return materialNo;
	}
	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}
	public String getPickingPeople() {
		return pickingPeople;
	}
	public void setPickingPeople(String pickingPeople) {
		this.pickingPeople = pickingPeople;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Double getMaterialAmount() {
		return materialAmount;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public void setMaterialAmount(Double materialAmount) {
		this.materialAmount = materialAmount;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Integer getState() {
		return State;
	}

	public void setState(Integer state) {
		State = state;
	}

	public String getRepositoryNo() {
		return repositoryNo;
	}

	public void setRepositoryNo(String repositoryNo) {
		this.repositoryNo = repositoryNo;
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

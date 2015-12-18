package com.zym.pss.cargo.po;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description:原材料入库
 * @Author: zym
 * @CreateDate: 2015年11月20日
 */
public class MaterialPut implements Serializable{

	private static final long serialVersionUID = 6907071313182991084L;

	private String id ; 			//ID 
	private String materialNo ; 		//原材料编号
	private String materialName ; 		//原材料名称
	private Double materialAmount ; 	//原材料数量
	private String packingUnit ; 		//包装单位
	private String operator ; 			//经办人
	private String repositoryNo ; 		//仓库编号
	private Date putTime ; 				//入库时间
	private Integer state ; 			//状态
	private String memo ; 				//备注
	
	private String tenantId ; 			//所属租户
	
	public MaterialPut() {
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
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
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
	public Double getMaterialAmount() {
		return materialAmount;
	}
	public void setMaterialAmount(Double materialAmount) {
		this.materialAmount = materialAmount;
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

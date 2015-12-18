package com.zym.pss.cargo.po;

import java.io.Serializable;
/**
 * @Description:上下限表,仓库中存储原材料的上/下限
 * @Author: Administrator
 * @CreateDate: 2015年11月17日
 */
public class MaterialULL implements Serializable{
	
	private static final long serialVersionUID = -8215051858241037411L;

	private String id ; 				//主键
	private String repositoryNo;		//仓库编号 :关联到仓库编号
	private String materialNo ; 		//原材料编号
	private String materialName ; 		//原材料名称
	private Double upperAmount ; 		//上限数量:可能为 重量
	private Double lowerAmount ;		//下限数量
	private Double bestAmount ;			//最佳数量
	private String packingUnit ; 		//包装单位
	private String memo ; 				//备注信息
	
	private String tenantId ; 			//所属租户
	
	public MaterialULL() {
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

	public Double getUpperAmount() {
		return upperAmount;
	}

	public void setUpperAmount(Double upperAmount) {
		this.upperAmount = upperAmount;
	}

	public Double getLowerAmount() {
		return lowerAmount;
	}

	public void setLowerAmount(Double lowerAmount) {
		this.lowerAmount = lowerAmount;
	}

	public Double getBestAmount() {
		return bestAmount;
	}

	public void setBestAmount(Double bestAmount) {
		this.bestAmount = bestAmount;
	}

	public String getPackingUnit() {
		return packingUnit;
	}

	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

package com.zym.pss.baseinfo.po;

import java.io.Serializable;
/**
 * @Description:原材料PO类
 * @Author: zym
 * @CreateDate: 2015年11月17日
 */
public class Material implements Serializable {

	private static final long serialVersionUID = 6832938658611969150L;

	private String id ; 		//ID 
	private String materialNo ; 	//原材料编号
	private String name ; 			//名称
	private String specification ;	//规格
	private String packingUnit ; 	//包装单位
	private Double price ; 			//价格
	private String memo ; 			//备注
	
	private String tenantId ; 		//所属租户ID
	
	public Material() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
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


package com.zym.pss.baseinfo.po;

import java.io.Serializable;
/**
 * @Description:产品/货物信息
 * @Author: zym
 * @CreateDate: 2015年11月17日
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 4248963416816605713L;

	private String id ;			//ID 
	private String name ; 			//货物名称
	private String productNo ; 		//货物编号
	private String barCode ; 		//条形码
	private String specification ; 	//规格
	private String packingUnit ; 	//包装单位
	private Double price ; 			//价格
	private String description ; 	//描述
	private String memo ; 			//备注
	
	private String tenantId ; 		//所属租户ID

	public Product() {
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

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

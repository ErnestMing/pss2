package com.zym.pss.baseinfo.po;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description: 仓库表
 * @Author: Administrator
 * @CreateDate: 2015年11月16日
 */
public class Repository implements Serializable {

	private static final long serialVersionUID = -5350665581780582692L;
	
	private String id ; 			//仓库ID
	private String repositoryNo ; 	//仓库编号
	private String name ; 			//仓库名称
	private String shortName ; 		//仓库简称
	private String type ; 			//仓库类别: 1--原材料仓库 ; 2 --货物仓库
	private Date createTime ;		//创建时间 
	private String location ; 		//仓库位置
	private String area ; 			//仓库面积
	private String memo ; 			//备注
	
	private String tenantId ; 		//所属租户ID
	
	public Repository() {}
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

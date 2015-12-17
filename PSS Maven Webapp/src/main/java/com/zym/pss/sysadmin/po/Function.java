package com.zym.pss.sysadmin.po;

import java.io.Serializable;
/**
 * @Description:资源 PO类
 * @Author: zym
 * @CreateDate: 2015年12月1日
 */
public class Function implements Serializable{

	private static final long serialVersionUID = -1249097035134197191L;

	private String id ; 				//资源ID
	private String functionNo ; 		//资源编号
	private String functionURL ; 		//资源URL
	private String functionName ; 		//资源名称
	private String description ; 		//资源描述
	
	public Function() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getFunctionNo() {
		return functionNo;
	}

	public void setFunctionNo(String functionNo) {
		this.functionNo = functionNo;
	}

	public String getFunctionURL() {
		return functionURL;
	}

	public void setFunctionURL(String functionURL) {
		this.functionURL = functionURL;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((functionName == null) ? 0 : functionName.hashCode());
		result = prime * result
				+ ((functionNo == null) ? 0 : functionNo.hashCode());
		result = prime * result
				+ ((functionURL == null) ? 0 : functionURL.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Function other = (Function) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (functionName == null) {
			if (other.functionName != null)
				return false;
		} else if (!functionName.equals(other.functionName))
			return false;
		if (functionNo == null) {
			if (other.functionNo != null)
				return false;
		} else if (!functionNo.equals(other.functionNo))
			return false;
		if (functionURL == null) {
			if (other.functionURL != null)
				return false;
		} else if (!functionURL.equals(other.functionURL))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

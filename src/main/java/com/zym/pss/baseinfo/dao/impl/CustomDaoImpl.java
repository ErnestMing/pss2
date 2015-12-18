package com.zym.pss.baseinfo.dao.impl;

import org.springframework.stereotype.Repository;

import com.zym.pss.baseinfo.dao.CustomDao;
import com.zym.pss.baseinfo.po.Custom;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("customDao")
public class CustomDaoImpl extends BaseDaoImpl<Custom> implements CustomDao {

	//设置命名空间
	public CustomDaoImpl() {
		super.setNs("com.zym.pss.baseinfo.mapper.CustomMapper");
	}
}

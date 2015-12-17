package com.zym.pss.baseinfo.dao.impl;

import org.springframework.stereotype.Repository;

import com.zym.pss.baseinfo.dao.MaterialDao;
import com.zym.pss.baseinfo.po.Material;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("materialDao")
public class MaterialDaoImpl extends BaseDaoImpl<Material> implements MaterialDao {

	//设置命名空间
	public MaterialDaoImpl() {
		super.setNs("com.zym.pss.baseinfo.mapper.MaterialMapper");
	}
}

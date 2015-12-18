package com.zym.pss.cargo.dao.impl;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.MaterialULLDao;
import com.zym.pss.cargo.po.MaterialULL;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("materialULLDao")
public class MaterialULLDaoImpl extends BaseDaoImpl<MaterialULL> implements MaterialULLDao {
	
	//设置命名空间
	public MaterialULLDaoImpl() {
		super.setNs("com.zym.pss.baseinfo.mapper.MaterialULLMapper");
	}

}

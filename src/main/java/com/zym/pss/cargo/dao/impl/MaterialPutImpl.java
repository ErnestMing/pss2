package com.zym.pss.cargo.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.MaterialPutDao;
import com.zym.pss.cargo.po.MaterialPut;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("materialPutDao")
public class MaterialPutImpl extends BaseDaoImpl<MaterialPut> implements MaterialPutDao {

	//设置命名空间
	public MaterialPutImpl() {
		super.setNs("com.zym.pss.cargo.mapper.MaterialPutMapper");
	}
	
	@Override
	public void updateState(Map<String, Object>  paramMap) {
		super.getSqlSession().update(super.getNs()+".updateState", paramMap);
	}
}

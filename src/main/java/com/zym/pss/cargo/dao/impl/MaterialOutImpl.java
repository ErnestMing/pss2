package com.zym.pss.cargo.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.MaterialOutDao;
import com.zym.pss.cargo.po.MaterialOut;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("materialOutDao")
public class MaterialOutImpl extends BaseDaoImpl<MaterialOut> implements MaterialOutDao {

	//设置命名空间
	public MaterialOutImpl() {
		super.setNs("com.zym.pss.cargo.mapper.MaterialOutMapper");
	}
	
	@Override
	public void updateState(Map<String, Object>  paramMap) {
		super.getSqlSession().update(super.getNs()+".updateState", paramMap);
	}
}

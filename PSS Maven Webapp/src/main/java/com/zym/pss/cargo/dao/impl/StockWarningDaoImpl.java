package com.zym.pss.cargo.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.StockWarningDao;
import com.zym.pss.cargo.vo.StockWarning;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("stockWarningDao")
public class StockWarningDaoImpl extends BaseDaoImpl<StockWarning> implements StockWarningDao {

	//设置命名空间
	public StockWarningDaoImpl() {
		super.setNs("com.zym.pss.cargo.mapper.StockWarningMapper");
	}

	@Override
	public List<StockWarning> findMU(Map<String, Object> paraMap) {
		return super.getSqlSession().selectList(super.getNs()+".findMU", paraMap);
	}

	@Override
	public List<StockWarning> findML(Map<String, Object> paraMap) {
		return super.getSqlSession().selectList(super.getNs()+".findML", paraMap);
	}

	@Override
	public List<StockWarning> findPU(Map<String, Object> paraMap) {
		return super.getSqlSession().selectList(super.getNs()+".findPU", paraMap);
	}

	@Override
	public List<StockWarning> findPL(Map<String, Object> paraMap) {
		return super.getSqlSession().selectList(super.getNs()+".findPL", paraMap);
	}
	
}

package com.zym.pss.cargo.dao.impl;

import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.zym.pss.cargo.dao.StockDao;
import com.zym.pss.cargo.po.Stock;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock> implements StockDao {

	//设置命名空间
	public StockDaoImpl() {
		super.setNs("com.zym.pss.cargo.mapper.StockMapper");
	}
	@Override
	public void insert(Stock entity) {
		entity.setId(UUID.randomUUID().toString());
		super.insert(entity);
	}

	@Override
	public Stock findByGoodNo(Map<String, Object>  paraMap) {
		return super.getSqlSession().selectOne(super.getNs()+".findByGoodNo", paraMap);
	}

	@Override
	public void updateStockAmount(Map<String, Object> paraMap) {
		super.getSqlSession().update(super.getNs()+".updateStockAmount", paraMap);
	}
}

package com.zym.pss.cargo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.cargo.dao.StockDao;
import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.service.StockService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("stockService")
public class StockServiceImpl extends BaseServiceImpl<Stock> implements StockService{
	
	StockDao stockDao ;
	@Resource
	public void setStockDao(StockDao stockDao) {
		super.setBaseDao(stockDao);
		this.stockDao = stockDao;
	}
	
	@Override
	public void insert(Stock entity) {
		entity.setId(UUID.randomUUID().toString());
		this.stockDao.insert(entity);
	}

	@Override
	public Stock findByGoodNo(String tenantId , String goodNo,String repositoryNo) {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("goodNo", goodNo);
		paraMap.put("repositoryNo", repositoryNo);
		paraMap.put("tenantId", tenantId);
		
		return this.stockDao.findByGoodNo(paraMap);
	}

	@Override
	public void updateStockAmount(String tenantId , String goodNo, String repositoryNo,Double amount) {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", tenantId);
		paraMap.put("goodNo", goodNo);
		paraMap.put("repositoryNo", repositoryNo);
		paraMap.put("amount", amount);
		
		this.stockDao.updateStockAmount(paraMap);
	}

}	

package com.zym.pss.cargo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.cargo.dao.StockWarningDao;
import com.zym.pss.cargo.vo.StockWarning;
import com.zym.pss.cargo.service.StockWarningService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("stockWarningService")
public class StockWarningServiceImpl extends BaseServiceImpl<StockWarning> implements StockWarningService{
	
	StockWarningDao StockWarningDao ;
	@Resource
	public void setStockWarningDao(StockWarningDao StockWarningDao) {
		super.setBaseDao(StockWarningDao);
		this.StockWarningDao = StockWarningDao;
	}
	@Override
	public List<StockWarning> findMUInfo(Map<String, Object> paraMap) {
		return this.StockWarningDao.findMU(paraMap);
	}
	@Override
	public List<StockWarning> findMLInfo(Map<String, Object> paraMap) {
		return this.StockWarningDao.findML(paraMap);
	}
	@Override
	public List<StockWarning> findPU(Map<String, Object> paraMap) {
		return this.StockWarningDao.findPU(paraMap);
	}
	@Override
	public List<StockWarning> findPL(Map<String, Object> paraMap) {
		return this.StockWarningDao.findPL(paraMap);
	}
	
}	

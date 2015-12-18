package com.zym.pss.sysadmin.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.sysadmin.dao.FunctionDao;
import com.zym.pss.sysadmin.po.Function;
import com.zym.pss.sysadmin.service.FunctionService;
import com.zym.pss.sysadmin.vo.FunctionVO;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("functionService")
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements FunctionService{

	FunctionDao resourceDao ;
	@Resource
	public void setResourceDao(FunctionDao resourceDao) {
		super.setBaseDao(resourceDao);
		this.resourceDao = resourceDao;
	}
	
	@Override
	public void insert(Function entity) {
		entity.setId(UUID.randomUUID().toString());
		this.resourceDao.insert(entity);
	}

	@Override
	public List<FunctionVO> findFunctionVO(Map<String, Object> paraMap) {
		return this.resourceDao.findFunctionVo(paraMap);
	}
}	

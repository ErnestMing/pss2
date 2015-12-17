package com.zym.pss.cargo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.po.Material;
import com.zym.pss.baseinfo.service.MaterialService;
import com.zym.pss.cargo.dao.MaterialOutDao;
import com.zym.pss.cargo.po.MaterialOut;
import com.zym.pss.cargo.service.MaterialOutService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("materialOutService")
public class MaterialOutServiceImpl extends BaseServiceImpl<MaterialOut> implements MaterialOutService{
	
	MaterialOutDao materialOutDao ;
	@Resource
	public void setMaterialOutDao(MaterialOutDao materialOutDao) {
		super.setBaseDao(materialOutDao);
		this.materialOutDao = materialOutDao;
	}
	@Resource
	MaterialService materialService ; 
	
	
	@Override
	public void insert(MaterialOut entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState(0);				//设置状态草稿
		//查询原材料信息
		Material material = this.materialService.findByMaterialNo(entity.getMaterialNo());
		//设置包装单位
		entity.setPackingUnit(material.getPackingUnit());
		this.materialOutDao.insert(entity);
	}
	@Override
	public void update(MaterialOut entity) {
		//查询原材料信息
		Material material = this.materialService.findByMaterialNo(entity.getMaterialNo());
		//更新包装单位
		entity.setPackingUnit(material.getPackingUnit());
		this.materialOutDao.update(entity);
	}
	
	@Override
	public void updateState(String[] ids,Integer state) {
		Map<String,Object> paramMap = new HashMap<String , Object>();
		paramMap.put("state", state);
		paramMap.put("ids", ids);
		this.materialOutDao.updateState(paramMap);
	}

}	

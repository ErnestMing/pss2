package com.zym.pss.cargo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.po.Material;
import com.zym.pss.baseinfo.service.MaterialService;
import com.zym.pss.cargo.dao.MaterialPutDao;
import com.zym.pss.cargo.po.MaterialPut;
import com.zym.pss.cargo.service.MaterialPutService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("materialPutService")
public class MaterialPutServiceImpl extends BaseServiceImpl<MaterialPut> implements MaterialPutService{
	
	MaterialPutDao materialPutDao ;
	@Resource
	public void setMaterialPutDao(MaterialPutDao materialPutDao) {
		super.setBaseDao(materialPutDao);
		this.materialPutDao = materialPutDao;
	}
	@Resource
	MaterialService materialService ; 
	
	@Override
	public void insert(MaterialPut entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState(0);				//设置状态草稿
		//查询原材料信息
		Material material = this.materialService.findByMaterialNo(entity.getMaterialNo());
		//设置包装单位
		entity.setPackingUnit(material.getPackingUnit());
		this.materialPutDao.insert(entity);
	}
	
	@Override
	public void update(MaterialPut entity) {
		//查询原材料信息
		Material material = this.materialService.findByMaterialNo(entity.getMaterialNo());
		//设置包装单位
		entity.setPackingUnit(material.getPackingUnit());
		this.materialPutDao.update(entity);
	}
	
	@Override
	public void updateState(String[] ids,Integer state) {
		Map<String,Object> paramMap = new HashMap<String , Object>();
		paramMap.put("state", state);
		paramMap.put("ids", ids);
		this.materialPutDao.updateState(paramMap);
	}

}	

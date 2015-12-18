package com.zym.pss.cargo.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.po.Material;
import com.zym.pss.baseinfo.service.MaterialService;
import com.zym.pss.cargo.dao.MaterialULLDao;
import com.zym.pss.cargo.po.MaterialULL;
import com.zym.pss.cargo.service.MaterialULLService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("materialULLService")
public class MaterialULLServiceImpl extends BaseServiceImpl<MaterialULL> implements MaterialULLService {

	MaterialULLDao materialULLDao ;
	@Resource
	public void setMaterialULLDao(MaterialULLDao materialULLDao) {
		super.setBaseDao(materialULLDao);
		this.materialULLDao = materialULLDao;
	} 
	@Resource
	MaterialService materialService ; 
	
	@Override
	public void insert(MaterialULL entity) {
		entity.setId(UUID.randomUUID().toString());		//设置主键
		//查询原材料信息
		Material material = this.materialService.findByMaterialNo(entity.getMaterialNo());
		//设置包装单位
		entity.setPackingUnit(material.getPackingUnit());
		this.materialULLDao.insert(entity);
	}
	@Override
	public void update(MaterialULL entity) {
		//查询原材料信息
		Material material = this.materialService.findByMaterialNo(entity.getMaterialNo());
		//设置包装单位
		entity.setPackingUnit(material.getPackingUnit());
		this.materialULLDao.update(entity);
	}
}

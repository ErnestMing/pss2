package com.zym.pss.baseinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.baseinfo.dao.MaterialDao;
import com.zym.pss.baseinfo.po.Material;
import com.zym.pss.baseinfo.service.MaterialService;
import com.zym.pss.core.service.impl.BaseServiceImpl;
import com.zym.pss.util.UtilFuns;

@Service("materialService")
public class MaterialServiceImpl extends BaseServiceImpl<Material> implements MaterialService{
	
	MaterialDao materialDao ;
	@Resource
	public void setMaterialDao(MaterialDao materialDao) {
		super.setBaseDao(materialDao);
		this.materialDao = materialDao;
	}
	
	@Override
	public void insert(Material entity) {
		entity.setId(UUID.randomUUID().toString());
		this.materialDao.insert(entity);
	}

	@Override
	public Material findByMaterialNo(String materialNo) {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("materialNo", materialNo);
		List<Material> materialList = this.materialDao.find(paraMap);
		//返回原材料
		if(UtilFuns.isNotEmpty(materialList)){
			return materialList.get(0);
		}
		return null;
	}
}	

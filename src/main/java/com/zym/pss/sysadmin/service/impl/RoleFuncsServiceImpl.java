package com.zym.pss.sysadmin.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.sysadmin.dao.RoleFuncsDao;
import com.zym.pss.sysadmin.po.RoleFuncs;
import com.zym.pss.sysadmin.service.RoleFuncsService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("roleFuncsService")
public class RoleFuncsServiceImpl extends BaseServiceImpl<RoleFuncs> implements RoleFuncsService{
	
	RoleFuncsDao roleFuncsDao ;
	@Resource
	public void setRoleFuncsDao(RoleFuncsDao roleFuncsDao) {
		super.setBaseDao(roleFuncsDao);
		this.roleFuncsDao = roleFuncsDao;
	}
	
	@Resource
	RoleFuncsService roleFuncsService ; 
	
	@Override
	public void insert(RoleFuncs entity) {
		entity.setId(UUID.randomUUID().toString());
		this.roleFuncsDao.insert(entity);
	}

	@Override
	public Boolean isValidate(String roleId, String functionId) {
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("roleId", roleId);
		paraMap.put("functionId", functionId);
		
		List<RoleFuncs> find = this.roleFuncsDao.find(paraMap);
		if(find!=null&&!find.isEmpty()){
			return false ; 
		}
		return true;
	}

	@Override
	public void deleteRoleFuncsRelation(Serializable roleId) {
		this.roleFuncsDao.deleteRoleFuncsRelation(roleId);
	}
}	

package com.zym.pss.sysadmin.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.sysadmin.dao.UserRolesDao;
import com.zym.pss.sysadmin.po.UserRoles;
import com.zym.pss.sysadmin.service.UserRolesService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("userRolesService")
public class UserRolesServiceImpl extends BaseServiceImpl<UserRoles> implements UserRolesService{
	
	UserRolesDao userRolesDao ;
	@Resource
	public void setUserRolesDao(UserRolesDao userRolesDao) {
		super.setBaseDao(userRolesDao);
		this.userRolesDao = userRolesDao;
	}
	
	@Override
	public void insert(UserRoles entity) {
		entity.setId(UUID.randomUUID().toString());
		this.userRolesDao.insert(entity);
	}

	@Override
	public Boolean isValidate(String userId, String roleId) {
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("userId", userId);
		paraMap.put("roleId", roleId);
		List<UserRoles> find = this.userRolesDao.find(paraMap);
		
		if(find!=null&&!find.isEmpty()){
			return false ; 
		}
		return true;
	}

	@Override
	public void deleteUserRoleRelation(Serializable userId) {
		this.userRolesDao.deleteUserRoleRelation(userId);
	}
}	

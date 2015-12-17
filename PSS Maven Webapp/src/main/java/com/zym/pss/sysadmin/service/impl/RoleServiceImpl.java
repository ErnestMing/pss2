package com.zym.pss.sysadmin.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.sysadmin.dao.RoleDao;
import com.zym.pss.sysadmin.po.Role;
import com.zym.pss.sysadmin.service.RoleFuncsService;
import com.zym.pss.sysadmin.service.RoleService;
import com.zym.pss.sysadmin.vo.RoleFuncsVo;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	
	RoleDao roleDao ;
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}
	@Resource
	RoleFuncsService roleFuncsService ; 
	
	@Override
	public void insert(Role entity) {
		entity.setId(UUID.randomUUID().toString());
		this.roleDao.insert(entity);
	}
	
	@Override
	public List<RoleFuncsVo> findFuncs(Map<String, Object> paraMap) {
		return this.roleDao.findFuncs(paraMap);
	}
	
	@Override
	public void delete(Serializable[] ids) {
		for(int i = 0 ; i< ids.length;i++){
			this.roleFuncsService.deleteRoleFuncsRelation(ids[i]);		//删除前先删除角色与权限的关联关系
		}
		this.roleDao.delete(ids);
	}
}	

package com.zym.pss.sysadmin.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.sysadmin.dao.UserDao;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.sysadmin.service.UserRolesService;
import com.zym.pss.sysadmin.service.UserService;
import com.zym.pss.sysadmin.vo.UserRolesVo;
import com.zym.pss.sysadmin.vo.UserVo;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
	UserDao userDao ;
	@Resource
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}
	@Resource
	UserRolesService  userRolesService ; 
	@Override
	public void insert(User entity) {
		entity.setId(UUID.randomUUID().toString());
		this.userDao.insert(entity);
	}

	@Override
	public List<UserRolesVo> findRoles(Map<String, Object> paraMap) {
		return this.userDao.findRoles(paraMap);
	}
	
	@Override
	public void delete(Serializable[] ids) {

		//删除角色前先删除用户与角色之间的关系
		for(int i = 0 ; i< ids.length;i++){
			this.userRolesService.deleteUserRoleRelation(ids[i]);
		}
		this.userDao.delete(ids);
	}

	@Override
	public UserVo findByUserNameAndPass(String tenantId,String userName, String password) {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", tenantId);
		paraMap.put("userName", userName);
		paraMap.put("password", password);
		
		return this.userDao.findByUserNameAndPass(paraMap);
	}
}	

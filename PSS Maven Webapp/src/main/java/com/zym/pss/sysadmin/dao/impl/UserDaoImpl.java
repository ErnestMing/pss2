package com.zym.pss.sysadmin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.sysadmin.dao.UserDao;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.sysadmin.vo.UserRolesVo;
import com.zym.pss.sysadmin.vo.UserVo;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	//设置命名空间
	public UserDaoImpl() {
		super.setNs("com.zym.pss.sysadmin.mapper.UserMapper");
	}

	@Override
	public List<UserRolesVo> findRoles(Map<String, Object> paraMap) {
		return super.getSqlSession().selectList(super.getNs()+".findRoles", paraMap);
	}

	@Override
	public UserVo findByUserNameAndPass(Map<String,Object> paraMap) {
		return super.getSqlSession().selectOne(super.getNs()+".findByUserNameAndPass",paraMap);
	}
}

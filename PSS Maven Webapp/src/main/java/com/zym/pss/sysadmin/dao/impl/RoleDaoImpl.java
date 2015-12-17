package com.zym.pss.sysadmin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.sysadmin.dao.RoleDao;
import com.zym.pss.sysadmin.po.Role;
import com.zym.pss.sysadmin.vo.RoleFuncsVo;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	//设置命名空间
	public RoleDaoImpl() {
		super.setNs("com.zym.pss.sysadmin.mapper.RoleMapper");
	}

	@Override
	public List<RoleFuncsVo> findFuncs(Map<String, Object> paraMap) {
		return super.getSqlSession().selectList(super.getNs()+".findFuncs", paraMap);
	}
}

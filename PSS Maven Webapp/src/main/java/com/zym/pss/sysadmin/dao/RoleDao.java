package com.zym.pss.sysadmin.dao;

import java.util.List;
import java.util.Map;

import com.zym.pss.sysadmin.po.Role;
import com.zym.pss.sysadmin.vo.RoleFuncsVo;
import com.zym.pss.core.dao.BaseDao;

public interface RoleDao extends BaseDao<Role> {

	/**
	 * 获取角色权限信息
	 * @param paraMap
	 * @return
	 */
	public List<RoleFuncsVo> findFuncs(Map<String, Object> paraMap);
}

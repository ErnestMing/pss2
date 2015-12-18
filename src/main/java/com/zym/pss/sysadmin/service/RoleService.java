package com.zym.pss.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.zym.pss.sysadmin.po.Role;
import com.zym.pss.sysadmin.vo.RoleFuncsVo;
import com.zym.pss.core.service.BaseService;

public interface RoleService extends BaseService<Role> {
	/**
	 * 获取角色权限信息 RoleFuncsVo类
	 * @param paraMap
	 * @return
	 */
	public List<RoleFuncsVo> findFuncs(Map<String, Object> paraMap);
}

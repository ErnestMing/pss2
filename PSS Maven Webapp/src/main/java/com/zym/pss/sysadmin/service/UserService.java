package com.zym.pss.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.zym.pss.sysadmin.po.User;
import com.zym.pss.sysadmin.vo.UserRolesVo;
import com.zym.pss.sysadmin.vo.UserVo;
import com.zym.pss.core.service.BaseService;

public interface UserService extends BaseService<User> {

	/**
	 * 获取用户角色VO
	 * @param paraMap
	 * @return
	 */
	public List<UserRolesVo> findRoles(Map<String, Object> paraMap);

	/**
	 * 通过用户名和密码,查询用户VO对象
	 * @param userName
	 * @param password
	 * @param tenantNo 
	 * @return
	 */
	public UserVo findByUserNameAndPass(String tenantId,String userName, String password);

}

package com.zym.pss.sysadmin.dao;

import java.util.List;
import java.util.Map;

import com.zym.pss.sysadmin.po.User;
import com.zym.pss.sysadmin.vo.UserRolesVo;
import com.zym.pss.sysadmin.vo.UserVo;
import com.zym.pss.core.dao.BaseDao;

public interface UserDao extends BaseDao<User> {

	/**
	 * 获取用户角色VO
	 * @param paraMap
	 * @return
	 */
	public List<UserRolesVo> findRoles(Map<String, Object> paraMap);

	/**
	 * 通过userName和password 查询用户VO对象
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserVo findByUserNameAndPass(Map<String,Object> paraMap);

}

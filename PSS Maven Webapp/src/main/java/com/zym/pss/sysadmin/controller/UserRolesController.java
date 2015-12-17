package com.zym.pss.sysadmin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.sysadmin.po.UserRoles;
import com.zym.pss.sysadmin.service.UserRolesService;
import com.zym.pss.util.UtilFuns;
import com.zym.pss.core.controller.BaseController;

@Controller
@RequestMapping("/sysadmin/userroles")
public class UserRolesController extends BaseController {

	@Resource
	UserRolesService userRolesService ;

	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(String userId , @RequestParam("roleId")String[] roleIds){
		//当userId  和  roleIds 存在是插入
		if(UtilFuns.isNotEmpty(userId)&&UtilFuns.isNotEmpty(roleIds)){
			UserRoles userRole = null ;  
			for(String roleId:roleIds){
				userRole = new UserRoles() ; 
				userRole.setUserId(userId);
				userRole.setRoleId(roleId);
				//插入前验证是否存在
				if(this.userRolesService.isValidate(userId,roleId)){
					this.userRolesService.insert(userRole);
				}
			}
		}
		return "redirect:/sysadmin/user/"+userId+"/touserroles.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids ,String userId){
		this.userRolesService.delete(ids);
		return "redirect:/sysadmin/user/"+userId+"/touserroles.action";
	}
}

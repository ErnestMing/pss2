package com.zym.pss.sysadmin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.sysadmin.po.RoleFuncs;
import com.zym.pss.sysadmin.service.RoleFuncsService;
import com.zym.pss.util.UtilFuns;
import com.zym.pss.core.controller.BaseController;

@Controller
@RequestMapping("/sysadmin/rolefuncs")
public class RoleFuncsController extends BaseController {

	@Resource
	RoleFuncsService roleFuncsService ;
	//存放列表信息
	
	/**
	 * 批量添加
	 */
	@RequestMapping("/insert.action")
	public String create(String roleId,@RequestParam("functionId")String[] functionIds){	
		//当roleID functionIds 不为null时
		if(UtilFuns.isNotEmpty(roleId)&&UtilFuns.isNotEmpty(functionIds)){
			for(String functionId : functionIds){
				RoleFuncs roleFuncs = new RoleFuncs();
				roleFuncs.setRoleId(roleId);
				roleFuncs.setFunctionId(functionId);
				//插入前验证是否存在:不存在插入,存在不插入
				if(this.roleFuncsService.isValidate(roleId,functionId)){
					this.roleFuncsService.insert(roleFuncs); 
				}
			}
		}
  		
		return "redirect:/sysadmin/role/"+roleId+"/torolefuncs.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids,String roleId){
		this.roleFuncsService.delete(ids);
		return "redirect:/sysadmin/role/"+roleId+"/torolefuncs.action";
	}
}

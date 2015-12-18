package com.zym.pss.sysadmin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.multiTenant.service.SubsciberService;
import com.zym.pss.multiTenant.vo.SubsciberVo;
import com.zym.pss.sysadmin.po.Function;
import com.zym.pss.sysadmin.po.Role;
import com.zym.pss.sysadmin.service.FunctionService;
import com.zym.pss.sysadmin.service.RoleFuncsService;
import com.zym.pss.sysadmin.service.RoleService;
import com.zym.pss.sysadmin.vo.FunctionVO;
import com.zym.pss.sysadmin.vo.RoleFuncsVo;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.core.pargination.Page;

@Controller
@RequestMapping("/sysadmin/role")
public class RoleController extends BaseController {

	@Resource
	RoleService roleService ;
	@Resource
	RoleFuncsService roleFuncsService ; 			//角色权限Service
	@Resource
	FunctionService functionService ;				//系统功能Service 
	@Resource
	SubsciberService subsciberService ; 			//服务订购Service
	
	//存放列表信息
	private List<Role> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,HttpSession session ){
		
		//获取当前租户
		Tenant tenant = (Tenant) session.getAttribute("CUR_TENANT");
		
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", tenant.getId());
		
		dataList = roleService.find(paraMap);
		model.addAttribute("dataList",dataList);
		
		return "/sysadmin/role/jRoleList.jsp" ; 
	}
	
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		Role obj = this.roleService.get(id);
		model.addAttribute("obj",obj);

		return "/sysadmin/role/jRoleView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(){
		return "/sysadmin/role/jRoleCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(Role Role){
		this.roleService.insert(Role);
		
		return "redirect:/sysadmin/role/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model){
		Role obj = this.roleService.get(id);
		model.addAttribute("obj",obj);
		
		return "/sysadmin/role/jRoleUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(Role Role){
		this.roleService.update(Role);
		return "redirect:/sysadmin/role/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.roleService.deleteById(id);
		return "redirect:/sysadmin/role/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.roleService.delete(ids);
		return "redirect:/sysadmin/role/list.action";
	}

	
//--------------------------------------------------------------角色与权限的分配----------------------------------------------------
	/**
	 * 跳转到角色权限分配页面
	 * @param model
	 * @param pageNo	功能分页参数
	 * @param id		角色ID
	 * @return
	 */
	@RequestMapping(value="/{roleId}/torolefuncs.action",method=RequestMethod.GET)
	public String assignPermission(Model model ,Integer pageNo,@PathVariable("roleId")String roleId){
		//准备角色权限集合
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("roleId", roleId);
		List<RoleFuncsVo> roleFuncsList = this.roleService.findFuncs(paraMap);
		model.addAttribute("roleId", roleId);
		
		model.addAttribute("roleFuncsList", roleFuncsList);
		
		//准备系统功能集合
		Page<Function> page = new Page<Function>();
		page.setPageSize(5);
		if(pageNo != null){
			page.setPageNo(pageNo);
		}

		//获取角色的租户
		String tenantId = roleService.get(roleId).getTenantId();
		
		Map<String,Object> paraMap2 = new HashMap<String,Object>();
		paraMap2.put("tenantId", tenantId);

		List<SubsciberVo> subsciberVoList = subsciberService.findSubsciberVoList(paraMap2);
		List<FunctionVO> functionList = new ArrayList<FunctionVO>(); 
		
		for(SubsciberVo sv :subsciberVoList){
			functionList.add(sv.getFunction());
		}
		model.addAttribute("functionList", functionList);
		
		return "/sysadmin/role/jRoleFuncs.jsp";
	}
	
}

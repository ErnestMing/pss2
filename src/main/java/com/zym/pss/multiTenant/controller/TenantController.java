package com.zym.pss.multiTenant.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.multiTenant.service.TenantService;
import com.zym.pss.core.controller.BaseController;
/**
 * @Description:租户管理Controller
 * @Author: zym
 * @CreateDate: 2015年12月9日
 */
@Controller
@RequestMapping("/multitenant/tenantadmin/tenant")
public class TenantController extends BaseController {

	@Resource
	TenantService tenantService ;
	//存放列表信息
	private List<Tenant> dataList ;		
	
	/**
	 * 跳转到租户管理列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model){
		
		//将租户状态信息放入到请求域中
		model.addAttribute("tenantState", Tenant.TENATN_STATE);
		
		dataList = tenantService.find(null);
		model.addAttribute("dataList",dataList);
		
		return "/multimm/tenantadmin/tenant/jTenantList.jsp" ; 
	}
	/**
	 * 查看租户详细信息
	 */
	@RequestMapping("/toview.action")
	public String toview(HttpSession session ,  Model model){
		Tenant obj = (Tenant) session.getAttribute("CUR_TENANT");
		model.addAttribute("obj",obj);

		return "/multitenant/info/tenant/jTenantView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(){
		return "/multitenant/tenantadmin/tenant/jTenantCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(Tenant Tenant){
		this.tenantService.insert(Tenant);
		
		return "redirect:/multitenant/tenantadmin/tenant/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(Model model,HttpSession session ){
		Tenant obj = (Tenant) session.getAttribute("CUR_TENANT");
		model.addAttribute("obj",obj);
		
		return "/multitenant/info/tenant/jTenantUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(Tenant Tenant){
		this.tenantService.update(Tenant);
		return "redirect:/multitenant/tenantadmin/tenant/toupdate.action";
	}
	
//------------------------------------------------------------租户状态修改---------------------------------------------------------
	
	/**
	 * 启用租户
	 */
	@RequestMapping("/start.action")
	public String start(@RequestParam("id")String[] ids){
		tenantService.updateState(ids, 2);		//2:启用
		return "redirect:/multitenant/tenantadmin/tenant/list.action";
	}
	/**
	 * 禁用租户
	 */
	@RequestMapping("/cancel.action")
	public String cancel(@RequestParam("id")String[] ids){
		tenantService.updateState(ids, 3);		//3:禁用
		return "redirect:/multitenant/tenantadmin/tenant/list.action";
	}
}

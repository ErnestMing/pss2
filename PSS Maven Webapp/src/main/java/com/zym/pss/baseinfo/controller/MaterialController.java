package com.zym.pss.baseinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.baseinfo.po.Material;
import com.zym.pss.baseinfo.service.MaterialService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.sysadmin.vo.UserVo;

@Controller
@RequestMapping("/baseinfo/material")
public class MaterialController extends BaseController {

	@Resource
	MaterialService materialService ;
	//存放列表信息
	private List<Material> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,HttpSession session ){
		//获取租户信息
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		dataList = materialService.find(paraMap);
		model.addAttribute("dataList",dataList);
		
		return "/baseinfo/material/jMaterialList.jsp" ; 
	}
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		Material obj = this.materialService.get(id);
		model.addAttribute("obj",obj);

		return "/baseinfo/material/jMaterialView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(){
		return "/baseinfo/material/jMaterialCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(Material material,HttpSession session){
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 

		material.setTenantId(tenantId);
		
		this.materialService.insert(material);
		
		return "redirect:/baseinfo/material/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model){
		Material obj = this.materialService.get(id);
		model.addAttribute("obj",obj);
		
		return "/baseinfo/material/jMaterialUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(Material material){
		this.materialService.update(material);
		return "redirect:/baseinfo/material/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.materialService.deleteById(id);
		return "redirect:/baseinfo/material/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.materialService.delete(ids);
		return "redirect:/baseinfo/material/list.action";
	}
}

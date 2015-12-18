package com.zym.pss.multiTenant.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.multiTenant.po.PricePolicy;
import com.zym.pss.multiTenant.service.PricePolicyService;
import com.zym.pss.sysadmin.po.Function;
import com.zym.pss.sysadmin.service.FunctionService;
import com.zym.pss.core.controller.BaseController;

@Controller
@RequestMapping("/multimm/servicemanage/pricepolicy")
public class PricePolicyController extends BaseController {

	@Resource
	PricePolicyService pricePolicyService ;
	@Resource
	FunctionService functionService ; 
	
	//存放列表信息
	private List<PricePolicy> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model){
		
		dataList = pricePolicyService.find(null);
		model.addAttribute("dataList",dataList);
		
		return "/multimm/servicemanage/pricepolicy/jPricePolicyList.jsp" ; 
	}
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		PricePolicy obj = this.pricePolicyService.get(id);
		model.addAttribute("obj",obj);

		return "/multimm/servicemanage/pricepolicy/jPricePolicyView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(Model model ){
		
		//准备模块列表下拉菜单
		List<Function> functionList = functionService.find(null);
		model.addAttribute("functionList",functionList);
		
		return "/multimm/servicemanage/pricepolicy/jPricePolicyCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(PricePolicy PricePolicy){
		
		this.pricePolicyService.insert(PricePolicy);
		
		return "redirect:/multimm/servicemanage/pricepolicy/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model){
		
		//准备模块列表下拉菜单
		List<Function> functionList = functionService.find(null);
		model.addAttribute("functionList",functionList);
		
		PricePolicy obj = this.pricePolicyService.get(id);
		model.addAttribute("obj",obj);
		
		return "/multimm/servicemanage/pricepolicy/jPricePolicyUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(PricePolicy PricePolicy){
		this.pricePolicyService.update(PricePolicy);
		return "redirect:/multimm/servicemanage/pricepolicy/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.pricePolicyService.deleteById(id);
		return "redirect:/multimm/servicemanage/pricepolicy/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.pricePolicyService.delete(ids);
		return "redirect:/multimm/servicemanage/pricepolicy/list.action";
	}
}

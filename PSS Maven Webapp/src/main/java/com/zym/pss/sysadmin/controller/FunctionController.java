package com.zym.pss.sysadmin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.sysadmin.po.Function;
import com.zym.pss.sysadmin.service.FunctionService;
import com.zym.pss.core.controller.BaseController;

@Controller
@RequestMapping("/multimm/servicemanage/service")
public class FunctionController extends BaseController {

	@Resource
	FunctionService functionService ;
	//存放列表信息
	private List<Function> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model){
		dataList = functionService.find(null);
		model.addAttribute("dataList",dataList);
		
		return "/multimm/servicemanage/service/jFunctionList.jsp" ; 
	}
	
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		Function obj = this.functionService.get(id);
		model.addAttribute("obj",obj);

		return "/multimm/servicemanage/service/jFunctionView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(){
		return "/multimm/servicemanage/service/jFunctionCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(Function Function){
		this.functionService.insert(Function);
		
		return "redirect:/multimm/servicemanage/service/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model){
		Function obj = this.functionService.get(id);
		model.addAttribute("obj",obj);
		
		return "/multimm/servicemanage/service/jFunctionUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(Function Function){
		this.functionService.update(Function);
		return "redirect:/multimm/servicemanage/service/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.functionService.deleteById(id);
		return "redirect:/multimm/servicemanage/service/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.functionService.delete(ids);
		return "redirect:/multimm/servicemanage/service/list.action";
	}
}

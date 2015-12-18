package com.zym.pss.cargo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.service.StockService;
import com.zym.pss.cargo.service.StockWarningService;
import com.zym.pss.cargo.vo.StockWarning;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.sysadmin.vo.UserVo;
@Controller
@RequestMapping("/cargo/stockwarning")
public class StockWarningController extends BaseController{

	@Resource
	StockWarningService stockWarningService ;
	@Resource
	StockService stockService ; 
	
	//存放列表信息
	private List<StockWarning> dataList ;		
	
	/**
	 * 库存列表
	 */
	@RequestMapping("/list.action")
	public String list(Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		List<Stock> stockList = stockService.find(paraMap);
		model.addAttribute("dataList",stockList);
		
		return "/cargo/stockwarning/jStockWarningList.jsp" ; 
	}
	/**
	 * 原材料上限预警
	 * @return
	 */
	@RequestMapping("/muwarning.action")
	public String muWarning(Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		//原材料上限预警列表
		dataList = stockWarningService.findMUInfo(paraMap);
		model.addAttribute("dataList",dataList);
		
		return "/cargo/stockwarning/jMUWarning.jsp";
	}
	/**
	 * 原材料下限预警
	 * @return
	 */
	@RequestMapping("/mlwarning.action")
	public String mlWarning(Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		//原材料下限预警列表
		dataList = stockWarningService.findMLInfo(paraMap);
		model.addAttribute("dataList",dataList);
		
		return "/cargo/stockwarning/jMLWarning.jsp";
	}
	/**
	 * 货物上限预警
	 * @return
	 */
	@RequestMapping("/puwarning.action")
	public String puWarning(Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		//货物上限预警列表
		dataList = stockWarningService.findPU(paraMap);
		model.addAttribute("dataList",dataList);
		
		return "/cargo/stockwarning/jPUWarning.jsp";
	}
	/**
	 * 货物下限预警
	 * @return
	 */
	@RequestMapping("/plwarning.action")
	public String plWarning(Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		//货物下限预警列表
		dataList = stockWarningService.findPL(paraMap);
		model.addAttribute("dataList",dataList);
		return "/cargo/stockwarning/jPLWarning.jsp";
	}
}

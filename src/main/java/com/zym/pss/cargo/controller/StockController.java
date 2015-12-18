package com.zym.pss.cargo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.service.StockService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.core.pargination.Page;

@Controller
@RequestMapping("/cargo/stock")
public class StockController extends BaseController {

	@Resource
	StockService stockService ;
	
	//存放列表信息
	private List<Stock> dataList ;		
	
	/**
	 * 库存列表
	 */
	@RequestMapping("/list.action")
	public String list(Model model,Integer pageNo){
//		dataList = stockService.find(null);
		
//------------------------------------分页操作----------------------------------------
		Page<Stock> page = new Page<Stock>();
		if(pageNo != null){
			page.setPageNo(pageNo);			//获取页面传递过来的页号
		}
		
		dataList = stockService.findPage(page);
		model.addAttribute("pageLinks", page.pageLinks("list.action"));		//返回翻页的的HTML语句
		
//------------------------------------------------------------------------------------
		
		model.addAttribute("dataList",dataList);
		
		return "/cargo/stock/jStockList.jsp" ; 
	}
	/**
	 * 原材料入库
	 * @return
	 */
	@RequestMapping("/materialput")
	public String materialPut(){
		
		return "redirect:/cargo/materialput/list.action";
	}
	/**
	 * 原材料出库
	 * @return
	 */
	@RequestMapping("/materialout")
	public String materialOut(){
		return "redirect:/cargo/materialout/list.action";
	}
	/**
	 * 货物入库
	 * @return
	 */
	@RequestMapping("/productput")
	public String productPut(){
		return "redirect:/cargo/productput/list.action";
	}
	/**
	 * 货物出库
	 * @return
	 */
	@RequestMapping("/productout")
	public String productOut(){
		return "redirect:/cargo/productout/list.action";
	}
	/**
	 * 打印库存报表
	 */
	@RequestMapping("/print.action")
	public void print(){
		//打印库存报表操作
	}
}

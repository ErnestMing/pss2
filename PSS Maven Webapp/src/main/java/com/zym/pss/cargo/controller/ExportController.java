package com.zym.pss.cargo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zym.pss.cargo.po.PurchaseOrder;
import com.zym.pss.cargo.po.SaleOrder;
import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.service.ExportService;
import com.zym.pss.cargo.service.PurchaseOrderService;
import com.zym.pss.cargo.service.SaleOrderService;
import com.zym.pss.cargo.service.StockService;
import com.zym.pss.cargo.service.StockWarningService;
import com.zym.pss.cargo.vo.StockWarning;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.util.UtilFuns;
@Controller
@RequestMapping("/cargo/export")
public class ExportController extends BaseController{

	@Resource
	StockWarningService stockWarningService ;
	@Resource
	StockService stockService ; 
	@Resource
	ExportService exportService ; 
	@Resource
	SaleOrderService saleOrderService ; 
	@Resource
	PurchaseOrderService purchaseOrderService ; 
	
	/**
	 * 跳转到报表统计页面
	 * @return
	 */
	@RequestMapping("toexport")
	public String toexport(){
		return "/cargo/export/jExport.jsp";
	}
	/**
	 * 月销售统计报表
	 */
	@RequestMapping("saleexport")
	public String saleExport(Model model,String saleTime,HttpServletRequest request,HttpServletResponse response){
		
		if(saleTime != null ){
			Map<String,Object> paraMap = new HashMap<String,Object>();
			paraMap.put("saleTime", saleTime);

			//查询货物销售订单
			List<SaleOrder> dataList = this.saleOrderService.find(paraMap);
			String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsxprint";
			
			if(UtilFuns.isNotEmpty(dataList)){
				//打印
				this.exportService.exporSE(path, dataList, request, response);
				return "";
			}else{
				model.addAttribute("msg", "%>_<% ,记录不存在!!");
				model.addAttribute("listUrl", "toexport.action");
				return "/exception/error.jsp";
			}
		}else{
			model.addAttribute("msg", "%>_<% ,请输入要查询的月份~~");
			model.addAttribute("listUrl", "toexport.action");
			return "/exception/error.jsp";
		}
		
	}
	
	/**
	 * 月采购统计报表
	 */
	@RequestMapping("purchaseexport")
	public String purchaseExport(Model model , String purchaseTime,HttpServletRequest request,HttpServletResponse response){
		
		if(purchaseTime != null){
			Map<String,Object> paraMap = new HashMap<String,Object>();
			paraMap.put("purchaseTime", purchaseTime);
			
			//查询采购订单信息
			List<PurchaseOrder> dataList = this.purchaseOrderService.find(paraMap);
			String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsxprint";
			
			//判断列表是否为空
			if(UtilFuns.isNotEmpty(dataList)){
				//打印
				this.exportService.exportPE(path, dataList, request, response);
				return "";
			}else{
				model.addAttribute("msg", "%>_<% ,记录不存在!!");
				model.addAttribute("listUrl", "toexport.action");
				return "/exception/error.jsp";
			}
		}else{
			model.addAttribute("msg", "%>_<% ,请输入要查询的月份~~");
			model.addAttribute("listUrl", "toexport.action");
			return "/exception/error.jsp";
		}
		
	}
	/**
	 * 库存	报表
	 */
	@RequestMapping("/stock.action")
	public String list(Model model,HttpServletRequest request,HttpServletResponse response){
		//库存列表
		List<Stock> dataList = stockService.find(null);
		
		String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsxprint";
		
		//打印
		if(UtilFuns.isNotEmpty(dataList)){
			//打印
			this.exportService.exporStock(path, dataList, request, response);
			return "";
		}else{
			model.addAttribute("msg", "%>_<% ,记录不存在!!");
			model.addAttribute("listUrl", "toexport.action");
			return "/exception/error.jsp";
		}
	}
	/**
	 * 原材料上限预警  报表
	 * @return
	 */
	@RequestMapping("/printMU.action")
	public String muWarning(Model model,HttpServletRequest request,HttpServletResponse response){
		//原材料上限预警列表
		List<StockWarning> dataList = stockWarningService.findMUInfo(null);
		String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsxprint";
		
		//打印
		if(UtilFuns.isNotEmpty(dataList)){
			//打印
			this.exportService.exportMU(path, dataList, request, response);
			return "";
		}else{
			model.addAttribute("msg", "%>_<% ,记录不存在!!");
			model.addAttribute("listUrl", "toexport.action");
			return "/exception/error.jsp";
		}
	}
	/**
	 * 原材料下限预警  报表
	 * @return
	 */
	@RequestMapping("/printML.action")
	public String mlWarning(Model model,HttpServletRequest request,HttpServletResponse response){
		
		//原材料下限预警列表
		List<StockWarning> dataList = stockWarningService.findMLInfo(null);

		String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsxprint";
		
		//打印
		if(UtilFuns.isNotEmpty(dataList)){
			//打印
			this.exportService.exportML(path, dataList, request, response);
			return "";
		}else{
			model.addAttribute("msg", "%>_<% ,记录不存在!!");
			model.addAttribute("listUrl", "toexport.action");
			return "/exception/error.jsp";
		}
	}
	/**
	 * 货物上限预警	报表
	 * @return
	 */
	@RequestMapping("/printPU.action")
	public String puWarning(Model model,HttpServletRequest request,HttpServletResponse response){
		//货物上限预警列表
		List<StockWarning> dataList = stockWarningService.findPU(null);

		String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsxprint";
		
		if(UtilFuns.isNotEmpty(dataList)){
			//打印
			this.exportService.exportPU(path, dataList, request, response);
			return "";
		}else{
			model.addAttribute("msg", "%>_<% ,记录不存在!!");
			model.addAttribute("listUrl", "toexport.action");
			return "/exception/error.jsp";
		}
	}
	/**
	 * 货物下限预警	报表
	 * @return
	 */
	@RequestMapping("/printPL.action")
	public String plWarning(Model model,HttpServletRequest request,HttpServletResponse response){
		
		//货物下限预警列表
		List<StockWarning> dataList = stockWarningService.findPL(null);

		String path = request.getSession().getServletContext().getRealPath("/")+"/make/xlsxprint";
		
		
		if(UtilFuns.isNotEmpty(dataList)){
			//打印
			this.exportService.exportPL(path, dataList, request, response);
			return "";
		}else{
			model.addAttribute("msg", "%>_<% ,记录不存在!!");
			model.addAttribute("listUrl", "toexport.action");
			return "/exception/error.jsp";
		}
	}
}

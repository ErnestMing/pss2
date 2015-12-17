package com.zym.pss.cargo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.baseinfo.po.Custom;
import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.baseinfo.service.CustomService;
import com.zym.pss.baseinfo.service.ProductService;
import com.zym.pss.cargo.po.Order;
import com.zym.pss.cargo.po.SaleOrder;
import com.zym.pss.cargo.service.OrderService;
import com.zym.pss.cargo.service.SaleOrderService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.sysadmin.vo.UserVo;

@Controller
@RequestMapping("/cargo/saleorder")
public class SaleOrderController extends BaseController{

	@Resource
	OrderService orderService ;		//订单Service
	
	@Resource
	private CustomService customService ; 			//客户Service
	@Resource
	private ProductService productService ;			//货物Service
	@Resource
	private SaleOrderService saleOrderService ; 		//销售订单Service
	
	//存放列表信息
	private List<Order> dataList ;	
	
	/**
	 * 跳转到销售订单列表页面
	 */
	@RequestMapping("/list.action")
	public String sale_list(Model model,HttpSession Session ){
		//获取当前用户
		UserVo curuser = (UserVo) Session.getAttribute("CURUSER");

		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		paraMap.put("orderType", "2");
		
		dataList = orderService.find(paraMap);
		
		model.addAttribute("dataList",dataList);
		model.addAttribute("orderState",Order.ORDER_STATE_MAP);
		
		return "/cargo/saleorder/jOrderList.jsp" ; 
	}
	@RequestMapping("/toview.action")
	public String toview(String id , Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");

		Order obj = this.orderService.get(id);
		
		//通过订单编号查询订单下的货物列表
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		paraMap.put("orderNo", obj.getOrderNo());
			
		List<SaleOrder> goodsList = this.saleOrderService.find(paraMap);
		model.addAttribute("goodsList",goodsList);
	
		model.addAttribute("obj",obj);

		return "/cargo/saleorder/jOrderView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(){
		return "/cargo/saleorder/jOrderCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(Order order,HttpSession session ){
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		order.setTenantId(tenantId);
		
		this.orderService.insert(order);
		
		return "redirect:/cargo/saleorder/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model){
		Order obj = this.orderService.get(id);
		if(obj.getState() == 1){
			model.addAttribute("obj",obj);
			return "/cargo/saleorder/jOrderUpdate.jsp";
		}else{
			return "redirect:/cargo/saleorder/list.action";
		}
		
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(Order order){
		this.orderService.update(order);
		return "redirect:/cargo/saleorder/list.action";
	}
	/**
	 * 删除
	 */
/*	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.orderService.deleteById(id);
		return "redirect:/cargo/saleorder/list.action";
	}*/
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		for(int i = 0 ; i < ids.length;i++){
			Order o = orderService.get(ids[i]);
			if(o.getState() == 1 ){
				this.orderService.delete(new String[]{ids[i]});
			}
		}
		return "redirect:/cargo/saleorder/list.action";
	}
	/**
	 * 上报订单
	 * @param id
	 * @return
	 */
	@RequestMapping("/start.action")
	public String start(@RequestParam("id")String[] ids){
		for(int i = 0 ; i < ids.length;i++){
			Order o = orderService.get(ids[i]);
			if(o.getState() == 1 ){					//只有当 订单的状态为 未上报 状态时,才可以上报.其他状态都不可以上报
				this.orderService.updateState(new String[]{ids[i]},2);
			}
		}
		return "redirect:/cargo/saleorder/list.action";
	}
	@RequestMapping("/check.action")
	public String check(@RequestParam("id")String[] ids){
		for(int i = 0  ; i < ids.length;i++){
			Order o = orderService.get(ids[i]);
			if(o.getState() == 2 ){							//只有当订单状态为待审核状态时,才可以审核
				this.orderService.updateState(new String[]{ids[i]},3);
			}
		}
		return "redirect:/cargo/order/orderreview.action";
	}
	/**
	 * 取消订单
	 * @param ids
	 * @return
	 */
	@RequestMapping("/cancel.action")
	public String cancel(@RequestParam("id")String[] ids){
		this.orderService.updateState(ids,1);
		return "redirect:/cargo/saleorder/list.action";
	}
//-----------------------------------------------------------订单下货物CRUD----------------------------------------
	/**
	 * 跳转到订单货物添加页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toaddproduct.action")
	public String toAddProduct(String orderNo ,Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");

		Map<String,Object> paraMap1 = new HashMap<String,Object>();
		paraMap1.put("tenantId", curuser.getTenantId());
		
		//准备客户下拉列表
		List<Custom> customList = this.customService.find(paraMap1);
		//准备货物下拉列表
		List<Product> productList = this.productService.find(paraMap1);
		
		//查询该订单下的销售货物信息
		Map<String,Object> paraMap  = new HashMap<String,Object>();
		paraMap.put("tenantId",curuser.getTenantId());
		paraMap.put("orderNo", orderNo);		//获取订单编号
		List<SaleOrder> saleOrderList  = this.saleOrderService.find(paraMap);
		
		//返回到页面
		model.addAttribute("customList",customList);
		model.addAttribute("productList",productList);
		model.addAttribute("orderNo",orderNo);
		model.addAttribute("saleOrderList",saleOrderList);
		
		
		return "/cargo/saleorder/jSOProductCreate.jsp";
	}
	/**
	 * 给订单添加货物
	 * @param OrderId
	 * @param materialNo
	 * @param supplierNo
	 * @param purchaseAmount
	 * @return
	 */
	@RequestMapping("/addproduct.action")
	public String addProduct(SaleOrder saleOrder,String orderNo , Model model,HttpSession session ){
		
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		saleOrder.setTenantId(tenantId);
		
		this.saleOrderService.insert(saleOrder);
		
		//传递订单ID到 --  新增+列表页面
		model.addAttribute("orderNo", orderNo);
		return "redirect:/cargo/saleorder/toaddproduct.action";
	}
	
	/**
	 * 跳转到订单货物更新页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toupdateproduct.action")
	public String toUpdateProduct(String id ,String orderNo , Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");

		Map<String,Object> paraMap1 = new HashMap<String,Object>();
		paraMap1.put("tenantId", curuser.getTenantId());	
		
		//准备客户下拉列表
		List<Custom> customList = this.customService.find(paraMap1);
		//准备货物下拉列表
		List<Product> productList = this.productService.find(paraMap1);
		
		//获取销售订单记录
		SaleOrder obj = this.saleOrderService.get(id);
		
		//返回到页面
		model.addAttribute("customList",customList);
		model.addAttribute("productList",productList);
		model.addAttribute("obj",obj);
		
		//传递订单ID
		model.addAttribute("orderNo",orderNo);
		
		
		return "/cargo/saleorder/jSOProductUpdate.jsp";
	}
	/**
	 * 更新采购原材料信息
	 * @param purchaseOrder
	 * @return
	 */
	@RequestMapping("/updateproduct.action")
	public String updateProduct(SaleOrder saleOrder,String orderNo , Model model){

		this.saleOrderService.update(saleOrder);
		
		//传递订单ID到 --  新增+列表页面
		return "redirect:/cargo/saleorder/toaddproduct.action?orderNo="+orderNo;
	}
	/**
	 * 删除订单下原材料信息
	 * @param id
	 * @param orderId
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteproduct.action")
	public String deleteProduct(String id ,String orderNo , Model model){

		this.saleOrderService.deleteById(id);

		//跳转到订单原材料添加页面,同时传递订单的编号
		return "redirect:/cargo/saleorder/toaddproduct.action?orderNo="+orderNo;
	}
}

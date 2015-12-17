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

import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.baseinfo.service.ProductService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.sysadmin.vo.UserVo;

@Controller
@RequestMapping("/baseinfo/product")
public class ProductController extends BaseController {

	@Resource
	ProductService productService ;
	//存放列表信息
	private List<Product> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,HttpSession session ){
		
		//获取租户信息
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		dataList = productService.find(paraMap);
		model.addAttribute("dataList",dataList);
		
		return "/baseinfo/product/jProductList.jsp" ; 
	}
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		Product obj = this.productService.get(id);
		model.addAttribute("obj",obj);

		return "/baseinfo/product/jProductView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(){
		return "/baseinfo/product/jProductCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(Product product,HttpSession session){
		
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		product.setTenantId(tenantId);
		
		this.productService.insert(product);
		
		return "redirect:/baseinfo/product/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model){
		Product obj = this.productService.get(id);
		model.addAttribute("obj",obj);
		
		return "/baseinfo/product/jProductUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(Product product){
		this.productService.update(product);
		return "redirect:/baseinfo/product/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.productService.deleteById(id);
		return "redirect:/baseinfo/product/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.productService.delete(ids);
		return "redirect:/baseinfo/product/list.action";
	}
}

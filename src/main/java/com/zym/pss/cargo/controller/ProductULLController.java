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

import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.baseinfo.po.Repository;
import com.zym.pss.baseinfo.service.ProductService;
import com.zym.pss.baseinfo.service.RepositoryService;
import com.zym.pss.cargo.po.ProductULL;
import com.zym.pss.cargo.service.ProductULLService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.core.pargination.Page;
import com.zym.pss.sysadmin.vo.UserVo;

@Controller
@RequestMapping("/cargo/productull")
public class ProductULLController extends BaseController {

	@Resource
	ProductULLService productULLService ;
	@Resource
	RepositoryService repositoryService;
	@Resource
	ProductService productService ; 
	
	//存放列表信息
	private List<ProductULL> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,Integer pageNo){
//		dataList  = productULLService.find(null);
		
//------------------------------------分页操作----------------------------------------
		Page<ProductULL> page = new Page<ProductULL>();
		if(pageNo != null){
			page.setPageNo(pageNo);			//获取页面传递过来的页号
		}
		
		dataList = productULLService.findPage(page);
		model.addAttribute("pageLinks", page.pageLinks("list.action"));		//返回翻页的的HTML语句
		
//------------------------------------------------------------------------------------
				
		
		
		model.addAttribute("dataList",dataList);
		
		return "/cargo/productull/jProductULLList.jsp" ; 
	}
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		ProductULL obj = this.productULLService.get(id);
		model.addAttribute("obj",obj);
		
		return "/cargo/productull/jProductULLView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		//准备仓库信息 下拉列表
		List<Repository> repositoryList = this.repositoryService.find(paraMap);
		//准备货物信息下拉列表
		List<Product> productList = this.productService.find(paraMap);
		//返回到JSP页面
		model.addAttribute("repositoryList", repositoryList);
		model.addAttribute("productList", productList);
		
		return "/cargo/productull/jProductULLCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(ProductULL ull,HttpSession session ){
		//获取租户信息
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		ull.setTenantId(tenantId);
		
		this.productULLService.insert(ull);
		
		return "redirect:/cargo/productull/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model,HttpSession session){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		//准备仓库信息 下拉列表
		List<Repository> repositoryList = this.repositoryService.find(paraMap);
		//准备货物信息下拉列表
		List<Product> productList = this.productService.find(paraMap);
		ProductULL obj = this.productULLService.get(id);
		
		//返回到JSP页面
		model.addAttribute("repositoryList", repositoryList);
		model.addAttribute("productList", productList);
		model.addAttribute("obj",obj);
		
		return "/cargo/productull/jProductULLUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(ProductULL ull){
		this.productULLService.update(ull);
		System.out.println(ull.getMemo());
		return "redirect:/cargo/productull/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.productULLService.deleteById(id);
		return "redirect:/cargo/productull/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.productULLService.delete(ids);
		return "redirect:/cargo/productull/list.action";
	}
}

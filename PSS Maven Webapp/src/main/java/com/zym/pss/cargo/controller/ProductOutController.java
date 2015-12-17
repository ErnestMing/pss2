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
import com.zym.pss.cargo.po.ProductOut;
import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.service.ProductOutService;
import com.zym.pss.cargo.service.StockService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.core.pargination.Page;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.util.UtilFuns;

@Controller
@RequestMapping("/cargo/productout")
public class ProductOutController extends BaseController {

	@Resource
	ProductOutService productOutService; // 货物出库Service
	@Resource
	ProductService productService; // 原材料Service
	@Resource
	StockService stockService; // 库存Service
	@Resource
	RepositoryService repositoryService; // 仓库Service

	// 存放列表信息
	private List<ProductOut> dataList;

	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,Integer pageNo) {
//		dataList = productOutService.find(null);
		
//------------------------------------分页操作----------------------------------------
		Page<ProductOut> page = new Page<ProductOut>();
		if(pageNo != null){
			page.setPageNo(pageNo);			//获取页面传递过来的页号
		}
		
		dataList = productOutService.findPage(page);
		model.addAttribute("pageLinks", page.pageLinks("list.action"));		//返回翻页的的HTML语句
		
//------------------------------------------------------------------------------------
				
		
		model.addAttribute("dataList", dataList);

		return "/cargo/productout/jProductOutList.jsp";
	}

	@RequestMapping("/toview.action")
	public String toview(String id, Model model) {
		ProductOut obj = this.productOutService.get(id);
		model.addAttribute("obj", obj);

		return "/cargo/productout/jProductOutView.jsp";
	}

	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(Model model) {
		// 准备货物下拉列表
		List<Product> productList = this.productService.find(null);
		// 准备原材料仓库下拉列表
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("type", "2");
		List<Repository> repositoryList = this.repositoryService.find(paraMap);
		model.addAttribute("productList", productList);
		model.addAttribute("repositoryList", repositoryList);
		
		return "/cargo/productout/jProductOutCreate.jsp";
	}

	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(ProductOut productOut,HttpSession session ) {
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		productOut.setTenantId(tenantId);
		
		this.productOutService.insert(productOut);

		return "redirect:/cargo/productout/list.action";
	}

	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id, Model model) {
		//获取要更新的对象
		ProductOut obj = this.productOutService.get(id);
		
		if(obj.getState() == 0 ){
			model.addAttribute("obj", obj);
			
			// 准备原材料下拉列表
			List<Product> productList = this.productService.find(null);
			// 准备原材料仓库下拉列表
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("type", "2");
			List<Repository> repositoryList = this.repositoryService.find(paraMap);
			model.addAttribute("productList", productList);
			model.addAttribute("repositoryList", repositoryList);

			return "/cargo/productout/jProductOutUpdate.jsp";
		}else{
			return "redirect:/cargo/productout/list.action";
		}
	}

	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(ProductOut productOut) {
		this.productOutService.update(productOut);
		return "redirect:/cargo/productout/list.action";
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id) {
		this.productOutService.deleteById(id);
		return "redirect:/cargo/productout/list.action";
	}

	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id") String[] ids) {
		for(int i = 0 ; i<ids.length;i++){
			ProductOut po = productOutService.get(ids[i]);
			if(po.getState() == 0 ){
				this.productOutService.delete(new String[]{ids[i]});
			}
		}
		return "redirect:/cargo/productout/list.action";
	}

	/**
	 * 上报出库单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/start.action")
	public String start(@RequestParam("id") String[] ids,Model model,HttpSession session ) {
		//获取当前用户信息
		User curuser = (User) session.getAttribute("CURUSER");
		
		//库存操作结果信息
		String msg  = "" ;			
		// 原材料入库操作
		for(int i = 0 ; i<ids.length;i++){
			ProductOut m = productOutService.get(ids[i]);		//获取原材料入库单
			
			if(m.getState() == 0 ){								//当状态为 未登记状态时 进行 操作
				Stock st = stockService.findByGoodNo(curuser.getTenantId(),m.getProductNo(),m.getRepositoryNo());		//通过货物编号,查询库存记录
				
				//如果库存中没有记录,添加库存
				if(UtilFuns.isNotEmpty(st)){	
					if(st.getAmount() < m.getProductAmount()){
						msg = "%>_<% 库存不足!";
					}else{
						stockService.updateStockAmount(curuser.getTenantId(),m.getProductNo(),m.getRepositoryNo(),st.getAmount()-m.getProductAmount());
						msg = "O(∩_∩)O~~ 库存记录已修改!!";
						//修改库存记录状态
						this.productOutService.updateState(new String[]{ids[i]}, 1);
					}
				}else{									//如果库存中有记录,更新库存量
					msg = "%>_<% 无库存记录!";
				}
			}else{
				msg = "%>_<% 该出库单已被登记过!! 请认真核实~~";
			}
		}
		//返回到结果页面
		model.addAttribute("msg", msg);
		model.addAttribute("listUrl", "list.action");
		return "/exception/error.jsp";
	}

	/**
	 * 取消订单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/cancel.action")
	public String cancel(@RequestParam("id") String[] ids) {
		this.productOutService.updateState(ids, 0);
		return "redirect:/cargo/productout/list.action";
	}
}

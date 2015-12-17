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

import com.zym.pss.baseinfo.po.Material;
import com.zym.pss.baseinfo.po.Repository;
import com.zym.pss.baseinfo.service.MaterialService;
import com.zym.pss.baseinfo.service.RepositoryService;
import com.zym.pss.cargo.po.MaterialOut;
import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.service.MaterialOutService;
import com.zym.pss.cargo.service.StockService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.core.pargination.Page;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.util.UtilFuns;

@Controller
@RequestMapping("/cargo/materialout")
public class MaterialOutController extends BaseController {

	@Resource
	MaterialOutService materialOutService ;		//原材料出库Service
	@Resource
	MaterialService materialService ;		//原材料Service
	@Resource
	StockService stockService ;			//库存Service 
	@Resource
	RepositoryService repositoryService ; //仓库Service
	
	//存放列表信息
	private List<MaterialOut> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,Integer pageNo,HttpSession session ){
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		/*Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("state", 0);			//查询 没有上报的出库单表
		prarMap.put("tenantId",curuser.getTenantId());
		
		dataList = materialOutService.find(paraMap);*/
//		dataList = materialOutService.find(null);
		
//------------------------------------分页操作----------------------------------------
		Page<MaterialOut> page = new Page<MaterialOut>();
		if(pageNo != null){
			page.setPageNo(pageNo);			//获取页面传递过来的页号
		}
		
		dataList = materialOutService.findPage(page);
		model.addAttribute("pageLinks", page.pageLinks("list.action"));		//返回翻页的的HTML语句
		
//------------------------------------------------------------------------------------
				
		model.addAttribute("dataList",dataList);
		
		return "/cargo/materialout/jMaterialOutList.jsp" ; 
	}
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		MaterialOut obj = this.materialOutService.get(id);
		model.addAttribute("obj",obj);

		return "/cargo/materialout/jMaterialOutView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(Model model,HttpSession session ){
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		
		Map<String,Object> tenantIdMap = new HashMap<String,Object>();
		tenantIdMap.put("tenantId", curuser.getTenantId());
		
		//准备原材料下拉列表
		List<Material> materialList = this.materialService.find(tenantIdMap);
		
		// 准备原材料仓库下拉列表
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("type", "1");
		paraMap.put("tenantId", curuser.getTenantId());
		
		List<Repository> repositoryList = this.repositoryService.find(paraMap);
		
		model.addAttribute("materialList",materialList);
		model.addAttribute("repositoryList",repositoryList);
		return "/cargo/materialout/jMaterialOutCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(MaterialOut materialOut,HttpSession session ){
		
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		materialOut.setTenantId(tenantId);
		
		this.materialOutService.insert(materialOut);
		return "redirect:/cargo/materialout/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model,HttpSession session){
		
		MaterialOut obj = this.materialOutService.get(id);
		if(obj.getState() == 0 ){
			model.addAttribute("obj",obj);

			//获取租户信息
			User curuser = (User) session.getAttribute("CURUSER");
			
			Map<String,Object> tenantIdMap = new HashMap<String,Object>();
			tenantIdMap.put("tenantId", curuser.getTenantId());
			
			//准备原材料下拉列表
			List<Material> materialList = this.materialService.find(tenantIdMap);
			// 准备原材料仓库下拉列表
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("type", "1");
			paraMap.put("tenantId", curuser.getTenantId());
			
			List<Repository> repositoryList = this.repositoryService.find(paraMap);
			
			model.addAttribute("materialList",materialList);
			model.addAttribute("repositoryList",repositoryList);
			return "/cargo/materialout/jMaterialOutUpdate.jsp";
		}else{
			return "redirect:/cargo/materialout/list.action";
		}
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(MaterialOut MaterialOut){
		this.materialOutService.update(MaterialOut);
		return "redirect:/cargo/materialout/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.materialOutService.deleteById(id);
		return "redirect:/cargo/materialout/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		for(int i = 0;i<ids.length;i++){
			MaterialOut mo = materialOutService.get(ids[i]);
			if(mo.getState()==0){
				this.materialOutService.delete(new String[]{ids[i]});
			}
		}
		return "redirect:/cargo/materialout/list.action";
	}
	/**
	 * 上报订单
	 * @param id
	 * @return
	 */
	@RequestMapping("/start.action")
	public String start(@RequestParam("id")String[] ids,Model model,HttpSession session ){
		
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		
		//库存操作结果信息
		String msg  = "" ;			
		//原材料出库操作:减少库存量
		for(int i = 0 ; i<ids.length;i++){
			MaterialOut m = materialOutService.get(ids[i]);		//获取原材料入库单
			
			if(m.getState() == 0 ){							//当状态为 未登记状态时 进行 操作
				Stock st = stockService.findByGoodNo(m.getMaterialNo(),m.getRepositoryNo(),curuser.getTenantId());		//通过货物编号,查询库存记录
				
				//如果库存中没有记录,添加库存
				if(UtilFuns.isNotEmpty(st)){	
					if(st.getAmount() < m.getMaterialAmount()){
						msg = "%>_<% 库存不足!";
					}else{
						stockService.updateStockAmount(curuser.getTenantId(),m.getMaterialNo(),m.getRepositoryNo(),st.getAmount()-m.getMaterialAmount());
						msg = "O(∩_∩)O~~ 库存记录已修改!!";
						//更新出库单状态
						this.materialOutService.updateState(new String[]{ids[i]},1);
					}
				}else{									//如果库存中有记录,更新库存量
					msg = "%>_<% 无库存记录!!";
				}
			}else{
				msg = "%>_<% 该出库单已被登记过!! 请认真核实~~" ; 
			}
		}
		//返回到结果页面
		model.addAttribute("msg", msg);
		model.addAttribute("listUrl", "list.action");
		return "/exception/error.jsp";
	}
	/**
	 * 取消订单
	 * @param ids
	 * @return
	 */
	@RequestMapping("/cancel.action")
	public String cancel(@RequestParam("id")String[] ids){
		this.materialOutService.updateState(ids,0);
		return "redirect:/cargo/materialout/list.action";
	}
}

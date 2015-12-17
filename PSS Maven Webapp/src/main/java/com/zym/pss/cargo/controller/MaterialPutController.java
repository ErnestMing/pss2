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
import com.zym.pss.cargo.po.MaterialPut;
import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.service.MaterialPutService;
import com.zym.pss.cargo.service.StockService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.core.pargination.Page;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.util.UtilFuns;

@Controller
@RequestMapping("/cargo/materialput")
public class MaterialPutController extends BaseController {

	@Resource
	MaterialPutService materialPutService; // 原材料出库Service
	@Resource
	MaterialService materialService; // 原材料Service
	@Resource
	StockService stockService; // 库存Service
	@Resource
	RepositoryService repositoryService; // 仓库Service

	// 存放列表信息
	private List<MaterialPut> dataList;

	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,Integer pageNo) {
//		dataList = materialPutService.find(null);
		
//------------------------------------分页操作----------------------------------------
		Page<MaterialPut> page = new Page<MaterialPut>();
		if(pageNo != null){
			page.setPageNo(pageNo);			//获取页面传递过来的页号
		}
		
		dataList = materialPutService.findPage(page);
		model.addAttribute("pageLinks", page.pageLinks("list.action"));		//返回翻页的的HTML语句
		
//------------------------------------------------------------------------------------
				
		
		
		model.addAttribute("dataList", dataList);

		return "/cargo/materialput/jMaterialPutList.jsp";
	}

	@RequestMapping("/toview.action")
	public String toview(String id, Model model) {
		MaterialPut obj = this.materialPutService.get(id);
		model.addAttribute("obj", obj);

		return "/cargo/materialput/jMaterialPutView.jsp";
	}

	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(Model model) {
		// 准备原材料下拉列表
		List<Material> materialList = this.materialService.find(null);
		// 准备原材料仓库下拉列表
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("type", "1");
		List<Repository> repositoryList = this.repositoryService.find(paraMap);
		model.addAttribute("materialList", materialList);
		model.addAttribute("repositoryList", repositoryList);
		
		return "/cargo/materialput/jMaterialPutCreate.jsp";
	}

	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(MaterialPut materialPut,HttpSession session ) {

		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		materialPut.setTenantId(tenantId);
		
		this.materialPutService.insert(materialPut);

		return "redirect:/cargo/materialput/list.action";
	}

	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id, Model model) {
		
		//获取要更新的对象
		MaterialPut obj = this.materialPutService.get(id);
		if(obj.getState()==0){					//当入库单状态为未登记状态时,才可以修改入库单信息
			model.addAttribute("obj", obj);
			// 准备原材料下拉列表
			List<Material> materialList = this.materialService.find(null);
			// 准备原材料仓库下拉列表
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("type", "1");
			List<Repository> repositoryList = this.repositoryService.find(paraMap);
			model.addAttribute("materialList", materialList);
			model.addAttribute("repositoryList", repositoryList);

			return "/cargo/materialput/jMaterialPutUpdate.jsp";			//跳到更新页面
		}else{		
			return "redirect:/cargo/materialput/list.action";			//跳到列表页面
		}
		
		
	}

	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(MaterialPut materialPut) {
		this.materialPutService.update(materialPut);			
		return "redirect:/cargo/materialput/list.action";
	}

	/**
	 * 删除
	 */
/*	@RequestMapping("/deleteById.action")
	public String deleteById(String id) {
		this.materialPutService.deleteById(id);
		return "redirect:/cargo/materialput/list.action";
	}*/

	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id") String[] ids) {
		for(int i = 0 ; i<ids.length;i++){
			MaterialPut mp = materialPutService.get(ids[i]);
			if(mp.getState()==0){						//当入库单状态为未登记状态时,才可以删除入库单
				this.materialPutService.delete(new String[]{ids[i]});
			}
		}
		return "redirect:/cargo/materialput/list.action";
	}

	/**
	 * 上报出库单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/start.action")
	public String start(@RequestParam("id") String[] ids,Model model,HttpSession session ) {
		//获取用户信息
		User curuser  = (User) session.getAttribute("CURUSER");
		
		//库存操作结果信息
		String msg  = "" ;			
		
		// 原材料入库操作
		for(int i = 0 ; i<ids.length;i++){
			MaterialPut mp = materialPutService.get(ids[i]);		//获取原材料入库单
			
			if(mp.getState() == 0 ){							//当状态为 未登记状态时 进行 操作
				Stock stock = new Stock() ; 					//创建库存记录
				stock.setGoodsNo(mp.getMaterialNo());
				stock.setGoodsName(mp.getMaterialName());
				stock.setGoodsType("1");
				stock.setAmount(mp.getMaterialAmount());
				stock.setRepositoryNo(mp.getRepositoryNo());	
				stock.setPackingUnit(mp.getPackingUnit());
				
				Stock st = stockService.findByGoodNo(curuser.getTenantId(),mp.getMaterialNo(),mp.getRepositoryNo());		//通过货物编号,查询库存记录
				//如果库存中没有记录,添加库存
				
				if(UtilFuns.isNotEmpty(st)){		
					Double amount = mp.getMaterialAmount()+stock.getAmount();
					stockService.updateStockAmount(curuser.getTenantId(),mp.getMaterialNo(),mp.getRepositoryNo(),amount);
					msg = "O(∩_∩)O~~ 原材料入库成功!!";
				}else{									//如果库存中有记录,更新库存量
					stockService.insert(stock);					//添加到库存中
					msg = "O(∩_∩)O~~ 库存记录创建成功!!";
				}
				//更新入库单状态
				this.materialPutService.updateState(new String[]{ids[i]}, 1);
			}else{
				msg = "%>_<% 该入库单已被登记过!! 请认真核实~~";
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
		this.materialPutService.updateState(ids, 0);
		return "redirect:/cargo/materialput/list.action";
	}
}

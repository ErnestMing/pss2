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
import com.zym.pss.cargo.po.MaterialULL;
import com.zym.pss.cargo.service.MaterialULLService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.core.pargination.Page;
import com.zym.pss.sysadmin.vo.UserVo;

@Controller
@RequestMapping("/cargo/materialull")
public class MaterialULLController extends BaseController {

	@Resource
	MaterialULLService materialULLService ;
	@Resource
	RepositoryService repositoryService;
	@Resource
	MaterialService materialService ; 
	
	//存放列表信息
	private List<MaterialULL> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,Integer pageNo){
//		dataList  = materialULLService.find(null);
		
//------------------------------------分页操作----------------------------------------
		Page<MaterialULL> page = new Page<MaterialULL>();
		if(pageNo != null){
			page.setPageNo(pageNo);			//获取页面传递过来的页号
		}
		
		dataList = materialULLService.findPage(page);
		model.addAttribute("pageLinks", page.pageLinks("list.action"));		//返回翻页的的HTML语句
		
//------------------------------------------------------------------------------------
				
		
		model.addAttribute("dataList",dataList);
		
		return "/cargo/materialull/jMaterialULLList.jsp" ; 
	}
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		MaterialULL obj = this.materialULLService.get(id);
		model.addAttribute("obj",obj);
		
		return "/cargo/materialull/jMaterialULLView.jsp";
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
		//准备原材料信息下拉列表
		List<Material> materialList = this.materialService.find(paraMap);
		//返回到JSP页面
		model.addAttribute("repositoryList", repositoryList);
		model.addAttribute("materialList", materialList);
		
		return "/cargo/materialull/jMaterialULLCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(MaterialULL materialULL,HttpSession session ){
		//获取租户信息
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		materialULL.setTenantId(tenantId);
		
		this.materialULLService.insert(materialULL);
		
		return "redirect:/cargo/materialull/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model,HttpSession session ){
		//获取当前用户
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		//准备仓库信息 下拉列表
		List<Repository> repositoryList = this.repositoryService.find(paraMap);
		//准备原材料信息下拉列表
		List<Material> materialList = this.materialService.find(paraMap);
		MaterialULL obj = this.materialULLService.get(id);
		
		//返回到JSP页面
		model.addAttribute("repositoryList", repositoryList);
		model.addAttribute("materialList", materialList);
		model.addAttribute("obj",obj);
		
		return "/cargo/materialull/jMaterialULLUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(MaterialULL materialULL){
		this.materialULLService.update(materialULL);
		return "redirect:/cargo/materialull/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.materialULLService.deleteById(id);
		return "redirect:/cargo/materialull/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.materialULLService.delete(ids);
		return "redirect:/cargo/materialull/list.action";
	}
}

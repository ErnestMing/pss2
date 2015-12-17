package com.zym.pss.multiTenant.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.multiTenant.po.Subsciber;
import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.multiTenant.service.SubsciberService;
import com.zym.pss.multiTenant.vo.SubsciberVo;
import com.zym.pss.sysadmin.service.FunctionService;
import com.zym.pss.sysadmin.vo.FunctionVO;
import com.zym.pss.core.controller.BaseController;

@Controller
@RequestMapping("/multitenant/subsciber")
public class SubsciberController extends BaseController {

	@Resource
	SubsciberService subsciberService ;				//订购服务Service
	@Resource
	FunctionService functionService ; 				//服务信息
	
	//存放列表信息
	private List<Subsciber> dataList ;	
	
	/**
	 * 我的服务
	 */
	@RequestMapping("/myservicelist.action")
	public String myServiceList(Model model,HttpSession session){
		//获取当前登录的租户信息
		Tenant tenant = (Tenant) session.getAttribute("CUR_TENANT");
		
		//查询当前租户服务列表
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", tenant.getId());
		
		List<SubsciberVo> dataList = subsciberService.findSubsciberVoList(paraMap);
		model.addAttribute("dataList",dataList);
		
		return "/multitenant/subsciber/jSubsciberList.jsp" ; 
	}
	/**
	 * 服务查询
	 */
	@RequestMapping("/servicelist.action")
	public String serviceList(Model model){
		//查询所有服务列表
		List<FunctionVO> dataList = functionService.findFunctionVO(null);
		model.addAttribute("dataList",dataList);
		
		return "/multitenant/subsciber/jSubsciber.jsp" ; 
	}
	/**
	 * 查看详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		Subsciber obj = this.subsciberService.get(id);
		model.addAttribute("obj",obj);

		return "/multitenant/subsciber/jSubsciberView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(Model model ){
		
		return "/multitenant/subsciber/jSubsciberCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(Subsciber Subsciber){
		
		this.subsciberService.insert(Subsciber);
		
		return "redirect:/multitenant/subsciber/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model){
		
		Subsciber obj = this.subsciberService.get(id);
		model.addAttribute("obj",obj);
		
		return "/multitenant/subsciber/jSubsciberUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(Subsciber Subsciber){
		this.subsciberService.update(Subsciber);
		return "redirect:/multitenant/subsciber/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.subsciberService.deleteById(id);
		return "redirect:/multitenant/subsciber/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.subsciberService.delete(ids);
		return "redirect:/multitenant/subsciber/myservicelist.action";
	}
	
	
	//订购服务
	@RequestMapping("/subsciberService.action")
	public String subsciberService (Subsciber subsciber,HttpSession session,Model model){

		if(subsciber.getBeginDate()!=null&&subsciber.getEndDate()!= null){
			//获取当前租户
			Tenant tenant = (Tenant) session.getAttribute("CUR_TENANT");
			String tenantId = tenant.getId();
			
			//订购服务
			subsciber.setTenantId(tenantId);			//设置租户ID
			subsciber.setSupsciberDate(new Date());		//设置订购日期
			
			subsciberService.insert(subsciber);
		}else{
			return "redirect:/multitenant/subsciber/servicelist.action";
		}
		return "redirect:/multitenant/subsciber/myservicelist.action";
	}
}

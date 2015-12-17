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

import com.zym.pss.baseinfo.po.Repository;
import com.zym.pss.baseinfo.service.RepositoryService;
import com.zym.pss.core.controller.BaseController;
import com.zym.pss.sysadmin.po.User;
import com.zym.pss.sysadmin.vo.UserVo;

@Controller
@RequestMapping("/baseinfo/repository")
public class RepositoryController extends BaseController {

	@Resource
	RepositoryService repositoryService ;
	//存放列表信息
	private List<Repository> dataList ;		
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list.action")
	public String list(Model model,HttpSession session ){
		//获取租户信息
		UserVo curuser = (UserVo) session.getAttribute("CURUSER");
		
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("tenantId", curuser.getTenantId());
		
		dataList = repositoryService.find(paraMap);
		model.addAttribute("dataList",dataList);
		
		return "/baseinfo/repository/jRepositoryList.jsp" ; 
	}
	@RequestMapping("/toview.action")
	public String toview(String id , Model model){
		Repository obj = this.repositoryService.get(id);
		model.addAttribute("obj",obj);
		
		return "/baseinfo/repository/jRepositoryView.jsp";
	}
	/**
	 * 跳到添加页面
	 */
	@RequestMapping("/tocreate.action")
	public String tocreate(){
		return "/baseinfo/repository/jRepositoryCreate.jsp";
	}
	/**
	 * 添加
	 */
	@RequestMapping("/insert.action")
	public String create(Repository repository,HttpSession session){
		//获取租户信息
		User curuser = (User) session.getAttribute("CURUSER");
		String tenantId = curuser.getTenantId() ; 
		
		repository.setTenantId(tenantId);
		
		this.repositoryService.insert(repository);
		
		return "redirect:/baseinfo/repository/list.action";
	}
	/**
	 * 跳到更新页面
	 */
	@RequestMapping("/toupdate.action")
	public String toupdate(String id,Model model){
		Repository obj = this.repositoryService.get(id);
		model.addAttribute("obj",obj);
		
		return "/baseinfo/repository/jRepositoryUpdate.jsp";
	}
	/**
	 * 更新
	 */
	@RequestMapping("/update.action")
	public String update(Repository repository){
		this.repositoryService.update(repository);
		System.out.println(repository.getMemo());
		return "redirect:/baseinfo/repository/list.action";
	}
	/**
	 * 删除
	 */
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		this.repositoryService.deleteById(id);
		return "redirect:/baseinfo/repository/list.action";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		this.repositoryService.delete(ids);
		return "redirect:/baseinfo/repository/list.action";
	}
}

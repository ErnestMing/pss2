package com.zym.pss.core.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zym.pss.multiTenant.po.Subsciber;
import com.zym.pss.multiTenant.po.Tenant;
import com.zym.pss.multiTenant.service.SubsciberService;
import com.zym.pss.multiTenant.service.TenantService;
import com.zym.pss.sysadmin.po.Function;
import com.zym.pss.sysadmin.service.FunctionService;
import com.zym.pss.sysadmin.service.UserService;
import com.zym.pss.sysadmin.vo.FunctionVO;
import com.zym.pss.sysadmin.vo.RoleVo;
import com.zym.pss.sysadmin.vo.UserVo;
import com.zym.pss.util.UtilFuns;

@Controller
public class HomeController {

	@Resource
	UserService userService ; 			//租户下客户Service
	@Resource
	TenantService tenantService ;		//租户Service 
	@Resource
	FunctionService functionService ; 	//服务Service
	@Resource
	SubsciberService subsciberService ; //服务订购Service
	
//----------------------------------------------------------租户管理员界面------------------------------------------------------------
	@RequestMapping("/tenantadminframe.action")
	public String tenantAdminFrame(HttpSession session){
		return "/multimm/fmain.jsp";
	}
	
	@RequestMapping(value="/tenantadmintitle.action")
	public String tenantAdminTitle(){
		return "/multimm/title.jsp";
	}
	//首页左侧菜单	Left
	@RequestMapping(value="/tenantadminleft.action")
	public String tenantAdminLeft(){
		return "/multimm/left.jsp";
	}
	//首页主题部分	Main
	@RequestMapping(value="/tenantadminmain.action")
	public String tenantAdminMain(){
		return "/multimm/olmsgList.jsp";			//首页转向留言板
	}
	
	
	//1.租户管理模块
	@RequestMapping("/tenantadminMain.action")
	public String tenantadminMain(){
		return "/multimm/tenantadmin/main.jsp";
	}
	
	@RequestMapping("/tenantadminLeft.action")
	public String tenantadminLeft(){
		return "/multimm/tenantadmin/left.jsp";
	}
	
	//2.服务管理模块
	@RequestMapping("/servicemanageMain.action")
	public String pricepolicyMain(){
		return "/multimm/servicemanage/main.jsp";
	}
	@RequestMapping("/servicemanageLeft.action")
	public String pricepolicyLeft(){
		return "/multimm/servicemanage/left.jsp";
	}
	
//----------------------------------------------------SaaS平台租户级别---------------------------------------------------------------
	//跳转到租户登录界面
	@RequestMapping(value="/tenant.action")
	public String tenantLogin(Model model,Integer loginFailed){
		model.addAttribute("loginFailed",loginFailed );
		return "/tenant_index.jsp";
	}
	
	//跳转到租户个人首页(验证)
	@RequestMapping(value="/tenantframe.action")
	public String tenantFrame(HttpSession session,String tenantNo, String password,Model model){
		
		//判断输入的租户账号和密码是否为空
		if(UtilFuns.isNotEmpty(tenantNo)&&UtilFuns.isNotEmpty(password)){
			//将租户信息放入Session中
			Map<String,Object> paraMap = new HashMap<String,Object>();
			paraMap.put("tenantNo", tenantNo);
			paraMap.put("password", password);
			
			List<Tenant> tenants = tenantService.find(paraMap);
			if(UtilFuns.isNotEmpty(tenants)){

				Tenant tenant = tenants.get(0);
				//将租户信息放入到Session中
				session.setAttribute("CUR_TENANT", tenant);
				//判断租户是否为 	租户管理员(tenantadmin)
				if("tenantadmin".equals(tenant.getTenantNo())){
					return "/multimm/fmain.jsp";				//跳转到租户管理员页面
				}else{
					//判断租户的状态是否为: 2 :禁用 
					if(tenant.getState()==2){
						return "redirect:/toservicechoose.action";		//跳转到服务订购页面
					}else{			//非禁用状态
						tenantService.updateState(new String[]{tenant.getId()}, 3);		//修改状态为 已登录
						return "/multitenant/fmain.jsp";
					}
				}
			}else{
				return "redirect:/tenant.action?loginFailed=1";
			}
		}else{
			return "redirect:/tenant.action?loginFailed=2";
		}
	}
	/**
	 * 跳转到租户个人首页(不验证),用于租户注册后直接登录,并且将租户的状态修改为登录状态
	 * @param tenantId  租户ID
	 * @return
	 */
	@RequestMapping("/tenantframe2.action")
	public String tenantFrame(HttpSession session){
		
		//获取当前用户
		Tenant tenant = (Tenant) session.getAttribute("CUR_TENANT");
		//将租户的状态设置为 已登录
		tenantService.updateState(new String[]{tenant.getId()},3);
		
		return "/multitenant/fmain.jsp";
	}
	
	@RequestMapping(value="/tenanttitle.action")
	public String tenantTitle(){
		return "/multitenant/title.jsp";
	}
	//首页左侧菜单	Left
	@RequestMapping(value="/tenantleft.action")
	public String tenantLeft(){
		return "/multitenant/left.jsp";
	}
	//首页主题部分	Main
	@RequestMapping(value="/tenantmain.action")
	public String tenantMain(){
		return "/multitenant/olmsgList.jsp";			//首页转向留言板
	}
	
	
	//1.注册模块
	//跳转到租户注册页面
	@RequestMapping(value="/toreg.action")
	public String totenantreg(){
		return "/multitenant/reg/jCreateTenant.jsp";
	}
	
	//注册
	@RequestMapping(value="/reg.action")
	public String reg(HttpSession session , Tenant tenant,String confirmPass,Model model){
		if(tenant.getTenantNo()==null || "".equals(tenant.getTenantNo())){
			model.addAttribute("error_tenantNo", "租户账号不能为空");
			model.addAttribute("obj", tenant);
			return "/multitenant/reg/jCreateTenant.jsp";
		}
		if(tenant.getName()==null || "".equals(tenant.getName())){
			model.addAttribute("error_name", "租户名不能为空");
			model.addAttribute("obj", tenant);
			return "/multitenant/reg/jCreateTenant.jsp";
		}
		if(tenant.getPassword()==null || "".equals(tenant.getPassword()) || !tenant.getPassword().matches("[0-9a-zA-Z]{6,14}")){
			model.addAttribute("error_password", "密码不能为空,并且为6-14为数字或字母组成");
			model.addAttribute("obj", tenant);
			return "/multitenant/reg/jCreateTenant.jsp";
		}
		if(confirmPass==null || "".equals(confirmPass)){
			model.addAttribute("error_confirmPass", "2次输入密码不一致");
			model.addAttribute("obj", tenant);
			return "/multitenant/reg/jCreateTenant.jsp";
		}
		//判断2次输入的密码是否相同
		if(!tenant.getPassword().equals(confirmPass)){
			model.addAttribute("error_confirmPass", "2次输入密码不一致");
			model.addAttribute("obj", tenant);
			return "/multitenant/reg/jCreateTenant.jsp";
		}
		//判断租户账号是否存在
		Tenant find = tenantService.findByTenantNo(tenant.getTenantNo());
		if(find != null ){
			model.addAttribute("error_name", "租户已经存在");
			model.addAttribute("obj", tenant);
			return "/multitenant/reg/jCreateTenant.jsp";
		}
		
		//添加租户
		tenantService.insert(tenant);
		Tenant t = tenantService.findByTenantNo(tenant.getTenantNo());
		
		//将租户放入到Session
		session.setAttribute("CUR_TENANT", t);
		
		return "redirect:/toservicechoose.action";
	}
	
	//跳转到服务选择页面
	@RequestMapping(value="/toservicechoose.action")
	public String toservicechoose(Model model){
		//获取服务列表
		List<FunctionVO> functionList = functionService.findFunctionVO(null);
		
		model.addAttribute("functionList", functionList);
		
		return "/multitenant/reg/jChooseService.jsp";
	}
	/**
	 * @param tenantId    通过租户基本信息注册界面传递而来
	 * @param functionIds 租户选取服务的ID
	 * @param startDates  服务开始时间
	 * @param endDates	    服务结束时间
	 * @return
	 */
	@RequestMapping(value="/servicechoose.action")
	public String serviceChoose(HttpSession session ,  @RequestParam("id")String[] functionIds , 
			@RequestParam("startDate")String[] startDates ,@RequestParam("endDate")String[] endDates){
		try {
			//获取租户信息
			Tenant tenant = (Tenant) session.getAttribute("CUR_TENANT");
			//构建服务订单
			if(functionIds != null){
				Subsciber subsciber = null  ; 
 				for(int i = 0 ; i< functionIds.length;i++){
					//判断输入日期是否为空
					if(UtilFuns.isNotEmpty(startDates[i])&&UtilFuns.isNotEmpty(endDates[i])){
						subsciber  = new Subsciber() ; 
						subsciber.setFunctionId(functionIds[i]);		//设置订购记录ID	
						subsciber.setBeginDate(new SimpleDateFormat("yyyy-MM-dd").parse(startDates[i]));				//设置开始日期
						subsciber.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(endDates[i]));					//设置终止日期
						subsciber.setSupsciberDate(new Date());				//设置订购日期
						subsciber.setTenantId(tenant.getId());				//设置租户ID
						
						//添加服务订购记录
						subsciberService.insert(subsciber);
					}else{
						return "redirect:/toservicechoose.action";
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		return "redirect:/tosuccess.action";
	}
	
	//跳转到租户注册完成页面
	@RequestMapping(value="/tosuccess.action")
	public String success(){
		return "/multitenant/reg/jSuccess.jsp";
	}
	
	//2.租户个人信息模块
	@RequestMapping("/infoMain.action")
	public String infoMain(){
		return "/multitenant/info/main.jsp";
	}
	@RequestMapping("/infoLeft.action")
	public String infoLeft(){
		return "/multitenant/info/left.jsp";
	}

	//3.服务订购模块
	@RequestMapping("/subsciberMain.action")
	public String serviceMain(){
		return "/multitenant/subsciber/main.jsp";
	}
	@RequestMapping("/subsciberLeft.action")
	public String serviceLeft(){
		return "/multitenant/subsciber/left.jsp";
	}
	
	//4.用户配置模块(本质是:租户下的系统管理(将租户作为系统管理员,同时进行租户的配置))
	@RequestMapping("/userconfMain.action")
	public String userconfMain(){
		return "/multitenant/userconf/main.jsp";
	}
	
	@RequestMapping("/userconfLeft.action")
	public String userconfLeft(){
		return "/multitenant/userconf/left.jsp";
	}
	
//-----------------------------------------------------租户下管理-----------------------------------------------------
	//跳转到用户登录
	
	@RequestMapping(value={"/user.action"})		//配合web下<url-pattern>/</url-pattern>
	public String userLogin(HttpSession session ){
		
		//判断租户服务是否到期
		//******************************************************************************************************************************************
		//******************************************************************************************************************************************
		//******************************************************************************************************************************************
		
		session.invalidate();		//退出时,设置Session失效
		
		return "/user_index.jsp";			//首页，删除根目录下index.jsp，否则上面url将被拦截进不来
	}
	//用户登录
	@RequestMapping(value="/userfmain.action")
	public String userFmain(HttpSession session ,Model model ,String tenantNo , String userName , String password){
	
		//获取Session中的当前用户

		UserVo curUser = (UserVo) session.getAttribute("CURUSER");
		
		//避免进入系统后 点击 [系统首页] , 时,空指针异常
		if(curUser == null ){
			//获取用户所在公司注册的租户
			Tenant tenant = tenantService.findByTenantNo(tenantNo);
			//通过用户名和密码查询用户VO 租户
			UserVo user = userService.findByUserNameAndPass(tenant.getId(),userName,password);

			if(UtilFuns.isNotEmpty(user)){
				session.setAttribute("CURUSER", user);				//将用户放入到Session
				
				List<Function> funcList = new ArrayList<Function>();		//将用户角色的权限通过Set集合存放到Session中(去除重复)
				for(RoleVo roleVo:user.getUserRoles()){
					for(Function func :roleVo.getRoleFuncs()){
						if(!funcList.contains(func)){					//Function实体类重写HashCode和Equals方法, 从而去除重复的Object
							
							//判断该功能服务是否到期
							
							funcList.add(func); 
						}
					}
				}
				session.setAttribute("mainMenu", funcList);
			}else{
				model.addAttribute("loginFailed", 1);				//错误标识 1 用户名或密码错误
				return "/user_index.jsp";
			}
		}
		
		return "/user/fmain.jsp";
	}
	
	
	//首页导航	Title（当点击导航菜单时，更改左侧菜单JSP和内容区域JSP）
	@RequestMapping(value="/title.action")
	public String title(){
		return "/user/title.jsp";
	}
	//首页左侧菜单	Left
	@RequestMapping(value="/left.action")
	public String left(){
		return "/user/left.jsp";
	}
	//首页主题部分	Main
	@RequestMapping(value="/main.action")
	public String main(){
		return "/user/olmsgList.jsp";			//首页转向留言板
	}
	
	//1.系统管理模块
	
	@RequestMapping("/sysadminMain.action")
	public String sysadminMain(){
		return "/sysadmin/main.jsp";
	}
	
	@RequestMapping("/sysadminLeft.action")
	public String sysadminLeft(){
		return "/sysadmin/left.jsp";
	}
	
	//2.基础信息模块
	
	@RequestMapping("/baseinfoMain.action")
	public String baseinfoMain(){
		return "/baseinfo/main.jsp";
	}
	
	@RequestMapping("/baseinfoLeft.action")
	public String baseinfoLeft(){
		return "/baseinfo/left.jsp";
	}
	
	//3.业务管理模块
	
	@RequestMapping("/cargoMain.action")
	public String cargoMain(){
		return "/cargo/main.jsp";
	}
	
	@RequestMapping("/cargoLeft.action")
	public String cargoLeft(){
		return "/cargo/left.jsp";
	}
	
	//4.订单管理
	
	@RequestMapping("/orderMain.action")
	public String orderMain(){
		return "/order/main.jsp";
	}
	
	@RequestMapping("/orderLeft.action")
	public String orderLeft(){
		return "/order/left.jsp";
	}
	
	//5.采购管理模块
	
	@RequestMapping("/purchaseMain.action")
	public String purchaseMain(){
		return "/purchase/main.jsp";
	}
	@RequestMapping("/purchaseLeft.action")
	public String purchaseLeft(){
		return "/purchase/left.jsp";
	}
	
	//6.销售管理模块
	
	@RequestMapping("/saleMain.action")
	public String saleMain(){
		return "/sale/main.jsp";
	}
	@RequestMapping("/saleLeft.action")
	public String saleLeft(){
		return "/sale/left.jsp";
	}
	
	//7.库存管理模块
	
	@RequestMapping("/stockMain.action")
	public String stockMain(){
		return "/stock/main.jsp";
	}
	@RequestMapping("/stockLeft.action")
	public String stockLeft(){
		return "/stock/left.jsp";
	}
}

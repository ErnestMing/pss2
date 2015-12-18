package com.zym.pss.sysadmin.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zym.pss.sysadmin.po.Function;

/**
 * @Description:用户VO类
 * @Author: zym
 * @CreateDate: 2015年12月3日
 */
public class UserVo implements Serializable{

	private static final long serialVersionUID = 6461973779470975121L;
	
	private String id ; 			//用户ID
	
	List<RoleVo> userRoles = new ArrayList<RoleVo>();
	
	private String userNo ; 		//用户编号
	private String password ; 		//密码
	private String telephone ; 		//联系方式
	private String email ; 			//邮箱
	private String address ; 		//地址
	private Integer status ; 		//状态
	private String tenantId ; 		//所属租户ID

//-------------------------------权限方法
		/**
		 * 判断用户是否为超级管理员
		 * @return
		 */
		public boolean isAdmin(){
			if("admin".equals(userNo)){
				return  true ; 
			}
			return false ; 
		}
		/**
		 * 通过functionName判断用户是否有权限
		 * @param functionName
		 * @return
		 */
		public boolean hasPrivilegeByName(String functionName) {
			//判断是否是超级管理员
			if(isAdmin()){
				return true ; 
			}
			//普通用户判断是否含有这个权限
			for(RoleVo role :userRoles){
				for(Function func :role.getRoleFuncs()){
					if(functionName.equals(func.getFunctionName())){
						return true ; 
					}
				}
			}
			return false;
		}
		/**
		 * 通过URL判断用户是否有权限
		 * @param functionUrl
		 * @return
		 */
		public boolean hasPrivilegeByUrl(String functionUrl) {
			//判断用户是否是超级管理员
			if(isAdmin()){
				return true ; 
			}
			//普通用户判断是否有这个权限
			for(RoleVo role : userRoles){
				for(Function func :role.getRoleFuncs()){
					if(functionUrl.equals(func.getFunctionURL())){
						return true ; 
					}
				}
			}
			return false;
		}
//-----------------------Getter/Setter
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public List<RoleVo> getUserRoles() {
			return userRoles;
		}
		public void setUserRoles(List<RoleVo> userRoles) {
			this.userRoles = userRoles;
		}
		public String getUserNo() {
			return userNo;
		}
		public void setUserNo(String userNo) {
			this.userNo = userNo;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getTenantId() {
			return tenantId;
		}
		public void setTenantId(String tenantId) {
			this.tenantId = tenantId;
		}
		
}

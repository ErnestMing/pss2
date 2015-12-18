package com.zym.pss.cargo.po;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @Description:订单表
 * @Author: zym
 * @CreateDate: 2015年11月18日
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 956085306604887270L;

	private String id ; 			//ID
	private String orderNo ; 		//订单编号
	private String type ;	 		//订单类型	1:原材料采购, 2 :产品销售
	private Integer state ; 		//订单状态
	private String orderer ; 		//下订单单位
	private String input ; 			//制单人
	private Date purchaseTime ; 	//采购日期
	private String memo ; 			//备注
	
	private String tenantId ; 		//所属租户
	
	public static String ORDER_STATE_ONE ="未上报"; 
	public static String ORDER_STATE_TWO ="待审核"; 
	public static String ORDER_STATE_THREE ="审核通过"; 
	
	public static Map<String,Object> ORDER_STATE_MAP  = new HashMap<String,Object>();
	static{
		ORDER_STATE_MAP.put("1", ORDER_STATE_ONE);
		ORDER_STATE_MAP.put("2", ORDER_STATE_TWO);
		ORDER_STATE_MAP.put("3", ORDER_STATE_THREE);
	}
	
	public Order() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getOrderer() {
		return orderer;
	}
	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}

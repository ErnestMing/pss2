package com.zym.pss.cargo.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zym.pss.cargo.dao.OrderDao;
import com.zym.pss.cargo.dao.PurchaseOrderDao;
import com.zym.pss.cargo.dao.SaleOrderDao;
import com.zym.pss.cargo.po.Order;
import com.zym.pss.cargo.service.OrderService;
import com.zym.pss.core.service.impl.BaseServiceImpl;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{
	
	OrderDao orderDao ;
	@Resource
	public void setOrderDao(OrderDao orderDao) {
		super.setBaseDao(orderDao);
		this.orderDao = orderDao;
	}
	@Resource
	PurchaseOrderDao purchaseOrderDao ; 
	@Resource
	SaleOrderDao saleOrderDao ; 
	
	@Override
	public void insert(Order entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState(1);		//设置订单状态为草稿
		this.orderDao.insert(entity);
	}

	@Override
	public void updateState(String[] ids,Integer state) {
		Map<String,Object> paramMap = new HashMap<String , Object>();
		paramMap.put("state", state);
		paramMap.put("ids", ids);
		this.orderDao.updateState(paramMap);
	}
	
	@Override
	public void delete(String tenantId , Serializable[] ids) {
		Map<String,Object> paraMap = null ; 
		for(int i = 0 ; i<ids.length;i++){
			Order order = this.orderDao.get(ids[i]);
			paraMap = new HashMap<String,Object>();
			paraMap.put("tenantId", tenantId);
			paraMap.put("orderNo", order.getOrderNo());
			
			if("1".equals(order.getType())){		//采购订单
				this.purchaseOrderDao.deleteByOrderNo(paraMap);			//删除订单下,所有要采购的原材料
			}
			if("2".equals(order.getType())){		//销售订单	
				this.saleOrderDao.deleteByOrderNo(paraMap);			//删除销售订单中,涉及到的销售订单
			}
		}
		this.orderDao.delete(ids);		//删除订单信息
	}

}	

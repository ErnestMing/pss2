package com.zym.pss.baseinfo.service;

import com.zym.pss.baseinfo.po.Product;
import com.zym.pss.core.service.BaseService;

public interface ProductService extends BaseService<Product> {

	/**
	 * 通过货物编号获取货物信息
	 * @param productNo
	 * @return
	 */
	public Product findByProductNo(String productNo);
	
}

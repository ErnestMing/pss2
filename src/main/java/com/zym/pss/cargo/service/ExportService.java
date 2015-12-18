package com.zym.pss.cargo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zym.pss.cargo.po.PurchaseOrder;
import com.zym.pss.cargo.po.SaleOrder;
import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.vo.StockWarning;

public interface ExportService {
	/**
	 * 打印原材料下限预警报表
	 * @param path
	 * @param dataList
	 * @param request
	 * @param response
	 */
	public void exportML(String path, List<StockWarning>  dataList , HttpServletRequest request , HttpServletResponse response);
	/**
	 * 打印原材料上限预警报表
	 * @param path
	 * @param dataList
	 * @param request
	 * @param response
	 */
	public void exportMU(String path,List<StockWarning>  dataList , HttpServletRequest request , HttpServletResponse response);
	/**
	 * 打印货物下限预警报表
	 * @param path
	 * @param dataList
	 * @param request
	 * @param response
	 */
	public void exportPL(String path,List<StockWarning>  dataList , HttpServletRequest request , HttpServletResponse response);
	/**
	 * 打印货物上限预警报表
	 * @param path
	 * @param dataList
	 * @param request
	 * @param response
	 */
	public void exportPU(String path,List<StockWarning>  dataList , HttpServletRequest request , HttpServletResponse response);
	/**
	 * 打印 库存信息报表
	 * @param path
	 * @param stockList
	 * @param request
	 * @param response
	 */
	public void exporStock(String path, List<Stock> stockList,HttpServletRequest request, HttpServletResponse response);
	/**
	 * 打印货物的月销售情况
	 * @param path
	 * @param productOutList
	 * @param request
	 * @param response
	 */
	public void exporSE(String path, List<SaleOrder> dataList,HttpServletRequest request, HttpServletResponse response);
	public void exportPE(String path, List<PurchaseOrder> dataList,HttpServletRequest request, HttpServletResponse response);
}

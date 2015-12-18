package com.zym.pss.cargo.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.zym.pss.cargo.po.PurchaseOrder;
import com.zym.pss.cargo.po.SaleOrder;
import com.zym.pss.cargo.po.Stock;
import com.zym.pss.cargo.service.ExportService;
import com.zym.pss.cargo.vo.StockWarning;

@Service("exportService")
public class ExportServiceImpl  implements ExportService {

	//工作簿
	private Workbook wb ;
	//工作表
	private Sheet sheet ;
	//行
	private Row nrow  ; 
	//单元格
	private Cell ncell ; 

	@Override
	public void exporSE(String path, List<SaleOrder> dataList,HttpServletRequest request, HttpServletResponse response) {
		try {
			//创建工作簿
			wb = new XSSFWorkbook(new FileInputStream(new File(path+"/sale.xlsx")));
			//创建工作表
			sheet = wb.getSheetAt(0);

			int rowNo = 0 ; 		//行号
			int colNo = 1 ; 		//列号
			
			//大标题
			nrow = sheet.getRow(rowNo++);
			ncell = nrow.getCell(colNo++);
			
			//获取当前日期yyyy-MM-dd
			String curDate = new SimpleDateFormat("yyyy-MM").format(dataList.get(0).getSaleTime());
			ncell.setCellValue(curDate.replaceFirst("-0", "-").replaceFirst("-", "年")+"月" + ncell.getStringCellValue());
			
			//跳过列标题
			rowNo++;
			
			//获取模板行数据列样式
			nrow = sheet.getRow(rowNo);
			CellStyle cs01 = nrow.getCell(1).getCellStyle();
			CellStyle cs02 = nrow.getCell(2).getCellStyle();
			CellStyle cs03 = nrow.getCell(3).getCellStyle();
			CellStyle cs04 = nrow.getCell(4).getCellStyle();
			CellStyle cs05= nrow.getCell(5).getCellStyle();
			CellStyle cs06 = nrow.getCell(6).getCellStyle();
			CellStyle cs07= nrow.getCell(7).getCellStyle();
			CellStyle cs08= nrow.getCell(8).getCellStyle();
			CellStyle cs09= nrow.getCell(9).getCellStyle();
			
			//填充数据
			for(int i = 0 ; i < dataList.size();i++){
				//行数据
				SaleOrder obj = dataList.get(i);
				//行对象
				nrow = sheet.getRow(rowNo++);
				
				//重置列号
				colNo = 1; 
				
				//序号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs01);
				ncell.setCellValue(i+1);
				//订单编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs02);
				ncell.setCellValue(obj.getSalesOrderNo());
				//客户名称
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs03);
				ncell.setCellValue(obj.getCustomName());
				//货物编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs04);
				ncell.setCellValue(obj.getProductNo());
				//货物名称
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs05);
				ncell.setCellValue(obj.getProductName());
				//货物数量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs06);
				ncell.setCellValue(obj.getProductAmount()+"/"+obj.getPackingUnit());
				//销售日期
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs07);
				ncell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(obj.getSaleTime()));
				//有效起日
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs08);
				ncell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(obj.getValidStartTime()));
				//有效止日
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs09);
				ncell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(obj.getValidEndTime()));
			}
			//将内存中的excel数据写入文件中
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			wb.write(bos);
			
			//提供数据下载
			response.setContentType("application/octet-stream;charset=utf-8");
			//保存的文件名,必须和页面编码一直
			String returnName = response.encodeURL(new String("货物月销售统计报表.xlsx".getBytes(),"iso8859-1"));
			response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
			response.setContentLength(bos.size());
			
			ServletOutputStream outputStream = response.getOutputStream();
			bos.writeTo(outputStream);

			bos.close();
			outputStream.flush();
			outputStream.close();
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void exportPE(String path, List<PurchaseOrder> dataList,HttpServletRequest request, HttpServletResponse response) {
		try {
			//创建工作簿
			wb = new XSSFWorkbook(new FileInputStream(new File(path+"/purchase.xlsx")));
			//创建工作表
			sheet = wb.getSheetAt(0);

			int rowNo = 0 ; 		//行号
			int colNo = 1 ; 		//列号
			
			//大标题
			nrow = sheet.getRow(rowNo++);
			ncell = nrow.getCell(colNo++);
			
			//获取当前日期yyyy-MM-dd
			String curDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			ncell.setCellValue(curDate.replaceFirst("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月") + ncell.getStringCellValue());
			
			//跳过列标题
			rowNo++;
			
			//获取模板行数据列样式
			nrow = sheet.getRow(rowNo);
			CellStyle cs01 = nrow.getCell(1).getCellStyle();
			CellStyle cs02 = nrow.getCell(2).getCellStyle();
			CellStyle cs03 = nrow.getCell(3).getCellStyle();
			CellStyle cs04 = nrow.getCell(4).getCellStyle();
			CellStyle cs05= nrow.getCell(5).getCellStyle();
			CellStyle cs06 = nrow.getCell(6).getCellStyle();
			CellStyle cs07= nrow.getCell(7).getCellStyle();
			
			//填充数据
			for(int i = 0 ; i < dataList.size();i++){
				//行数据
				PurchaseOrder obj = dataList.get(i);
				//行对象
				nrow = sheet.getRow(rowNo++);
				
				//重置列号
				colNo = 1; 
				
				//序号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs01);
				ncell.setCellValue(i+1);
				//订单编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs02);
				ncell.setCellValue(obj.getPurchaseOrderNo());
				//原材料编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs03);
				ncell.setCellValue(obj.getMaterialNo());
				//原材料名称
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs04);
				ncell.setCellValue(obj.getMaterialName());
				//提供商名称
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs05);
				ncell.setCellValue(obj.getSupplierName());
				//原材料数量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs06);
				ncell.setCellValue(obj.getMaterialAmount()+"/"+obj.getPackingUnit());
				//采购日期
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs07);
				ncell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(obj.getPurchaseTime()));
			}
			//将内存中的excel数据写入文件中
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			wb.write(bos);
			
			//提供数据下载
			response.setContentType("application/octet-stream;charset=utf-8");
			//保存的文件名,必须和页面编码一直
			String returnName = response.encodeURL(new String("原材料月采购统计报表.xlsx".getBytes(),"iso8859-1"));
			response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
			response.setContentLength(bos.size());
			
			ServletOutputStream outputStream = response.getOutputStream();
			bos.writeTo(outputStream);

			bos.close();
			outputStream.flush();
			
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exporStock(String path, List<Stock> stockList,HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	@Override
	public void exportML(String path, List<StockWarning> dataList ,HttpServletRequest request,HttpServletResponse response) {
		try {
			//创建工作簿
			wb = new XSSFWorkbook(new FileInputStream(new File(path+"/stockwarning_ml.xlsx")));
			//创建工作表
			sheet = wb.getSheetAt(0);

			int rowNo = 0 ; 		//行号
			int colNo = 1 ; 		//列号
			
			//大标题
			nrow = sheet.getRow(rowNo++);
			ncell = nrow.getCell(colNo++);
			
			//获取当前日期yyyy-MM-dd
			String curDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			ncell.setCellValue(curDate.replaceFirst("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月") + ncell.getStringCellValue());
			
			//跳过列标题
			rowNo++;
			
			//获取模板行数据列样式
			nrow = sheet.getRow(rowNo);
			CellStyle cs01 = nrow.getCell(1).getCellStyle();
			CellStyle cs02 = nrow.getCell(2).getCellStyle();
			CellStyle cs03 = nrow.getCell(3).getCellStyle();
			CellStyle cs04 = nrow.getCell(4).getCellStyle();
			CellStyle cs05= nrow.getCell(5).getCellStyle();
			CellStyle cs06 = nrow.getCell(6).getCellStyle();
			CellStyle cs07= nrow.getCell(7).getCellStyle();
			
			//填充数据
			for(int i = 0 ; i < dataList.size();i++){
				//行数据
				StockWarning obj = dataList.get(i);
				//行对象
				nrow = sheet.getRow(rowNo++);
				
				//重置列号
				colNo = 1; 
				
				//序号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs01);
				ncell.setCellValue(i+1);
				//仓库编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs02);
				ncell.setCellValue(obj.getRepositoryNo());
				//物品编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs03);
				ncell.setCellValue(obj.getGoodsNo());
				//物品名称
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs04);
				ncell.setCellValue(obj.getGoodsName());
				//物品类型
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs05);
				ncell.setCellValue(obj.getGoodsType());
				//当前库存量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs06);
				ncell.setCellValue(obj.getAmount());
				//预警数量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs07);
				ncell.setCellValue(obj.getOverLowerAmount()+"/"+obj.getPackingUnit());
			}
			//将内存中的excel数据写入文件中
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			wb.write(bos);
			
			//提供数据下载
			response.setContentType("application/octet-stream;charset=utf-8");
			//保存的文件名,必须和页面编码一直
			String returnName = response.encodeURL(new String("原材料下限预警.xlsx".getBytes(),"iso8859-1"));
			response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
			response.setContentLength(bos.size());
			
			ServletOutputStream outputStream = response.getOutputStream();
			bos.writeTo(outputStream);

			bos.close();
			outputStream.flush();
			
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exportMU(String path, List<StockWarning>  dataList,HttpServletRequest request, HttpServletResponse response) {
		try {
			//创建工作簿
			wb = new XSSFWorkbook(new FileInputStream(new File(path+"/stockwarning_mu.xlsx")));
			//创建工作表
			sheet = wb.getSheetAt(0);

			int rowNo = 0 ; 		//行号
			int colNo = 1 ; 		//列号
			
			//大标题
			nrow = sheet.getRow(rowNo++);
			ncell = nrow.getCell(colNo++);
			
			//获取当前日期yyyy-MM-dd
			String curDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			ncell.setCellValue(curDate.replaceFirst("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月") + ncell.getStringCellValue());
			
			//跳过列标题
			rowNo++;
			
			//获取模板行 数据列样式
			nrow = sheet.getRow(rowNo);
			CellStyle cs01 = nrow.getCell(1).getCellStyle();
			CellStyle cs02 = nrow.getCell(2).getCellStyle();
			CellStyle cs03 = nrow.getCell(3).getCellStyle();
			CellStyle cs04 = nrow.getCell(4).getCellStyle();
			CellStyle cs05= nrow.getCell(5).getCellStyle();
			CellStyle cs06 = nrow.getCell(6).getCellStyle();
			CellStyle cs07= nrow.getCell(7).getCellStyle();
			
			//填充数据
			for(int i = 0 ; i < dataList.size();i++){
				//行数据
				StockWarning obj = dataList.get(i);
				//行对象
				nrow = sheet.getRow(rowNo++);
				
				//重置列号
				colNo = 1; 
				
				//序号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs01);
				ncell.setCellValue(i+1);
				//仓库编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs02);
				ncell.setCellValue(obj.getRepositoryNo());
				//物品编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs03);
				ncell.setCellValue(obj.getGoodsNo());
				//物品名称
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs04);
				ncell.setCellValue(obj.getGoodsName());
				//物品类型
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs05);
				ncell.setCellValue(obj.getGoodsType());
				//当前库存量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs06);
				ncell.setCellValue(obj.getAmount());
				//预警数量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs07);
				ncell.setCellValue(obj.getOverUpperAmount()+"/"+obj.getPackingUnit());
			}
			//将内存中的excel数据写入文件中
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			wb.write(bos);
			
			//提供数据下载
			response.setContentType("application/octet-stream;charset=utf-8");
			//保存的文件名,必须和页面编码一直
			String returnName = response.encodeURL(new String("原材料上限预警.xlsx".getBytes(),"iso8859-1"));
			response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
			response.setContentLength(bos.size());
			
			ServletOutputStream outputStream = response.getOutputStream();
			bos.writeTo(outputStream);

			bos.close();
			outputStream.flush();
			
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void exportPL(String path, List<StockWarning>  dataList,HttpServletRequest request, HttpServletResponse response) {
		try {
			//创建工作簿
			wb = new XSSFWorkbook(new FileInputStream(new File(path+"/stockwarning_pl.xlsx")));
			//创建工作表
			sheet = wb.getSheetAt(0);

			int rowNo = 0 ; 		//行号
			int colNo = 1 ; 		//列号
			
			//大标题
			nrow = sheet.getRow(rowNo++);
			ncell = nrow.getCell(colNo++);
			
			//获取当前日期yyyy-MM-dd
			String curDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			ncell.setCellValue(curDate.replaceFirst("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月") + ncell.getStringCellValue());
			
			//跳过列标题
			rowNo++;
			
			//获取模板行数据列样式
			nrow = sheet.getRow(rowNo);
			CellStyle cs01 = nrow.getCell(1).getCellStyle();
			CellStyle cs02 = nrow.getCell(2).getCellStyle();
			CellStyle cs03 = nrow.getCell(3).getCellStyle();
			CellStyle cs04 = nrow.getCell(4).getCellStyle();
			CellStyle cs05= nrow.getCell(5).getCellStyle();
			CellStyle cs06 = nrow.getCell(6).getCellStyle();
			CellStyle cs07= nrow.getCell(7).getCellStyle();
			
			//填充数据
			for(int i = 0 ; i < dataList.size();i++){
				//行数据
				StockWarning obj = dataList.get(i);
				//行对象
				nrow = sheet.getRow(rowNo++);
				
				//重置列号
				colNo = 1; 
				
				//序号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs01);
				ncell.setCellValue(i+1);
				//仓库编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs02);
				ncell.setCellValue(obj.getRepositoryNo());
				//物品编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs03);
				ncell.setCellValue(obj.getGoodsNo());
				//物品名称
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs04);
				ncell.setCellValue(obj.getGoodsName());
				//物品类型
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs05);
				ncell.setCellValue(obj.getGoodsType());
				//当前库存量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs06);
				ncell.setCellValue(obj.getAmount());
				//预警数量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs07);
				ncell.setCellValue(obj.getOverLowerAmount()+"/"+obj.getPackingUnit());
			}
			//将内存中的excel数据写入文件中
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			wb.write(bos);
			
			//提供数据下载
			response.setContentType("application/octet-stream;charset=utf-8");
			//保存的文件名,必须和页面编码一直
			String returnName = response.encodeURL(new String("货物下限预警.xlsx".getBytes(),"iso8859-1"));
			response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
			response.setContentLength(bos.size());
			
			ServletOutputStream outputStream = response.getOutputStream();
			bos.writeTo(outputStream);

			bos.close();
			outputStream.flush();
			
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exportPU(String path, List<StockWarning> dataList,HttpServletRequest request, HttpServletResponse response) {
		try {
			//创建工作簿
			wb = new XSSFWorkbook(new FileInputStream(new File(path+"/stockwarning_pu.xlsx")));
			//创建工作表
			sheet = wb.getSheetAt(0);

			int rowNo = 0 ; 		//行号
			int colNo = 1 ; 		//列号
			
			//大标题
			nrow = sheet.getRow(rowNo++);
			ncell = nrow.getCell(colNo++);
			
			//获取当前日期yyyy-MM-dd
			String curDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			ncell.setCellValue(curDate.replaceFirst("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月") + ncell.getStringCellValue());
			
			//跳过列标题
			rowNo++;
			
			//获取模板行数据列样式
			nrow = sheet.getRow(rowNo);
			CellStyle cs01 = nrow.getCell(1).getCellStyle();
			CellStyle cs02 = nrow.getCell(2).getCellStyle();
			CellStyle cs03 = nrow.getCell(3).getCellStyle();
			CellStyle cs04 = nrow.getCell(4).getCellStyle();
			CellStyle cs05= nrow.getCell(5).getCellStyle();
			CellStyle cs06 = nrow.getCell(6).getCellStyle();
			CellStyle cs07= nrow.getCell(7).getCellStyle();
			
			//填充数据
			for(int i = 0 ; i < dataList.size();i++){
				//行数据
				StockWarning obj = dataList.get(i);
				//行对象
				nrow = sheet.getRow(rowNo++);
				
				//重置列号
				colNo = 1; 
				
				//序号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs01);
				ncell.setCellValue(i+1);
				//仓库编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs02);
				ncell.setCellValue(obj.getRepositoryNo());
				//物品编号
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs03);
				ncell.setCellValue(obj.getGoodsNo());
				//物品名称
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs04);
				ncell.setCellValue(obj.getGoodsName());
				//物品类型
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs05);
				ncell.setCellValue(obj.getGoodsType());
				//当前库存量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs06);
				ncell.setCellValue(obj.getAmount());
				//预警数量
				ncell = nrow.createCell(colNo++);
				ncell.setCellStyle(cs07);
				ncell.setCellValue(obj.getOverUpperAmount()+"/"+obj.getPackingUnit());
			}
			//将内存中的excel数据写入文件中
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			wb.write(bos);
			
			//提供数据下载
			response.setContentType("application/octet-stream;charset=utf-8");
			//保存的文件名,必须和页面编码一直
			String returnName = response.encodeURL(new String("货物上限预警.xlsx".getBytes(),"iso8859-1"));
			response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
			response.setContentLength(bos.size());
			
			ServletOutputStream outputStream = response.getOutputStream();
			bos.writeTo(outputStream);

			bos.close();
			outputStream.flush();
			
			wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

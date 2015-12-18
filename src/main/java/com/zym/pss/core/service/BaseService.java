package com.zym.pss.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.zym.pss.core.pargination.Page;

public interface BaseService<T> {
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	public List<T> findPage(Page page);	
	/**
	 * 带条件查询，条件可以为null，既没有条件；返回list对象集合
	 * @param paraMap
	 * @return
	 */
	public List<T> find(Map paraMap);				
	/**
	 * 只查询一个，常用于修改
	 * @param id
	 * @return
	 */
	public T get(Serializable id);					
	/**
	 * 插入，用实体作为参数
	 * @param factory
	 */
	public void insert(T entity);					
	/**
	 * 修改，用实体作为参数
	 * @param factory
	 */
	public void update(T entity);					
	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param id
	 */
	public void deleteById(Serializable id);	
	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param ids
	 */
	public void delete(Serializable[] ids);
}

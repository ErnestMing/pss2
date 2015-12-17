package com.zym.pss.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.zym.pss.core.pargination.Page;

public interface BaseDao<T> {
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	public List<T> findPage(Page page);				
	/**
	 * 查询所有数据
	 * @param map
	 * @return
	 */
	public List<T> find(Map map);
	/**
	 * 只查询一个，常用于修改
	 * @param id
	 * @return
	 */
	public T get(Serializable id);					
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public void insert(T entity);					
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public void update(T entity);					
	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param id
	 */
	public void deleteById(Serializable id);		//
	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param ids
	 */
	public void delete(Serializable[] ids);			
}

package com.zym.pss.sysadmin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zym.pss.sysadmin.dao.FunctionDao;
import com.zym.pss.sysadmin.po.Function;
import com.zym.pss.sysadmin.vo.FunctionVO;
import com.zym.pss.core.dao.impl.BaseDaoImpl;

@Repository("resourceDao")
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {

	//设置命名空间
	public FunctionDaoImpl() {
		super.setNs("com.zym.pss.sysadmin.mapper.FunctionMapper");
	}

	@Override
	public List<FunctionVO> findFunctionVo(Map<String, Object> paraMap) {
		return super.getSqlSession().selectList(super.getNs()+".findVO", paraMap);
	}
}

package com.zym.pss.sysadmin.dao;

import java.util.List;
import java.util.Map;

import com.zym.pss.sysadmin.po.Function;
import com.zym.pss.sysadmin.vo.FunctionVO;
import com.zym.pss.core.dao.BaseDao;

public interface FunctionDao extends BaseDao<Function> {

	List<FunctionVO> findFunctionVo(Map<String, Object> paraMap);

}

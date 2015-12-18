package com.zym.pss.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.zym.pss.sysadmin.po.Function;
import com.zym.pss.sysadmin.vo.FunctionVO;
import com.zym.pss.core.service.BaseService;

public interface FunctionService extends BaseService<Function> {

	List<FunctionVO> findFunctionVO(Map<String,Object> paraMap);
	
}

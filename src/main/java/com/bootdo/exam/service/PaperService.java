package com.bootdo.exam.service;

import com.bootdo.exam.domain.PaperDO;

import java.util.List;
import java.util.Map;

/**
 * 试卷表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
public interface PaperService {
	
	PaperDO get(Long id);

	PaperDO getPlus(Long id);
	
	List<PaperDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PaperDO paper);
	
	int update(PaperDO paper);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

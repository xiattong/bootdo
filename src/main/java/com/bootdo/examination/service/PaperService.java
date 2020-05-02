package com.bootdo.examination.service;

import com.bootdo.examination.domain.PaperDO;

import java.util.List;
import java.util.Map;

/**
 * 考试试卷
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-01 13:18:59
 */
public interface PaperService {
	
	PaperDO get(String id);
	
	List<PaperDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PaperDO paper);
	
	int update(PaperDO paper);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}

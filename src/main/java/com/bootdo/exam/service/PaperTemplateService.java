package com.bootdo.exam.service;

import com.bootdo.exam.domain.PaperTemplateDO;

import java.util.List;
import java.util.Map;

/**
 * 试卷模板表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
public interface PaperTemplateService {
	
	PaperTemplateDO get(Long id);
	
	List<PaperTemplateDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PaperTemplateDO paperTemplate);
	
	int update(PaperTemplateDO paperTemplate);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

package com.bootdo.examination.service;

import com.bootdo.examination.domain.ManagementDO;

import java.util.List;
import java.util.Map;

/**
 * 文件管理
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-01 22:15:18
 */
public interface ManagementService {
	
	ManagementDO get(String id);
	
	List<ManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ManagementDO management);
	
	int update(ManagementDO management);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}

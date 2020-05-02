package com.bootdo.examination.dao;

import com.bootdo.examination.domain.ManagementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件管理
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-01 22:15:18
 */
@Mapper
public interface ManagementDao {

	ManagementDO get(String id);
	
	List<ManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ManagementDO management);
	
	int update(ManagementDO management);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}

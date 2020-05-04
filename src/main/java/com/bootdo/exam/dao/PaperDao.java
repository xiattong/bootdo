package com.bootdo.exam.dao;

import com.bootdo.exam.domain.PaperDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 试卷表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
@Mapper
public interface PaperDao {

	PaperDO get(Long id);
	
	List<PaperDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PaperDO paper);
	
	int update(PaperDO paper);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

package com.bootdo.examination.dao;

import com.bootdo.examination.domain.PaperDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 考试试卷
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-01 13:18:59
 */
@Mapper
public interface PaperDao {

	PaperDO get(String id);
	
	List<PaperDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PaperDO paper);
	
	int update(PaperDO paper);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}

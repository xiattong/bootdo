package com.bootdo.exam.dao;

import com.bootdo.exam.domain.PaperAnswerDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 答卷表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:09
 */
@Mapper
public interface PaperAnswerDao {

	PaperAnswerDO get(Long id);
	
	List<PaperAnswerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PaperAnswerDO paperAnswer);
	
	int update(PaperAnswerDO paperAnswer);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

package com.bootdo.exam.dao;

import com.bootdo.exam.domain.QuestionBankDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 题库表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-05-03 08:37:10
 */
@Mapper
public interface QuestionBankDao {

	QuestionBankDO get(Long id);
	
	List<QuestionBankDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(QuestionBankDO questionBank);
	
	int update(QuestionBankDO questionBank);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<QuestionBankDO> randomListByType(String questionType,int num);

	List<QuestionBankDO> listByMenu(@Param(value="ids") String ids);
}

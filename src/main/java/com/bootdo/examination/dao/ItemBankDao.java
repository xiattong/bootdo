package com.bootdo.examination.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.examination.domain.ItemBankDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-29 21:36:43
 */
@Mapper
public interface ItemBankDao {

	ItemBankDO get(String id);
	
	List<ItemBankDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ItemBankDO bank);
	
	int update(ItemBankDO bank);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}

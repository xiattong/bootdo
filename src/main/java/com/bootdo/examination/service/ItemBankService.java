package com.bootdo.examination.service;

import com.bootdo.examination.domain.ItemBankDO;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-29 21:36:43
 */
public interface ItemBankService {

    ItemBankDO get(String id);

    List<ItemBankDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ItemBankDO bank);

    int update(ItemBankDO bank);

    int remove(String id);

    int batchRemove(String[] ids);
}

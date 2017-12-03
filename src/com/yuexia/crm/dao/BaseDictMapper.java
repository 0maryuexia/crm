package com.yuexia.crm.dao;

import com.yuexia.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {
    /**
     * 根据类别代码查询数据
     *
     * @param dictTypeCode
     * @return
     */
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}

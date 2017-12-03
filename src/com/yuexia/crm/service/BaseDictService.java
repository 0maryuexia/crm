package com.yuexia.crm.service;

import com.yuexia.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    /**
     * 根据类别代码查询
     *
     * @param dictTypeCode
     * @return
     */
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}

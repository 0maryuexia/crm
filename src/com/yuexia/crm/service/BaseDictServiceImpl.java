package com.yuexia.crm.service;

import com.yuexia.crm.dao.BaseDictMapper;
import com.yuexia.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService{
    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {

        List<BaseDict> list = this.baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
        return list;
    }
}

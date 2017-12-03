package com.yuexia.crm.dao;

import com.yuexia.crm.pojo.Customer;
import com.yuexia.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {
    /**
     * 根据queryVo分页查询数据
     *
     * @param queryVo
     * @return
     */
    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * 根据queryVo查询数据条数
     *
     * @param queryVo
     * @return
     */
    int queryCountByQueryVo(QueryVo queryVo);

}

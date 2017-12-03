package com.yuexia.crm.service;

import com.yuexia.crm.pojo.Customer;
import com.yuexia.crm.pojo.QueryVo;
import com.yuexia.crm.utils.Page;

public interface CustomerService {
    /**
     * 根据条件分页查询客户
     *
     * @param queryVo
     * @return
     */
    Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

}

package com.yuexia.crm.service;

import com.yuexia.crm.dao.CustomerMapper;
import com.yuexia.crm.pojo.Customer;
import com.yuexia.crm.pojo.QueryVo;
import com.yuexia.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

        // 查询数据结果集
        List<Customer> list = this.customerMapper.queryCustomerByQueryVo(queryVo);
        // 查询到的数据总条数
        int total = this.customerMapper.queryCountByQueryVo(queryVo);

        // 封装返回的page对象
        Page<Customer> page = new Page<>(total, queryVo.getPage(), queryVo.getRows(), list);

        return page;
    }


}

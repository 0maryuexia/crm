package com.yuexia.crm.controller;

import com.yuexia.crm.pojo.BaseDict;
import com.yuexia.crm.pojo.Customer;
import com.yuexia.crm.pojo.QueryVo;
import com.yuexia.crm.service.BaseDictService;
import com.yuexia.crm.service.CustomerService;
import com.yuexia.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class yemianContrlloer {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
   private CustomerService customerService;


    // 客户来源
    @Value("${CUSTOMER_FROM_TYPE}")
    private String CUSTOMER_FROM_TYPE;
    // 客户行业
    @Value("${CUSTOMER_INDUSTRY_TYPE}")
    private String CUSTOMER_INDUSTRY_TYPE;
    // 客户级别
    @Value("${CUSTOMER_LEVEL_TYPE}")
    private String CUSTOMER_LEVEL_TYPE;


    @RequestMapping("/customer")
    public String customer(QueryVo queryVo,Model model){

        try {
            // 解决get请求乱码问题
            if (StringUtils.isNotBlank(queryVo.getCustName())) {
                queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        // 客户来源
        List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode(this.CUSTOMER_FROM_TYPE);
        // 所属行业
        List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode(this.CUSTOMER_INDUSTRY_TYPE);
        // 客户级别
        List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode(this.CUSTOMER_LEVEL_TYPE);

        // 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        // 分页查询数据
        Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);
        // 把分页查询的结果放到模型中
        model.addAttribute("page", page);

        // 数据回显
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());

        return "customer";


    }
}

package com.service.imp;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/9/1 21:44
 * @email: wangyuhang_mocas@163.com
 */

import com.dao.CustomerMapper;
import com.domain.Customer;
import com.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *@program: mybatisSpring1
 *@description:
 *@author: mocas_wang
 *@create: 2020-09-01 21:44
 */
@Service("CustomerService")
@Transactional
public class CustomerServiceImp implements CustomerService {
    //注入mapper
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }
    @Override
    public void save(Customer customer)
    {

        //判断是添加还是修改
        if(customer.getId()!=null)
        {
            //如果是修改
            customerMapper.update(customer);
        }
        else
        {
            //增加
            customerMapper.save(customer);
        }


    }

    @Override
    public Customer findById(Integer id) {

        return  customerMapper.findById(id);

    }

    @Override
    public void delete(Integer[] ids) {
        customerMapper.delete(ids);
    }
}

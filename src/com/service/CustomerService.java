package com.service;

import com.domain.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/9/1 21:39
 * @email: wangyuhang_mocas@163.com
 */
public interface CustomerService {
    public List<Customer> findAll();
    public void save(Customer customer);
    public Customer findById(Integer id);
    public void delete(Integer[] ids);

}

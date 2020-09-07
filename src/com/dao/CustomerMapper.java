package com.dao;

import com.domain.Customer;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/8/31 21:15
 * @email: wangyuhang_mocas@163.com
 */
public interface CustomerMapper {
    //产生customer
    public List<Customer> findAll();
    public void save(Customer customer);
    public Customer findById(Integer id);
    public void update(Customer customer);
    public void delete(Integer[] ids);
}

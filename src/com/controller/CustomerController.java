package com.controller;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/9/2 22:01
 * @email: wangyuhang_mocas@163.com
 */

import com.domain.Customer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@program: springMvc
 *@description:
 *@author: mocas_wang
 *@create: 2020-09-02 22:01
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {
    //注入业务对象
    @Resource
    public CustomerService customerService;


    @RequestMapping("/list")
    @ResponseBody //用于转换对象json
    //查询所有数据
    public List<Customer> list(){

        //查询数据
        List<Customer> list=customerService.findAll();
        return list;
    }

    //设计 map聚合存储需要给页面的对象数据
    private Map<String,Object> Result=new HashMap<String, Object>();

    @RequestMapping("/listByPage")
    @ResponseBody
    public Map<String,Object> listByPage(Integer page,Integer rows)
    {
        //设置分页参数
        PageHelper.startPage(page,rows);
        //查询所有数据
        List<Customer> list=customerService.findAll();
        //使用pageInfo封装查询结果
        PageInfo<Customer> pageInfo=new PageInfo<Customer>(list);
        //从PageInfo取出查询结果
        //总记录数
        long total=pageInfo.getTotal();
        //当前页数据列表
        List<Customer> customerList=pageInfo.getList();
        Result.put("total",total);
        Result.put("rows",customerList);
        return Result;


    }


    @RequestMapping("/save")
    @ResponseBody
    //保存数据
    public Map<String,Object> save(Customer customer)
    {
        try
        {
            customerService.save(customer);
            Result.put("success",true);

        }
        catch (Exception e)
        {
            Result.put("success",false);
            Result.put("msg",e.getMessage());

        }
        return  Result;
    }

    /*根据id查询用户 */
    @RequestMapping("/findById")
    @ResponseBody
    public Customer findById(Integer id)
    {
        Customer customer=customerService.findById(id);
        return  customer;
    }

    /*删除用户*/
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,Object> delete(Integer[] id)
    {

        try
        {
            customerService.delete(id);

            Result.put("success",true);

        }
        catch (Exception e)
        {
            Result.put("success",false);
            Result.put("msg",e.getMessage());

        }
        return  Result;
    }
}

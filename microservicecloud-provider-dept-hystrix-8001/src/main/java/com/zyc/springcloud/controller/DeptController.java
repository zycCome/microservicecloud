package com.zyc.springcloud.controller;

import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zyc.springcloud.entitys.Dept;
import com.zyc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeptController
{
    @Autowired
    private DeptService service;

    @PostMapping(value="/dept/add1")
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @GetMapping(value="/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept =  this.service.get(id);
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;

    }

    @GetMapping(value="/dept/list")
    public List<Dept> list()
    {
        return service.list();
    }


    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }



}



package com.zyc.springcloud.controller;

import com.zyc.springcloud.entitys.Dept;
import com.zyc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @GetMapping(value="/dept/list")
    public List<Dept> list()
    {
        return service.list();
    }



}



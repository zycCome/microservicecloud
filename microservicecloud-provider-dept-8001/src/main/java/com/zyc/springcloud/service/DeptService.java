package com.zyc.springcloud.service;

import com.zyc.springcloud.entitys.Dept;

import java.util.List;


public interface DeptService
{
    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();
}



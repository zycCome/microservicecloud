package com.zyc.springcloud.service.impl;

import java.util.List;

import com.zyc.springcloud.dao.DeptDao;
import com.zyc.springcloud.entitys.Dept;
import com.zyc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DeptServiceImpl implements DeptService
{
    @Autowired
    private DeptDao dao ;

    @Override
    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id)
    {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list()
    {
        return dao.findAll();
    }

}

